/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.deportessa.proyectodeportes.servlets.detalles;

import com.deportessa.proyectodeportes.daojpa.factory.DaoAbstractFactoryLocal;
import com.deportessa.proyectodeportes.modelo.Actividad;
import com.deportessa.proyectodeportes.modelo.Inscripcion;
import com.deportessa.proyectodeportes.modelo.MetodoPago;
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
@WebServlet(name = "PostDetalleServlet", urlPatterns = {"/PostDetalleServlet"})
public class PostDetalleServlet extends HttpServlet {

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
        
        Actividad actividad = daoFactoryLocal.getActividadDaoLocal().find(Integer.parseInt(request.getParameter("idActividad")));
        MetodoPago mp = daoFactoryLocal.getMetodoPagoDaoLocal().find(Integer.parseInt(request.getParameter("metodoPago")));
        
        Inscripcion inscripcion=new Inscripcion(actividad, mp);
        mp.addInscripcion(inscripcion);
        daoFactoryLocal.getMetodoPagoDaoLocal().edit(mp);
        
        request.getRequestDispatcher("/preMisActividades").forward(request, response);
        
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
