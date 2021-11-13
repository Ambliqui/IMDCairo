/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.deportessa.proyectodeportes.servicios;

import com.deportessa.proyectodeportes.servicios.validaciones.Validaciones;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.deportessa.proyectodeportes.servicios.qualifiers.ActionValidatorLoginQ;
import javax.ejb.Stateless;

/**
 * Este Servlet lo usamos para validar el formulario de login de la pagina
 * @author Mefisto
 */
@Stateless
@ActionValidatorLoginQ
public class ActionValidatorLoginImpl implements ActionValidator {

    @Inject
    private Validaciones validaciones;

    @Override
    public List<Exception> execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Exception> exceptions = new ArrayList<>();

        validaciones.emailNoFormateado(request.getParameter("email")).ifPresent((error) -> exceptions.add(error));
        if (exceptions.isEmpty()) {
            validaciones.emailNoExistente(request.getParameter("email")).ifPresent((error) -> exceptions.add(error));
        }
        if (exceptions.isEmpty()) {
            validaciones.passwordNoCoincidente(request.getParameter("email"), request.getParameter("password")).ifPresent((error) -> exceptions.add(error));
        }
        return exceptions;
    }

}
