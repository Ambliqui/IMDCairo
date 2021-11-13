/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package com.deportessa.proyectodeportes.metodosPago;

import java.io.IOException;
import java.util.List;
import javax.ejb.Local;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Antonio
 */
@Local
public interface MetodoPagoLocal {
    
    List<Exception> validar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
    
    HttpServletRequest reenviarDatos(HttpServletRequest request) throws ServletException, IOException ;
}
