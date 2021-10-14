/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deportessa.proyectodeportes.vista.actividad;

import com.deportessa.proyectodeportes.servicios.ClienteServicioLocal;
import com.deportessa.proyectodeportes.excepcionesAntiguas.EmailIncorrectoException;
import com.deportessa.proyectodeportes.excepcionesAntiguas.PasswordIncorrectaException;
import com.deportessa.proyectodeportes.vista.clienteDto.ClienteSesionDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author pryet
 */
@WebServlet(name = "PostLogin", urlPatterns = {"/postLogin"})
public class PostLogin extends HttpServlet {

    @Inject
    private ClienteServicioLocal clienteServicio;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        RequestDispatcher rd;
//        String email = request.getParameter("email");
//        String password = request.getParameter("password");
//        try {
//            ClienteSesionDTO clienteDTO = clienteServicio.login(email, password);     
//            request.getSession().setAttribute("cliente", clienteDTO);
//            rd=request.getRequestDispatcher("./prePrincipal");
//        } catch (PasswordIncorrectaException ex) {
//            request.setAttribute("msgError", ex.getMessage());
//            //request.setAttribute("email", email);
//            rd=request.getRequestDispatcher("./preLogin");
//        } catch (EmailIncorrectoException ex) {
//            request.setAttribute("msgError", ex.getMessage());
//           // request.setAttribute("email", email);
//            rd=request.getRequestDispatcher("./preLogin");
//        }
//        rd.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
