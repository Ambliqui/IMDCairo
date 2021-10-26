/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deportessa.proyectodeportes.servlets.login;

import com.deportessa.proyectodeportes.modelo.Cliente;
import com.deportessa.proyectodeportes.pruebas.isi.ClienteTest;
import com.deportessa.proyectodeportes.servicios.ClienteServicio;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mefisto
 */
@WebServlet(name = "PostLoginServlet", urlPatterns = {"/PostLoginServlet"})
public class PostLoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    @Inject
    ClienteServicio clienteServicio;
    //TODO: Quitar clase de pruebas cuando implemente Antonio el metodo en la fachada
    @Inject
    ClienteTest clienteTest;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Cliente cliente = new Cliente();
        
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        cliente.setPassCliente(password);
        cliente.setEmailCliente(email);
        
        //TODO: Controlar los escenarios del caso de uso de Login
        Cliente clienteSession = clienteTest.findEmail(email);
        
        //Escenario email sin formato correcto
        
        //Escenario email no encontrado
        
        //Escenario password no coincidente
        
        //Caso OK
        request.getSession(true);
        request.getSession().setAttribute("clienteSession", clienteSession);
        
        request.getRequestDispatcher("principal.jsp").forward(request, response);
    
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
