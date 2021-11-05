/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.deportessa.proyectodeportes.servicios;

import com.deportessa.proyectodeportes.servicios.qualifiers.DatosPersonalesValidatorQ;
import com.deportessa.proyectodeportes.servicios.qualifiers.LoginQ;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mefisto
 */

@WebServlet(name = "ActionsServices", urlPatterns = {"/ActionsServices"})
public class ActionsServices extends HttpServlet {

    @Inject
    @DatosPersonalesValidatorQ
    private ActionController datosPersonalesVal;
    
    @Inject
    @LoginQ
    private ActionController login;
    

    private final Map<String, ActionController> acciones = new HashMap<>();

    @Override
    public void init() throws ServletException {
        super.init();
        acciones.put("datosPersonales", datosPersonalesVal);
        acciones.put("login", login);
    }

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String actionKey = "login";//request.getParameter("accion");

        ActionController accion = acciones.get(actionKey);
        String page = accion.execute(request, response);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
        dispatcher.forward(request, response);

    }

}
