/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.deportessa.proyectodeportes.servicios;

import com.deportessa.proyectodeportes.modelo.MetodoPago;
import com.deportessa.proyectodeportes.modelo.Tarjeta;
import com.deportessa.proyectodeportes.servicios.qualifiers.ActionMetodoPagoTarjetaQ;
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

@ActionMetodoPagoTarjetaQ
public class ActionMetodoPagoTarjetaImpl implements ActionMetodoPago {

    @Override
    public MetodoPago execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        MetodoPago metodoPago = new Tarjeta(
                Integer.parseInt(request.getParameter("numeroTarjeta")),
                Integer.parseInt(request.getParameter("mesTarjeta")),
                Integer.parseInt(request.getParameter("annoTarjeta")),
                Integer.parseInt(request.getParameter("cvsTarjeta"))
        );
        return metodoPago;
    }
}
