/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package com.deportessa.proyectodeportes.daojpa.impl.postgre;

import com.deportessa.proyectodeportes.daojpa.DaoGenericoAbstracto;
import com.deportessa.proyectodeportes.daojpa.InscripcionLocal;
import com.deportessa.proyectodeportes.daojpa.qulifiers.InscripcionPostgre;
import com.deportessa.proyectodeportes.modelo.Inscripcion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Antonio
 */
@Stateless
@InscripcionPostgre
public class InscripcionPostgreImpl extends DaoGenericoAbstracto<Inscripcion, Integer> implements InscripcionLocal {

    @PersistenceContext(unitName = "postgre")
    private EntityManager em;

    public InscripcionPostgreImpl() {
        super(Inscripcion.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
