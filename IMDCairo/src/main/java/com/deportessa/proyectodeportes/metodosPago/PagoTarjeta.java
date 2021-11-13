/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package com.deportessa.proyectodeportes.metodosPago;

import com.deportessa.proyectodeportes.metodosPago.qualifiers.Tarjeta;
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
 * @author Antonio
 */
@Stateless
@Tarjeta
public class PagoTarjeta implements MetodoPagoLocal {

    @Inject
    private Validaciones validaciones;

    @Override
    public List<Exception> validar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Exception> exceptions = new ArrayList<>();
        validaciones.rangoValores("Numero Tarjeta ", request.getParameter("numeroTarjeta"), 01, 2899999).ifPresent((error) -> exceptions.add(error));
        validaciones.rangoValores("Mes Tarjeta: ", request.getParameter("mesTarjeta"), 01, 12).ifPresent((error) -> exceptions.add(error));
        validaciones.rangoValores("Año Tarjeta: ", request.getParameter("annoTarjeta"), 01, 31).ifPresent((error) -> exceptions.add(error));
        validaciones.rangoValores("CSV Tarjeta:", request.getParameter("cvsTarjeta"), 01, 999).ifPresent((error) -> exceptions.add(error));
        return exceptions;
    }


    @Override
    public HttpServletRequest reenviarDatos(HttpServletRequest request) throws ServletException, IOException {
        request.setAttribute("numeroTarjeta", request.getParameter("numeroTarjeta"));
        request.setAttribute("mesTarjeta", request.getParameter("mesTarjeta"));
        request.setAttribute("annoTarjeta", request.getParameter("annoTarjeta"));
        request.setAttribute("cvsTarjeta", request.getParameter("cvsTarjeta"));
        return request;
    }

}
