/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.deportessa.proyectodeportes.servicios;

import com.deportessa.proyectodeportes.servicios.qualifiers.RegistroUsuarioServicioQ;
import com.deportessa.proyectodeportes.servicios.validaciones.Validaciones;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mefisto
 */

@RegistroUsuarioServicioQ
public class RegistroUsuarioServicio implements ActionController {

    @Inject
    private Validaciones validaciones;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Exception> exceptions = new ArrayList<>();

        //TODO: Hacer validaciones patterns para ciertos tipos de campos
        validaciones.emailNoFormateado(request.getParameter("email")).ifPresent((error) -> exceptions.add(error));
        validaciones.camposIdenticos(request.getParameter("email"), request.getParameter("cemail")).ifPresent((error) -> exceptions.add(error));
        validaciones.longitudCampo(request.getParameter("password"), 8).ifPresent((error) -> exceptions.add(error));
        validaciones.camposIdenticos(request.getParameter("password"), request.getParameter("cpassword")).ifPresent((error) -> exceptions.add(error));
//        validaciones.emailNoExistente(request.getParameter("email")).ifPresent((error) -> exceptions.add(error));//        validaciones.emailNoExistente(request.getParameter("email")).ifPresent((error) -> exceptions.add(error));

        if (exceptions.isEmpty()) {
            return "PreRegistroDatosPersonalesServlet";
        } else {

            //Recuperamos lo que nos ha escrito el cliente para volver a mostrarlo en pantalla
            request.setAttribute("email", request.getParameter("email"));
            request.setAttribute("cemail", request.getParameter("cemail"));
            request.setAttribute("password", request.getParameter("password"));
            request.setAttribute("cpassword", request.getParameter("cpassword"));

            //Devolvemos los errores
            request.setAttribute("errores", exceptions);
            return "PreRegistroUsuarioServlet";

        }
    }
}
