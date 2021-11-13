/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.deportessa.proyectodeportes.frontController.acciones;

import com.deportessa.proyectodeportes.frontController.FrontControlerLocal;
import com.deportessa.proyectodeportes.frontController.qualifiers.PrePrincipal;
import java.io.IOException;
import javax.ejb.Stateless;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Antonio
 */
@Stateless
@PrePrincipal
public class VolverPrePrincipalServlet implements FrontControlerLocal{

    @Override
    public RequestDispatcher getDispatcher(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return request.getRequestDispatcher("./PrePrincipalServlet");
    }
   
}
