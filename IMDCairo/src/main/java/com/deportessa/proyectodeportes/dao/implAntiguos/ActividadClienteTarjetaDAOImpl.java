/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deportessa.proyectodeportes.dao.implAntiguos;


import com.deportessa.proyectodeportes.modelo.Cliente;
import com.deportessa.proyectodeportes.modelo.Tarjeta;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.deportessa.proyectodeportes.daoAntiguo.ActividadClienteTarjetaDAOLocal;


/**
 *
 * @author pryet
 */
@Stateless
public class ActividadClienteTarjetaDAOImpl implements ActividadClienteTarjetaDAOLocal {

//    @PersistenceContext(unitName = "pu")
//    private EntityManager em;
//    
//    @Override
//    public void guardar(ActividadClienteTarjeta activiCliente) {
//        em.persist(activiCliente);
//    }
//
//    @Override
//    public void borrar(Cliente cliente, Actividad actividad) {
//        ActividadClienteTarjeta actividadClienteTarjeta=em.find(ActividadClienteTarjeta.class
//                , new ActividadClienteTarjetaPK(actividad.getIdActividad(), cliente.getIdCliente()));
//        em.remove(actividadClienteTarjeta);
//    }

}
