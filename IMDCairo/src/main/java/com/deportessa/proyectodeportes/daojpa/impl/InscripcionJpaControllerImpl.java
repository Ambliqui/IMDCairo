/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deportessa.proyectodeportes.daojpa.impl;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.deportessa.proyectodeportes.modelo.Actividad;
import com.deportessa.proyectodeportes.modelo.ActividadMetodoPagoPK;
import com.deportessa.proyectodeportes.modelo.Inscripcion;
import com.deportessa.proyectodeportes.modelo.MetodoPago;
import com.deportessa.proyectodeportes.prueba.exceptions.NonexistentEntityException;
import com.deportessa.proyectodeportes.prueba.exceptions.PreexistingEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import com.deportessa.proyectodeportes.daojpa.InscripcionJpaControllerDao;
import javax.ejb.Stateless;

/**
 *
 * @author pryet
 */
@Stateless
public class InscripcionJpaControllerImpl implements InscripcionJpaControllerDao {

    @PersistenceContext(unitName = "pu")
    private EntityManager em;

    @Override
    public void create(Inscripcion inscripcion) throws PreexistingEntityException, Exception {
        if (inscripcion.getActividadMetodoPagoPK() == null) {
            inscripcion.setActividadMetodoPagoPK(new ActividadMetodoPagoPK());
        }
        try {
            Actividad actividad = inscripcion.getActividad();
            if (actividad != null) {
                actividad = em.getReference(actividad.getClass(), actividad.getIdActividad());
                inscripcion.setActividad(actividad);
            }
            MetodoPago metodoPago = inscripcion.getMetodoPago();
            if (metodoPago != null) {
                metodoPago = em.getReference(metodoPago.getClass(), metodoPago.getIdPago());
                inscripcion.setMetodoPago(metodoPago);
            }
            em.persist(inscripcion);
            if (actividad != null) {
                actividad.getInscripciones().add(inscripcion);
                actividad = em.merge(actividad);
            }
            if (metodoPago != null) {
                metodoPago.getInscripciones().add(inscripcion);
                metodoPago = em.merge(metodoPago);
            }
        } catch (Exception ex) {
            if (findInscripcion(inscripcion.getActividadMetodoPagoPK()) != null) {
                throw new PreexistingEntityException("Inscripcion " + inscripcion + " already exists.", ex);
            }
            throw ex;
        }
    }

    @Override
    public void edit(Inscripcion inscripcion) throws NonexistentEntityException, Exception {

        try {
            Inscripcion persistentInscripcion = em.find(Inscripcion.class, inscripcion.getActividadMetodoPagoPK());
            Actividad actividadOld = persistentInscripcion.getActividad();
            Actividad actividadNew = inscripcion.getActividad();
            MetodoPago metodoPagoOld = persistentInscripcion.getMetodoPago();
            MetodoPago metodoPagoNew = inscripcion.getMetodoPago();
            if (actividadNew != null) {
                actividadNew = em.getReference(actividadNew.getClass(), actividadNew.getIdActividad());
                inscripcion.setActividad(actividadNew);
            }
            if (metodoPagoNew != null) {
                metodoPagoNew = em.getReference(metodoPagoNew.getClass(), metodoPagoNew.getIdPago());
                inscripcion.setMetodoPago(metodoPagoNew);
            }
            inscripcion = em.merge(inscripcion);
            if (actividadOld != null && !actividadOld.equals(actividadNew)) {
                actividadOld.getInscripciones().remove(inscripcion);
                actividadOld = em.merge(actividadOld);
            }
            if (actividadNew != null && !actividadNew.equals(actividadOld)) {
                actividadNew.getInscripciones().add(inscripcion);
                actividadNew = em.merge(actividadNew);
            }
            if (metodoPagoOld != null && !metodoPagoOld.equals(metodoPagoNew)) {
                metodoPagoOld.getInscripciones().remove(inscripcion);
                metodoPagoOld = em.merge(metodoPagoOld);
            }
            if (metodoPagoNew != null && !metodoPagoNew.equals(metodoPagoOld)) {
                metodoPagoNew.getInscripciones().add(inscripcion);
                metodoPagoNew = em.merge(metodoPagoNew);
            }
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                ActividadMetodoPagoPK id = inscripcion.getActividadMetodoPagoPK();
                if (findInscripcion(id) == null) {
                    throw new NonexistentEntityException("The inscripcion with id " + id + " no longer exists.");
                }
            }
            throw ex;
        }
    }

    @Override
    public void destroy(ActividadMetodoPagoPK id) throws NonexistentEntityException {

        Inscripcion inscripcion;
        try {
            inscripcion = em.getReference(Inscripcion.class, id);
            inscripcion.getActividadMetodoPagoPK();
        } catch (EntityNotFoundException enfe) {
            throw new NonexistentEntityException("The inscripcion with id " + id + " no longer exists.", enfe);
        }
        Actividad actividad = inscripcion.getActividad();
        if (actividad != null) {
            actividad.getInscripciones().remove(inscripcion);
            actividad = em.merge(actividad);
        }
        MetodoPago metodoPago = inscripcion.getMetodoPago();
        if (metodoPago != null) {
            metodoPago.getInscripciones().remove(inscripcion);
            metodoPago = em.merge(metodoPago);
        }
        em.remove(inscripcion);

    }

    @Override
    public List<Inscripcion> findInscripcionEntities() {
        return findInscripcionEntities(true, -1, -1);
    }

    @Override
    public List<Inscripcion> findInscripcionEntities(int maxResults, int firstResult) {
        return findInscripcionEntities(false, maxResults, firstResult);
    }

    @Override
    public List<Inscripcion> findInscripcionEntities(boolean all, int maxResults, int firstResult) {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Inscripcion.class));
        Query q = em.createQuery(cq);
        if (!all) {
            q.setMaxResults(maxResults);
            q.setFirstResult(firstResult);
        }
        return q.getResultList();
    }

    @Override
    public Inscripcion findInscripcion(ActividadMetodoPagoPK id) {
        return em.find(Inscripcion.class, id);
    }

    @Override
    public int getInscripcionCount() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        Root<Inscripcion> rt = cq.from(Inscripcion.class);
        cq.select(em.getCriteriaBuilder().count(rt));
        Query q = em.createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

}
