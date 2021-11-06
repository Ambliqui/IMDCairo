/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deportessa.proyectodeportes.servlets.registro;

import com.deportessa.proyectodeportes.modelo.Cliente;
import com.deportessa.proyectodeportes.modelo.Tarjeta;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mefisto
 */
@WebServlet(name = "PostRegistroDatosPersonalesServlet", urlPatterns = {"/PostRegistroDatosPersonalesServlet"})
public class PostRegistroDatosPersonalesServlet extends HttpServlet {

    
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

        ////////////// DATOS DE USUARIO //////////////////////

        String nombre = request.getParameter("nombre");
//        String apellidos = request.getParameter("Apellidos");
//        String telefono = request.getParameter("telefono");
        
        //TODO: Pasar validadores y crear cliente en caso afirmativo
        
        Cliente cliente = new Cliente();
        cliente.setNombreCliente(nombre);
//        cliente.setApellido1Cliente(apellidos);
//        cliente.setTelefonoCliente(telefono);
        
        //////////////// DATOS DE TARJETA ////////////////////////
        
//        Integer numeroTarjeta = Integer.parseInt(request.getParameter("numeroTarjeta"));
//        Integer mesTarjeta = Integer.parseInt(request.getParameter("mesTarjeta"));
//        Integer annoTarjeta = Integer.parseInt(request.getParameter("annoTarjeta"));
//        Integer csvTarjeta = Integer.parseInt(request.getParameter("csvTarjeta"));
        
        //TODO: Pasar validadores y crear tarjeta en caso afirmativo
        
//        Tarjeta tarjeta = new Tarjeta();
//        tarjeta.setNumTarjeta(numeroTarjeta);
//        tarjeta.setMesTarjeta(mesTarjeta);
//        tarjeta.setAnnoTarjeta(annoTarjeta);
//        tarjeta.setCvsTarjeta(csvTarjeta);
        
        //////////////// DATOS PAYPAL //////////////////////
        
//        String cuentaPaypal = request.getParameter("cuentaPaypal");
        
        
        //////////////// DATOS BANCARIA ///////////////////////
        
//        Integer cuentaBancaria = Integer.parseInt(request.getParameter("cuentaBancaria"));

        request.getRequestDispatcher("PrePrincipalServlet").forward(request, response);
        
        
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
