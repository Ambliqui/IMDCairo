/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Filter.java to edit this template
 */
package com.deportessa.proyectodeportes.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
 * @author Antonio
 */
@WebFilter(filterName = "Autentificacion", urlPatterns = {"/*"}, dispatcherTypes = {DispatcherType.REQUEST})
public class Autentificacion implements Filter {
    
    // URI libres de filtro
    private final String principal="principal.jsp";
    private final String login="login.jsp";
    private final String detalle="detalle_actividad.jsp";
    private final String reg1="registro_datos_personales.jsp";
    private final String reg2="registro_usuario.jsp";
    private final String postDetalle="PostDetalleServlet";
    private final String prePrincipalDetalle="PreDetallesServlet";
    private final String postPrincipal="PostPrincipalServlet";
    private final String prePrincipal="PrePrincipalServlet";
    private final String postReg1="PostRegistroDatosPersonalesServlet";
    private final String preReg1="PreRegistroDatosPersonalesServlet";
    private final String postReg2="PostRegistroUsuarioServlet";
    private final String preReg2="PreRegistroUsuarioServlet";
    private final String postLogin="PostLoginServlet";
    private final String preLogin="PreLoginServlet";
    
    
   
    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
//        List<String> sinFiltro=new ArrayList<>();
//        sinFiltro.add(principal);
//        sinFiltro.add(detalle);
//        sinFiltro.add(reg1);
//        sinFiltro.add(reg2);
//        sinFiltro.add(postDetalle);
//        sinFiltro.add(prePrincipalDetalle);
//        sinFiltro.add(postPrincipal);
//        sinFiltro.add(prePrincipal);
//        sinFiltro.add(postReg1);
//        sinFiltro.add(preReg1);
//        sinFiltro.add(postReg2);
//        sinFiltro.add(preReg2);
//        sinFiltro.add(postLogin);
//        sinFiltro.add(preLogin);
//        sinFiltro.add(login);
//        
//        boolean pasarCadena=false;
//        
//        HttpServletRequest req=(HttpServletRequest) request;
//        String uri=req.getRequestURI();
//        
//        for (String str : sinFiltro) {
//            if(uri.endsWith(str)){
//                pasarCadena=true;
//            }
//        }
         chain.doFilter(request, response);
//        try {
//            if(pasarCadena){
//                chain.doFilter(request, response);
//            }else{
//                if(req.getSession(false)!=null){
//                    if(req.getSession(false).getAttribute("clienteSession")!=null){
//                        chain.doFilter(request, response);
//                    }else{
//                        req.getRequestDispatcher(prePrincipal).forward(request, response);
//                    }
//                }else{
//                    req.getRequestDispatcher(prePrincipal).forward(request, response);
//                }
//            }
//            
//        } catch (Throwable t) {
//
//            t.printStackTrace();
//        }
        

    }

  
    
}
