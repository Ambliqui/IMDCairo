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
import javax.ejb.Singleton;
import com.deportessa.proyectodeportes.daojpa.factory.qualifiers.FactoryDaoPostgre;
import com.deportessa.proyectodeportes.daojpa.qulifiers.ActividadPostgre;
import com.deportessa.proyectodeportes.daojpa.qulifiers.ClientePostgre;
import com.deportessa.proyectodeportes.daojpa.qulifiers.EntrenadorPostgre;
import com.deportessa.proyectodeportes.daojpa.qulifiers.InscripcionPostgre;
import com.deportessa.proyectodeportes.daojpa.qulifiers.MetodoPagoPostgre;
import com.deportessa.proyectodeportes.daojpa.qulifiers.PaypalPostgre;
import com.deportessa.proyectodeportes.daojpa.qulifiers.TarjetaPostgre;
import com.deportessa.proyectodeportes.daojpa.qulifiers.TransferenciaPostgre;
import javax.inject.Inject;

/**
 *
 * @author Antonio
 */
@Singleton
@FactoryDaoPostgre
public class FactoryPostgre implements DaoAbstractFactoryLocal {

    @Inject
    @ClientePostgre
    private ClienteLocal clienteLocal;

    @Inject
    @ActividadPostgre
    private ActividadLocal actividadLocal;

    @Inject
    @EntrenadorPostgre
    private EntrenadorLocal entrenadorLocal;

    @Inject
    @InscripcionPostgre
    private InscripcionLocal inscripcionLocal;

    @Inject
    @MetodoPagoPostgre
    private MetodoPagoLocal metodoPagoLocal;

    @Inject
    @PaypalPostgre
    private PaypalLocal paypalLocal;

    @Inject
    @TarjetaPostgre
    private TarjetaLocal tarjetaLocal;

    @Inject
    @TransferenciaPostgre
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
