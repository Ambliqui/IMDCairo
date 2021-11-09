/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
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
import com.deportessa.proyectodeportes.daojpa.qulifiers.ActividadMysql;
import com.deportessa.proyectodeportes.daojpa.qulifiers.ClienteMysql;
import com.deportessa.proyectodeportes.daojpa.qulifiers.EntrenadorMysql;
import com.deportessa.proyectodeportes.daojpa.qulifiers.InscripcionMysql;
import com.deportessa.proyectodeportes.daojpa.qulifiers.MetodoPagoMysql;
import com.deportessa.proyectodeportes.daojpa.qulifiers.PaypalMysql;
import com.deportessa.proyectodeportes.daojpa.qulifiers.TarjetaMysql;
import com.deportessa.proyectodeportes.daojpa.qulifiers.TransferenciaMysql;
import javax.ejb.Singleton;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;


/**
 *
 * @author Antonio
 */
@Singleton
@Alternative
public class FactoryMySql implements DaoAbstractFactoryLocal {

    @Inject
    @ClienteMysql
    private ClienteLocal clienteLocal;

    @Inject
    @ActividadMysql
    private ActividadLocal actividadLocal;

    @Inject
    @EntrenadorMysql
    private EntrenadorLocal entrenadorLocal;

    @Inject
    @InscripcionMysql
    private InscripcionLocal inscripcionLocal;

    @Inject
    @MetodoPagoMysql
    private MetodoPagoLocal metodoPagoLocal;

    @Inject
    @PaypalMysql
    private PaypalLocal paypalLocal;

    @Inject
    @TarjetaMysql
    private TarjetaLocal tarjetaLocal;

    @Inject
    @TransferenciaMysql
    private TransferenciaLocal transferenciaLocal;

    @Override
    public ClienteLocal getClienteDaoLocal() {
        return clienteLocal;
    }

    @Override
    public ActividadLocal getActividadDaoLocal() {
        return actividadLocal;
    }

    @Override
    public EntrenadorLocal getEntrenadorDaoLocal() {
        return entrenadorLocal;
    }

    @Override
    public InscripcionLocal getInscripcionDaoLocal() {
        return inscripcionLocal;
    }

    @Override
    public MetodoPagoLocal getMetodoPagoDaoLocal() {
        return metodoPagoLocal;
    }

    @Override
    public PaypalLocal getPayPalDaoLocal() {
        return paypalLocal;
    }

    @Override
    public TarjetaLocal getTarjetaDaoLocal() {
        return tarjetaLocal;
    }

    @Override
    public TransferenciaLocal getTransferenciaDaoLocal() {
        return transferenciaLocal;
    }

}
