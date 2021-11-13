/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.deportessa.proyectodeportes.frontController.acciones;

import com.deportessa.proyectodeportes.frontController.FrontControlerLocal;
import com.deportessa.proyectodeportes.frontController.qualifiers.Inscripcion;
import com.deportessa.proyectodeportes.modelo.Cliente;
import com.deportessa.proyectodeportes.servicios.ActionValidator;
import com.deportessa.proyectodeportes.servicios.qualifiers.ActionValidatorInscripcionQ;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Antonio
 */
@Stateless
@Inscripcion
public class InscripcionController implements FrontControlerLocal {

    @Inject
    @ActionValidatorInscripcionQ
    private ActionValidator validadorInscripcion;

    @Override
    public RequestDispatcher getDispatcher(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Exception> exceptions= validadorInscripcion.execute(request, response);
        if (exceptions.isEmpty()) {
            
            return request.getRequestDispatcher("/PostDetalleServlet");
        } else {
            request.setAttribute("errores", exceptions);
            return request.getRequestDispatcher("/PreDetallesServlet?actividad="+request.getParameter("idActividad"));
        }

    }

}
