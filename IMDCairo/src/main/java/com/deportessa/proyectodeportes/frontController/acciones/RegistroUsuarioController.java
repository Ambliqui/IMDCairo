/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.deportessa.proyectodeportes.frontController.acciones;

import com.deportessa.proyectodeportes.frontController.FrontControlerLocal;
import com.deportessa.proyectodeportes.metodosPago.MetodoPagoLocal;
import com.deportessa.proyectodeportes.servicios.ActionValidator;
import com.deportessa.proyectodeportes.servicios.dto.DatosPersonalesVO;
import com.deportessa.proyectodeportes.servicios.qualifiers.ActionValidatorDatosPersonalesImplQ;
import java.io.IOException;
import java.util.List;
import java.util.Map;
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
@com.deportessa.proyectodeportes.frontController.qualifiers.RegistroUsuario
public class RegistroUsuarioController implements FrontControlerLocal{

    @Inject
    @ActionValidatorDatosPersonalesImplQ
    private ActionValidator validadorDatosLogin;
    
    @Override
    public RequestDispatcher getDispatcher(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        List<Exception> exceptions= validadorDatosLogin.execute(request, response);
        
        if (exceptions.isEmpty()) {
//            DatosPersonalesVO datosCliente = new DatosPersonalesVO(request.getParameter("nombre"), 
//                    request.getParameter("apellidos"), 
//                    request.getParameter("telefono")
//            );
            request.setAttribute("email", request.getParameter("email"));
            request.setAttribute("password", request.getParameter("password"));
            request.setAttribute("nombre", request.getParameter("nombre"));
            request.setAttribute("apellidos", request.getParameter("apellidos"));
            request.setAttribute("telefono", request.getParameter("telefono"));
            //request.setAttribute("datosCliente", datosCliente);
            return request.getRequestDispatcher("/PostRegistroDatosPersonalesServlet");
        } else {

            //Recuperamos lo que nos ha escrito el cliente para volver a mostrarlo en pantalla
            request.setAttribute("email", request.getParameter("email"));
            request.setAttribute("password", request.getParameter("password"));
            request.setAttribute("nombre", request.getParameter("nombre"));
            request.setAttribute("apellidos", request.getParameter("apellidos"));
            request.setAttribute("telefono", request.getParameter("telefono"));

            //Devolvemos los errores
            request.setAttribute("errores", exceptions);
            return request.getRequestDispatcher("/PreRegistroDatosPersonalesServlet");
            
        }
        
    }
    
}
