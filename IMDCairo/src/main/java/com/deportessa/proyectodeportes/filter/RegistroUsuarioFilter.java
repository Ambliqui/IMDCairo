/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Filter.java to edit this template
 */
package com.deportessa.proyectodeportes.filter;

import com.deportessa.proyectodeportes.servicios.validaciones.Validaciones;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Mefisto
 */
@WebFilter(filterName = "RegistroUsuarioFilter", urlPatterns = {"/registro_datos_personales.jsp"}, dispatcherTypes = {DispatcherType.REQUEST, DispatcherType.FORWARD})
public class RegistroUsuarioFilter implements Filter {

    @Inject
    private Validaciones validaciones;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;

        List<Exception> exceptions = new ArrayList<>();

        //metodo no null 
        //list<Exception> limpiar(exceptions)
        
        //TODO: Hacer validaciones patterns para ciertos tipos de campos
        validaciones.longitudCampo(request.getParameter("email"),1).ifPresent((error) -> exceptions.add( error));
        validaciones.longitudCampo(request.getParameter("password"),1).ifPresent((error) -> exceptions.add( error));
//        exceptions.add(validaciones.camposIdenticos(request.getParameter("email"), request.getParameter("cemail")));
//        exceptions.add(validaciones.camposIdenticos(request.getParameter("password"), request.getParameter("cpassword")));
        
        if (exceptions.isEmpty()) {
//            httpServletRequest.getRequestDispatcher("PreRegistroDatosPersonalesServlet").forward(request, response);
            chain.doFilter(request, response);
        } else {
            httpServletRequest.setAttribute("errores", exceptions);
            httpServletRequest.getRequestDispatcher("PreRegistroUsuarioServlet").forward(request, response);
        }

        //TODO pruebas, quitar despues de hacer las pruebas
        System.out.println("La lista es asi de grande: " + exceptions.size());
    }

}
