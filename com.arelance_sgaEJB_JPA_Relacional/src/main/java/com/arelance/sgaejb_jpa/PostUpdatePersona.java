/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.sgaejb_jpa;

import com.arelance.sgaejb_jpa.services.personaservice.PersonaService;
import com.arelance.sgajpa.domain.Persona;
import java.io.IOException;
import java.io.PrintWriter;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author salvador
 */
@WebServlet(name = "PostUpdatePersona", urlPatterns = {"/PostUpdatePersona"})
public class PostUpdatePersona extends HttpServlet {

    @Inject
    private PersonaService personaService;

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

        Persona persona = (Persona) request.getSession().getAttribute("persona");
        switch (request.getParameter("action")) {
            case "actualizar":
                personaService.updatePersona(persona);
                break;
            case "eliminar":
                personaService.removePersona(persona);
                request.getRequestDispatcher("MainServlet").forward(request, response);
                return;
            case "alta":
                Persona persona1 = new Persona();
                persona1.setNombre(request.getParameter("nombre"));
                persona1.setApellido(request.getParameter("apellido"));
                persona1.setEmail(request.getParameter("email"));
                persona1.setTelefono(request.getParameter("telefono"));
                personaService.addPersona(persona1);
                request.getSession().setAttribute("persona", persona1);
                request.getRequestDispatcher("update.jsp").forward(request, response);
                return;
            case "modificar":
                persona.setNombre(request.getParameter("nombre"));
                persona.setApellido(request.getParameter("apellido"));
                persona.setEmail(request.getParameter("email"));
                persona.setTelefono(request.getParameter("telefono"));
                personaService.updatePersona(persona);
                break;
            case "altaactividad":
                request.getRequestDispatcher("alta_aficion.jsp").forward(request, response);
                return;
            default:
        }
        request.getRequestDispatcher("update.jsp").forward(request, response);
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
