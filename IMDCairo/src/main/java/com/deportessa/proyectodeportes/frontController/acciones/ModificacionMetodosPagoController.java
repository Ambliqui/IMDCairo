/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.deportessa.proyectodeportes.frontController.acciones;

import com.deportessa.proyectodeportes.frontController.FrontControlerLocal;
import com.deportessa.proyectodeportes.frontController.qualifiers.ModificacionMetodosPagoQ;
import com.deportessa.proyectodeportes.servicios.ActionValidator;
import com.deportessa.proyectodeportes.servicios.qualifiers.ActionValidatorDatosPersonalesImplQ;
import java.io.IOException;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mefisto
 */
@Stateless
@ModificacionMetodosPagoQ
public class ModificacionMetodosPagoController implements FrontControlerLocal {

    @Inject
    @ActionValidatorDatosPersonalesImplQ
    private ActionValidator validatorDatosPersoanles;

    @Override
    public RequestDispatcher getDispatcher(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        List<Exception> exceptions = validatorDatosPersoanles.execute(request, response);

        //Mandamos a la pagina de destino
        if (exceptions.isEmpty()) {
            return request.getRequestDispatcher("/PreMetodosPagoServlet");
        } else {
            //Recuperamos lo que nos ha escrito el cliente para volver a mostrarlo en pantalla
            request.setAttribute("password", request.getParameter("password"));

            //Devolvemos los errores
            request.setAttribute("errores", exceptions);
            return request.getRequestDispatcher("/PreRegistroDatosPersonalesServlet");
        }
    }
}
