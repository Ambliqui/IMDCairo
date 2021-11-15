/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.deportessa.proyectodeportes.frontController.acciones;

import com.deportessa.proyectodeportes.frontController.FrontControlerLocal;
import com.deportessa.proyectodeportes.frontController.qualifiers.AltaMetodoPagoQ;
import com.deportessa.proyectodeportes.servicios.ActionValidator;
import com.deportessa.proyectodeportes.servicios.qualifiers.ActionMetodoPagoQ;
import com.deportessa.proyectodeportes.servicios.qualifiers.ActionValidatorRegistroUsuarioQ;
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
@AltaMetodoPagoQ
public class AltaMetodoPagoController implements FrontControlerLocal {

    @Inject
    @ActionMetodoPagoQ
    private ActionValidator validadorMetodosPago;

    @Override
    public RequestDispatcher getDispatcher(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Exception> exceptions = validadorMetodosPago.execute(request, response);
        
        request.setAttribute("email", request.getParameter("email"));
        request.setAttribute("password", request.getParameter("password"));
        request.setAttribute("nombre", request.getParameter("nombre"));
        request.setAttribute("apellidos", request.getParameter("apellidos"));
        request.setAttribute("telefono", request.getParameter("telefono"));
        if (exceptions.isEmpty()) {
            return request.getRequestDispatcher("/PostMetodosPagoServlet");
        } else {
            //Recuperamos lo que nos ha escrito el cliente para volver a mostrarlo en pantalla
            request.setAttribute("password", request.getParameter("password"));

            //Devolvemos los errores
            request.setAttribute("errores", exceptions);
            return request.getRequestDispatcher("/PostMetodosPagoServlet");
        }
    }

}
