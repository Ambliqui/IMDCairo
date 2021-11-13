/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deportessa.proyectodeportes.frontController.acciones;

import com.deportessa.proyectodeportes.frontController.FrontControlerLocal;
import com.deportessa.proyectodeportes.frontController.qualifiers.AccionLogin;
import com.deportessa.proyectodeportes.servicios.ActionValidator;
import com.deportessa.proyectodeportes.servicios.qualifiers.ActionValidatorLoginQ;
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
@AccionLogin
public class LoginController implements FrontControlerLocal{
    
    @Inject
    @ActionValidatorLoginQ
    private ActionValidator validadorLogin;

    @Override
    public RequestDispatcher getDispatcher(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Exception> exceptions = validadorLogin.execute(request, response);

        //Mandamos a la pagina de destino
        if (exceptions.isEmpty()) {
            return request.getRequestDispatcher("/PostLoginServlet");
        } else {
            //Recuperamos lo que nos ha escrito el cliente para volver a mostrarlo en pantalla
            request.setAttribute("email", request.getParameter("email"));
            request.setAttribute("password", request.getParameter("password"));

            //Devolvemos los errores
            request.setAttribute("errores", exceptions);
            return request.getRequestDispatcher("/PreLoginServlet");
        }
    }
    
}
