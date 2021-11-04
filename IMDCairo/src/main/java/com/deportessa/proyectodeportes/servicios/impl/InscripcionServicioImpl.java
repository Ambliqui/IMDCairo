/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deportessa.proyectodeportes.servicios.impl;

import com.deportessa.proyectodeportes.daojpa.factory.DaoAbstractFactoryLocal;
import com.deportessa.proyectodeportes.daojpa.qulifiers.ClienteMysql;
import com.deportessa.proyectodeportes.modelo.Cliente;
import com.deportessa.proyectodeportes.modelo.Inscripcion;
import com.deportessa.proyectodeportes.servicios.InscripcionServicio;
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

    public List<Inscripcion> getInscripciones(Cliente cliente){
        List<Inscripcion> inscripciones=new ArrayList<>();
        cliente.getMetodosPagoCliente().forEach((cli)->inscripciones.addAll(cli.getInscripciones()));
        return inscripciones;
    }
}
