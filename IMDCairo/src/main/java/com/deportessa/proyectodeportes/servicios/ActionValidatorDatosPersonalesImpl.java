package com.deportessa.proyectodeportes.servicios;

import com.deportessa.proyectodeportes.metodosPago.MetodoPagoLocal;
import com.deportessa.proyectodeportes.servicios.validaciones.Validaciones;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.deportessa.proyectodeportes.servicios.qualifiers.ActionValidatorDatosPersonalesImplQ;
import java.util.Map;
import javax.ejb.Stateless;

/**
 * Servlet para validar los campos de entrada del formulario de datos personales
 * del Cliente
 *
 * @author Mefisto
 */
@Stateless
@ActionValidatorDatosPersonalesImplQ
public class ActionValidatorDatosPersonalesImpl implements ActionValidator {

    @Inject
    private Validaciones validaciones;

    @Override
    public List<Exception> execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, MetodoPagoLocal> mPago = (Map<String, MetodoPagoLocal>) request.getServletContext().getAttribute("metodosPago");

        List<Exception> exceptions = new ArrayList<>();

        validaciones.longitudCampo("Nombre: ", request.getParameter("nombre"), 4).ifPresent((error) -> exceptions.add(error));
        validaciones.longitudCampo("Apellidos: ", request.getParameter("apellidos"), 4).ifPresent((error) -> exceptions.add(error));
        validaciones.rangoValores("Telefono: ", request.getParameter("telefono"), 111111111, 999999999).ifPresent((error) -> exceptions.add(error));
        
        //TODO: Desacoplar

//        String metodoPago = request.getParameter("metodoPago");
//
//        exceptions.addAll(mPago.get(metodoPago).validar(request, response));
        return exceptions;
    }

}
