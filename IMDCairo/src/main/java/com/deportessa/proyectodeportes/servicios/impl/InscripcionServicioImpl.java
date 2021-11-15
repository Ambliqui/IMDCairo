/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deportessa.proyectodeportes.servicios.impl;

import com.deportessa.proyectodeportes.daojpa.factory.DaoAbstractFactoryLocal;
import com.deportessa.proyectodeportes.modelo.ActividadMetodoPagoPK;
import com.deportessa.proyectodeportes.modelo.Cliente;
import com.deportessa.proyectodeportes.modelo.Inscripcion;
import com.deportessa.proyectodeportes.modelo.MetodoPago;
import com.deportessa.proyectodeportes.servicios.InscripcionServicio;
import com.deportessa.proyectodeportes.servicios.dto.InscripcionDTO;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author pryet
 */
@Stateless
public class InscripcionServicioImpl implements InscripcionServicio {

    @Inject
    private DaoAbstractFactoryLocal daoFactoryLocal;

    @Override
    public List<Inscripcion> getInscripciones(Cliente cliente) {
        List<Inscripcion> inscripciones = new ArrayList<>();
        cliente.getMetodosPagoCliente().forEach((mp) -> inscripciones.addAll(mp.getInscripciones()));
        return inscripciones;
    }

    @Override
    public List<InscripcionDTO> getInscripcionesDTO(Cliente cliente) {
        return daoFactoryLocal.getInscripcionDaoLocal().getinscripcionDTO(cliente);
    }

    @Override
    public void baja(Integer idActividad, Integer idPago) {
        Inscripcion insc = daoFactoryLocal.getInscripcionDaoLocal()
                .find(new ActividadMetodoPagoPK(idActividad, idPago));
        MetodoPago mp = daoFactoryLocal.getMetodoPagoDaoLocal().find(idPago);

        daoFactoryLocal.getInscripcionDaoLocal().remove(insc);

        mp.getInscripciones().remove(insc);
        daoFactoryLocal.getMetodoPagoDaoLocal().edit(mp);
    }
}
