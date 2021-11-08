
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deportessa.proyectodeportes.servlets.registro;

import com.deportessa.proyectodeportes.modelo.Cliente;
import com.deportessa.proyectodeportes.servicios.ClienteServicio;
import com.deportessa.proyectodeportes.servicios.excepciones.EmailNoExistsException;
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
@WebServlet(name = "PostRegistroUsuarioServlet", urlPatterns = {"/PostRegistroUsuarioServlet"})
public class PostRegistroUsuarioServlet extends HttpServlet {

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

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

//        Cliente clienteSession = new Cliente();
//        
//        String email = request.getParameter("email");
//        String cEmail = request.getParameter("cemail");
//        String password = request.getParameter("password");
//        String cPassword = request.getParameter("cpassword");
//
//        //Caso de uso --> introducir usuario y contraseña y que la contraseña no esté repetida
//        //Escenario OK
//        //TODO cambiar los if por validadores
//        //Escenario Email no coincidente        
//        //Escenario password no coincidente
//        if (password.equals(cPassword) && email.equals(cEmail)) {
//            try {
//                clienteServicio.findEmail(email);
//                //Escenario email no encontrado
//            } catch (EmailNoExistsException ex) {
//                request.getSession(true);
//                request.setAttribute("email", email);
//                request.setAttribute("password", password);
                request.getRequestDispatcher("PreRegistroDatosPersonalesServlet").forward(request, response);
//                //Escenario password no coincidente
//            }
//        }else{
//            request.getRequestDispatcher("PreRegistroUsuarioServlet").forward(request, response);
//        }
//        //Escenario Email existente
//        
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
