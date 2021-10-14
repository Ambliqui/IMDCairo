/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deportessa.proyectodeportes.servicios.Impl;

import com.deportessa.proyectodeportes.servicios.ServicioValidacionLocal;
import javax.ejb.Stateless;

/**
 *
 * @author Antonio
 */
@Stateless
public class ServicioValidacionImpl implements ServicioValidacionLocal {

//    @Inject
//    private ClienteDAOLocal cDAO;
//    @Inject
//    private ServicioConversionLocal conversor;
//
//    @Override
//    public boolean validarTarjeta(TarjetaDTO tarjeta) {
//        Cliente cliente = cDAO.buscaPorEmail(tarjeta.getCliente().getEmail());
//        return !cliente.getTarjetaList().contains(conversor.tarjetaDTOaTarjeta(tarjeta));
//
//    }
//
//    @Override
//    public boolean actividadInscrita(Cliente cliente, Actividad actividad) {
//        List<ActividadClienteTarjeta>lista=cliente.getActividadClienteTarjetaList();
//        cDAO.refresh(cliente);
//        List<ActividadClienteTarjeta>lista2=cliente.getActividadClienteTarjetaList();
//        boolean compradoConTarjeta = cliente.getActividadClienteTarjetaList().contains(new ActividadClienteTarjeta(actividad.getIdActividad(), cliente.getIdCliente()));
//        boolean compradoConPayPal = cliente.getActividadClientePaypalList().contains(new ActividadClienteTarjeta(actividad.getIdActividad(), cliente.getIdCliente()));
//        boolean compradoConTransferencia = cliente.getActividadClienteTransferenciaList().contains(new ActividadClienteTarjeta(actividad.getIdActividad(), cliente.getIdCliente()));
//        return compradoConTarjeta || compradoConPayPal || compradoConTransferencia;
//    }

}
