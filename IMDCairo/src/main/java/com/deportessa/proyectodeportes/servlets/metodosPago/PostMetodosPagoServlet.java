/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.deportessa.proyectodeportes.servlets.metodosPago;

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
@WebServlet(name = "PostMetodosPagoServlet", urlPatterns = {"/PostMetodosPagoServlet"})
public class PostMetodosPagoServlet extends HttpServlet {

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
        
        DatosLoginVO datosLogin = (DatosLoginVO) request.getAttribute("datosLogin");
        DatosPersonalesVO datosCliente = (DatosPersonalesVO) request.getAttribute("datosCliente");

        Cliente cliente = new Cliente();
        cliente.setEmailCliente(datosLogin.getEmailCliente());
        cliente.setPassCliente(datosLogin.getPassCliente());
        cliente.setNombreCliente(datosCliente.getNombreCliente());
        cliente.setApellido1Cliente(datosCliente.getApellido1Cliente());
        cliente.setTelefonoCliente(datosCliente.getTelefonoCliente());
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
            daoFactoryLocal.getPayPalDaoLocal().create(paypal);

            cliente.addMPago(paypal);
            daoFactoryLocal.getClienteDaoLocal().edit(cliente);

        } else {

            transferencia = new Transferencia(Integer.parseInt(request.getParameter("IBAN")));
            cliente = daoFactoryLocal.getClienteDaoLocal().findByEmail(cliente.getEmailCliente()).get();
            daoFactoryLocal.getTransferenciaDaoLocal().create(transferencia);

            cliente.addMPago(transferencia);
            daoFactoryLocal.getClienteDaoLocal().edit(cliente);

        }

        request.getSession(true);
        request.getSession().setAttribute("clienteSession", cliente);
        request.getRequestDispatcher("PrePrincipalServlet").forward(request, response);
        }
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
