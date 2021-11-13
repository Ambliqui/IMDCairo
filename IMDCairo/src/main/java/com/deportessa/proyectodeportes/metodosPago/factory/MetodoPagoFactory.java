/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package com.deportessa.proyectodeportes.metodosPago.factory;

import com.deportessa.proyectodeportes.metodosPago.MetodoPagoLocal;
import com.deportessa.proyectodeportes.metodosPago.qualifiers.PayPal;
import com.deportessa.proyectodeportes.metodosPago.qualifiers.Tarjeta;
import com.deportessa.proyectodeportes.metodosPago.qualifiers.Transferencia;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Antonio
 */
@Stateless
public class MetodoPagoFactory implements MetodoPagoFactoryLocal {

    @Inject
    @Tarjeta
    private MetodoPagoLocal pagoTarjeta;
    
    @Inject
    @PayPal
    private MetodoPagoLocal pagoPayPal;
    
    @Inject
    @Transferencia
    private MetodoPagoLocal pagoTranferencia;

    @Override
    public MetodoPagoLocal getPagoTarjeta() {
        return pagoTarjeta;
    }

    @Override
    public MetodoPagoLocal getPagoPayPal() {
        return pagoPayPal;
    }

    @Override
    public MetodoPagoLocal getPagoTransferencia() {
        return pagoTranferencia;
    
    }
    
}
