/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package com.deportessa.proyectodeportes.daojpa.factory;

import com.deportessa.proyectodeportes.daojpa.ActividadLocal;
import com.deportessa.proyectodeportes.daojpa.ClienteLocal;
import com.deportessa.proyectodeportes.daojpa.EntrenadorLocal;
import com.deportessa.proyectodeportes.daojpa.InscripcionLocal;
import com.deportessa.proyectodeportes.daojpa.MetodoPagoLocal;
import com.deportessa.proyectodeportes.daojpa.PaypalLocal;
import com.deportessa.proyectodeportes.daojpa.TarjetaLocal;
import com.deportessa.proyectodeportes.daojpa.TransferenciaLocal;
import javax.ejb.Local;

/**
 *
 * @author Antonio
 *
 */
@Local
public interface DaoAbstractFactoryLocal {

    ClienteLocal getClienteDaoLocal();

    ActividadLocal getActividadDaoLocal();

    EntrenadorLocal getEntrenadorDaoLocal();

    InscripcionLocal getInscripcionDaoLocal();

    MetodoPagoLocal getMetodoPagoDaoLocal();

    PaypalLocal getPayPalDaoLocal();

    TarjetaLocal getTarjetaDaoLocal();

    TransferenciaLocal getTransferenciaDaoLocal();

}
