/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Filter.java to edit this template
 */
package com.deportessa.proyectodeportes.filter;

import com.deportessa.proyectodeportes.servicios.validaciones.Validaciones;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
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
        
        //TODO: Hacer validaciones patterns para ciertos tipos de campos
        validaciones.emailNoFormateado(request.getParameter("email")).ifPresent((error) -> exceptions.add(error));
        validaciones.camposIdenticos(request.getParameter("email"), request.getParameter("cemail")).ifPresent((error) -> exceptions.add(error));
        validaciones.longitudCampo(request.getParameter("password"), 8).ifPresent((error) -> exceptions.add(error));
        validaciones.camposIdenticos(request.getParameter("password"), request.getParameter("cpassword")).ifPresent((error) -> exceptions.add(error));
//        validaciones.emailNoExistente(request.getParameter("email")).ifPresent((error) -> exceptions.add(error));
        
        if (exceptions.isEmpty()) {
            chain.doFilter(request, response);
        } else {

            //Recuperamos lo que nos ha escrito el cliente para volver a mostrarlo en pantalla
            httpServletRequest.setAttribute("email", request.getParameter("email"));
            httpServletRequest.setAttribute("cemail", request.getParameter("cemail"));
            httpServletRequest.setAttribute("password", request.getParameter("password"));
            httpServletRequest.setAttribute("cpassword", request.getParameter("cpassword"));
            
            //Devolvemos los errores
            httpServletRequest.setAttribute("errores", exceptions);
            httpServletRequest.getRequestDispatcher("PreRegistroUsuarioServlet").forward(request, response);
        }

    }

}
