/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.deportessa.proyectodeportes.metodosPago;

import com.deportessa.proyectodeportes.metodosPago.qualifiers.Transferencia;
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
@Transferencia
public class PagoTransferencia implements MetodoPagoLocal{
    @Inject
    private Validaciones validaciones;

    @Override
    public List<Exception> validar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Exception> exceptions = new ArrayList<>();
        validaciones.rangoValores("IBAN: ",request.getParameter("IBAN"), 10000, 99999).ifPresent((error) -> exceptions.add(error));
        return exceptions;
    }

    @Override
    public HttpServletRequest reenviarDatos(HttpServletRequest request) throws ServletException, IOException {
        request.setAttribute("IBAN", request.getParameter("IBAN"));
        return request;
    }
    
}
