/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.deportessa.proyectodeportes.servicios;

import com.deportessa.proyectodeportes.modelo.Cliente;
import com.deportessa.proyectodeportes.servicios.qualifiers.ActionValidatorInscripcionQ;
import com.deportessa.proyectodeportes.servicios.validaciones.Validaciones;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mefisto
 */
@Stateless
@ActionValidatorInscripcionQ
public class ActionValidatorInscripcionImpl implements ActionValidator {

    @Inject
    private Validaciones validaciones;

    @Override
    public List<Exception> execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        List<Exception> exceptions = new ArrayList<>();
        validaciones.usuarioNoLogado(request).ifPresent((error)->exceptions.add(error));
        if(exceptions.isEmpty()){
            Cliente cliente = (Cliente) request.getSession().getAttribute("clienteSession");
            validaciones.usuarioYaInscrito(cliente.getIdCliente(), Integer.parseInt(request.getParameter("idActividad"))).ifPresent((error) -> exceptions.add(error));
        }
        
        
        
        
        return exceptions;
    }
}
