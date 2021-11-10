/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deportessa.proyectodeportes.servlets.registro;

import com.deportessa.proyectodeportes.daojpa.factory.DaoAbstractFactoryLocal;
import com.deportessa.proyectodeportes.modelo.Cliente;
import com.deportessa.proyectodeportes.modelo.MetodoPago;
import com.deportessa.proyectodeportes.modelo.Paypal;
import com.deportessa.proyectodeportes.modelo.Tarjeta;
import com.deportessa.proyectodeportes.modelo.Transferencia;
import com.deportessa.proyectodeportes.servicios.ActionMetodoPago;
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
    @Inject
    private DaoAbstractFactoryLocal daoFactoryLocal;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ////////////// DATOS DE USUARIO //////////////////////
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        String telefono = request.getParameter("telefono");

        Cliente cliente = new Cliente();
        cliente.setEmailCliente(email);
        cliente.setPassCliente(password);
        cliente.setNombreCliente(nombre);
        cliente.setApellido1Cliente(apellidos);
        cliente.setTelefonoCliente(telefono);
        daoFactoryLocal.getClienteDaoLocal().create(cliente);

        MetodoPago metodoPago;
        Tarjeta tarjeta = null;
        Paypal paypal = null;
        Transferencia transferencia = null;

        if (request.getParameter("metodoPago").equalsIgnoreCase("tarjeta")) {

            Integer numeroTarjeta = Integer.parseInt(request.getParameter("numeroTarjeta"));
            Integer mesTarjeta = Integer.parseInt(request.getParameter("mesTarjeta"));
            Integer annoTarjeta = Integer.parseInt(request.getParameter("annoTarjeta"));
            Integer csvTarjeta = Integer.parseInt(request.getParameter("cvsTarjeta"));
            tarjeta = new Tarjeta(numeroTarjeta, mesTarjeta, annoTarjeta, csvTarjeta);
            daoFactoryLocal.getTarjetaDaoLocal().create(tarjeta);

            cliente = daoFactoryLocal.getClienteDaoLocal().findByEmail(cliente.getEmailCliente()).get();
            cliente.addMPago(tarjeta);
            daoFactoryLocal.getClienteDaoLocal().edit(cliente);

        } else if (request.getParameter("metodoPago").equalsIgnoreCase("paypal")) {

            paypal = new Paypal(request.getParameter("cuentaPaypal"));
            cliente = daoFactoryLocal.getClienteDaoLocal().findByEmail(cliente.getEmailCliente()).get();
            cliente.addMPago(paypal);
            daoFactoryLocal.getClienteDaoLocal().edit(cliente);

        } else {

            transferencia = new Transferencia(Integer.parseInt(request.getParameter("IBAN")));
            cliente = daoFactoryLocal.getClienteDaoLocal().findByEmail(cliente.getEmailCliente()).get();
            cliente.addMPago(transferencia);
            daoFactoryLocal.getClienteDaoLocal().edit(cliente);

        }

        request.getSession(true);
        request.getSession().setAttribute("clienteSession", cliente);
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
