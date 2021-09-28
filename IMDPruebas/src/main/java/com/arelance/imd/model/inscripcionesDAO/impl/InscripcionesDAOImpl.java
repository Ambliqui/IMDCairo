/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.imd.model.inscripcionesDAO.impl;

import com.arelance.imd.domain.Inscripcion;
import com.arelance.imd.domain.Login;
import com.arelance.imd.model.inscripcionesDAO.InscripcionesDAO;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Mefisto
 */

@Stateless
public class InscripcionesDAOImpl implements InscripcionesDAO{
    
    @PersistenceContext(unitName = "IMDDB")
    EntityManager em;

    @Override
    public List<Inscripcion> findByUser(Login login) {
        List<Inscripcion> inscripciones;
        inscripciones = em.createNamedQuery("Inscripcion.findByIdUsuarioInscripcion")
                .setParameter("idUsuarioInscripcion", login.getIdUsuarioLogin())
                .getResultList();
        return inscripciones;
    }
}
