/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.deportessa.proyectodeportes.servicios;

import com.deportessa.proyectodeportes.metodosPago.MetodoPagoLocal;
import com.deportessa.proyectodeportes.servicios.qualifiers.ActionValidatorMetodosPagoQ;
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
@ActionValidatorMetodosPagoQ
public class ActionValidatorMetodosPagoImpl {

    public class ActionValidatorRegistroUsuarioImpl implements ActionValidator {

        @Override
        public List<Exception> execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            Map<String, MetodoPagoLocal> mPago = (Map<String, MetodoPagoLocal>) request.getServletContext().getAttribute("metodosPago");
            List<Exception> exceptions = new ArrayList<>();
            
            exceptions.addAll(mPago.get(request.getParameter("metodoPago")).validar(request, response));
            
            return exceptions;
        }
    }
}
