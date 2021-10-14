/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deportessa.proyectodeportes.dao.implAntiguos;

import com.deportessa.proyectodeportes.daoAntiguo.ActividadDAOLocal;

import com.deportessa.proyectodeportes.vista.actividadDto.ActividadDTO;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author pryet
 */
@Stateless
public class ActividadDAOImpl implements ActividadDAOLocal {
    
//    @PersistenceContext(unitName = "pu")
//    private EntityManager em;
//    @Override
//    public List<Actividad> buscarTodo() {
//        List<Actividad>lista;
//        lista=em.createQuery("SELECT a FROM Actividad a").getResultList();
//        return lista;
//    }
//
//    @Override
//    public Actividad buscarPorId(int id) {
//        return (Actividad) em.createQuery("SELECT a FROM Actividad a WHERE a.idActividad = :id")
//                .setParameter("id", id)
//                .getSingleResult();
//    }
//
//    @Override
//    public List<Actividad> buscarPorNombre(String nombre) {
//        return  em.createQuery("SELECT a FROM Actividad a WHERE a.nombre like :nombre")
//                .setParameter("nombre", nombre).getResultList();
//    }

}
