/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.deportessa.proyectodeportes.servicios;

import com.deportessa.proyectodeportes.metodosPago.MetodoPagoLocal;
import com.deportessa.proyectodeportes.servicios.qualifiers.ActionMetodoPagoQ;
import com.deportessa.proyectodeportes.servicios.qualifiers.ActionValidatorLoginQ;
import com.deportessa.proyectodeportes.servicios.validaciones.Validaciones;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mefisto
 */
@Stateless
@ActionMetodoPagoQ
public class ActionValidatorMetodoPago implements ActionValidator {

    @Inject
    private Validaciones validaciones;

    @Override
    public List<Exception> execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        Map<String, MetodoPagoLocal> mPago = (Map<String, MetodoPagoLocal>) request.getServletContext().getAttribute("metodosPago");
        List<Exception> exceptions = new ArrayList<>();
        
        String metodoPago = request.getParameter("metodoPago");
        exceptions.addAll(mPago.get(metodoPago).validar(request, response));
        return exceptions;
    }

}
