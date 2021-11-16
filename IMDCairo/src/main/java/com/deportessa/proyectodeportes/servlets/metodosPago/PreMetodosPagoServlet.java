/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.deportessa.proyectodeportes.servlets.metodosPago;

import com.deportessa.proyectodeportes.daojpa.factory.DaoAbstractFactoryLocal;
import com.deportessa.proyectodeportes.modelo.Cliente;
import com.deportessa.proyectodeportes.modelo.MetodoPago;
import com.deportessa.proyectodeportes.modelo.Paypal;
import com.deportessa.proyectodeportes.modelo.Tarjeta;
import com.deportessa.proyectodeportes.modelo.Transferencia;
import com.deportessa.proyectodeportes.servicios.ClienteServicio;
import java.io.IOException;
import java.util.List;
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
@WebServlet(name = "PreMetodosPagoServlet", urlPatterns = {"/PreMetodosPagoServlet"})
public class PreMetodosPagoServlet extends HttpServlet {

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
    private ClienteServicio cliServ;
    
    @Inject
    private DaoAbstractFactoryLocal daoFactoryLocal;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Cliente cli = (Cliente) request.getSession().getAttribute("clienteSession");
        cli = daoFactoryLocal.getClienteDaoLocal().find(cli.getIdCliente());
        List<MetodoPago> tarjetas = cliServ.findMetodoPagoByTipo(cli, Tarjeta.class);
        if (!tarjetas.isEmpty()) {
            Tarjeta t = (Tarjeta) tarjetas.get(0);
            request.setAttribute("tarjeta", t);
//            request.setAttribute("annoTarjeta", t.getAnnoTarjeta());
//            request.setAttribute("cvsTarjeta", t.getCvsTarjeta());
//            request.setAttribute("mesTarjeta", t.getMesTarjeta());
//            request.setAttribute("numeroTarjeta", t.getNumTarjeta());
        }
        List<MetodoPago> paypals = cliServ.findMetodoPagoByTipo(cli, Paypal.class);
        if (!paypals.isEmpty()) {
            Paypal p = (Paypal) paypals.get(0);
            request.setAttribute("paypal", p);
//            request.setAttribute("cuentaPaypal", p.getCorreo());

        }
        List<MetodoPago> nCuentas = cliServ.findMetodoPagoByTipo(cli, Transferencia.class);
        if (!nCuentas.isEmpty()) {
            Transferencia trans = (Transferencia) nCuentas.get(0);
            request.setAttribute("transferencia", trans);
        
//            request.setAttribute("", trans.getDcCuenta());
//            request.setAttribute("", trans.getEntidadCuenta());
//            request.setAttribute("", trans.getNumeroCuenta());
//            request.setAttribute("", trans.getOficinaCuenta());
//            request.setAttribute("", trans.getPaisCuenta());
        }

        request.getRequestDispatcher("metodos_pago.jsp").forward(request, response);
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
