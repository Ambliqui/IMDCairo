/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.imd.controler.login;

import com.arelance.imd.domain.Login;
import com.arelance.imd.services.login.ServicesLogin;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author usuario
 */
@WebServlet(name = "PostLoginServlet", urlPatterns = {"/PostLoginServlet"})
public class PostLoginServlet extends HttpServlet {

    @Inject
    ServicesLogin servicesLogin;

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
        response.setContentType("text/html;charset=UTF-8");

        //Creamos variables para las vistas y/o los metodos
        String msg;
        Login login = new Login();

        //Recuperamos parametros
        String email = request.getParameter("username");
        String password = request.getParameter("password");

        //Seteamos el usuario a comprobar
        login.setEmailLogin(email);
        login.setPasswordLogin(password);

        //Invocamos al servicio
        login = servicesLogin.findLoginByEmail(login);

        if (login.getEmailLogin().equals(email) && login.getPasswordLogin().equals(password)) {    //Credenciales OK
            request.getSession(true);
            request.getSession().setAttribute("usuarioSesion", login);
            request.getRequestDispatcher("PreIndexServlet").forward(request, response);
            return;
        } else if (login.getEmailLogin() == null) {      //Email nulo --> no existe el usuario
            msg = "El usuario no consta en nuestro sistema";
        } else {                                                //Contraseña incorrecta
            msg = "La contraseña no es correcta";
        }
        
        request.setAttribute("msg", msg);
        request.getRequestDispatcher("PreLoginServlet").forward(request, response);
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
