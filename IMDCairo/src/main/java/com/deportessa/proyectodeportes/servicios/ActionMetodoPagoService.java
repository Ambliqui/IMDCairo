/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.deportessa.proyectodeportes.servicios;

import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mefisto
 */
@WebServlet(name = "ActionMetodoPagoService", urlPatterns = {"/ActionMetodoPagoService"})
public class ActionMetodoPagoService extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
        Map<String, ActionMetodoPago> tipoMetodoPago = (Map<String, ActionMetodoPago>) request.getServletContext().getAttribute("tipoMetodoPago");
        String actionKey = request.getParameter("metodoPago");

        ActionMetodoPago accion = tipoMetodoPago.get(actionKey);
        
        request.setAttribute("metodoPagoCreado", accion.execute(request, response));
    }
}
