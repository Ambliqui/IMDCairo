/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package com.deportessa.proyectodeportes.daojpa.impl.postgre;

import com.deportessa.proyectodeportes.daojpa.ActividadLocal;
import com.deportessa.proyectodeportes.daojpa.DaoGenericoAbstracto;
import com.deportessa.proyectodeportes.daojpa.qulifiers.ActividadPostgre;
import com.deportessa.proyectodeportes.modelo.Actividad;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Antonio
 */
@Singleton
@ActividadPostgre
public class ActividadPostgreImpl extends DaoGenericoAbstracto<Actividad, Integer> implements ActividadLocal{
    
    @PersistenceContext(unitName = "mysql")
    private EntityManager em;

    public ActividadPostgreImpl() {
        super(Actividad.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
