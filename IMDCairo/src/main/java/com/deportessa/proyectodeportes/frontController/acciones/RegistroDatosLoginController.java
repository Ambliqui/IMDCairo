/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deportessa.proyectodeportes.frontController.acciones;

import com.deportessa.proyectodeportes.frontController.FrontControlerLocal;
import com.deportessa.proyectodeportes.servicios.ActionValidator;
import com.deportessa.proyectodeportes.servicios.dto.DatosLoginVO;
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
 * @author pryet
 */
@Stateless
@com.deportessa.proyectodeportes.frontController.qualifiers.RegistroDatosLogin
public class RegistroDatosLoginController implements FrontControlerLocal{
    
    @Inject
    @com.deportessa.proyectodeportes.servicios.qualifiers.ActionValidatorRegistroUsuarioQ
    private ActionValidator validadorMetodoPago;

    @Override
    public RequestDispatcher getDispatcher(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
        
        List<Exception> exceptions = validadorMetodoPago.execute(request, response);
        
        if (exceptions.isEmpty()) {
            DatosLoginVO datosLogin = new DatosLoginVO(request.getParameter("email"), request.getParameter("password"));
            request.setAttribute("datosLogin", datosLogin);
            request.setAttribute("email", request.getParameter("email"));
            request.setAttribute("password", request.getParameter("password"));
            return request.getRequestDispatcher("/PreRegistroDatosPersonalesServlet");
        } else {

            //Recuperamos lo que nos ha escrito el cliente para volver a mostrarlo en pantalla
            request.setAttribute("email", request.getParameter("email"));
            request.setAttribute("cemail", request.getParameter("cemail"));
            request.setAttribute("password", request.getParameter("password"));
            request.setAttribute("cpassword", request.getParameter("cpassword"));
            
            //Devolvemos los errores
            request.setAttribute("errores", exceptions);
            return request.getRequestDispatcher("/PreRegistroUsuarioServlet");

        }
        
    }
    
}
