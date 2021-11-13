/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package com.deportessa.proyectodeportes.metodosPago.factory;

import com.deportessa.proyectodeportes.metodosPago.MetodoPagoLocal;
import javax.ejb.Local;

/**
 *
 * @author Antonio
 */
@Local
public interface MetodoPagoFactoryLocal {
    
    MetodoPagoLocal getPagoTarjeta();
    MetodoPagoLocal getPagoPayPal();
    MetodoPagoLocal getPagoTransferencia();
    
}
