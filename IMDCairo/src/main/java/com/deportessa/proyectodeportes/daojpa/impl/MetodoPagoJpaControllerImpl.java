/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deportessa.proyectodeportes.daojpa.impl;

import com.deportessa.proyectodeportes.modelo.Inscripcion;
import com.deportessa.proyectodeportes.modelo.MetodoPago;
import com.deportessa.proyectodeportes.prueba.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.deportessa.proyectodeportes.daojpa.MetodoPagoJpaControllerDao;
import javax.ejb.Stateless;
@Stateless
public class MetodoPagoJpaControllerImpl implements MetodoPagoJpaControllerDao {

    @PersistenceContext(unitName = "pu")
    private EntityManager em;

    @Override
    public void create(MetodoPago metodoPago) {
        if (metodoPago.getInscripciones() == null) {
            metodoPago.setInscripciones(new ArrayList<>());
        }
        List<Inscripcion> attachedInscripciones = new ArrayList<>();
        for (Inscripcion inscripcionesInscripcionToAttach : metodoPago.getInscripciones()) {
            inscripcionesInscripcionToAttach = em.getReference(inscripcionesInscripcionToAttach.getClass(), inscripcionesInscripcionToAttach.getActividadMetodoPagoPK());
            attachedInscripciones.add(inscripcionesInscripcionToAttach);
        }
        metodoPago.setInscripciones(attachedInscripciones);
        em.persist(metodoPago);
        for (Inscripcion inscripcionesInscripcion : metodoPago.getInscripciones()) {
            MetodoPago oldMetodoPagoOfInscripcionesInscripcion = inscripcionesInscripcion.getMetodoPago();
            inscripcionesInscripcion.setMetodoPago(metodoPago);
            inscripcionesInscripcion = em.merge(inscripcionesInscripcion);
            if (oldMetodoPagoOfInscripcionesInscripcion != null) {
                oldMetodoPagoOfInscripcionesInscripcion.getInscripciones().remove(inscripcionesInscripcion);
                oldMetodoPagoOfInscripcionesInscripcion = em.merge(oldMetodoPagoOfInscripcionesInscripcion);
            }
        }
    }

    @Override
    public void edit(MetodoPago metodoPago) throws NonexistentEntityException, Exception {

        try {
            MetodoPago persistentMetodoPago = em.find(MetodoPago.class, metodoPago.getIdPago());
            List<Inscripcion> inscripcionesOld = persistentMetodoPago.getInscripciones();
            List<Inscripcion> inscripcionesNew = metodoPago.getInscripciones();
            List<Inscripcion> attachedInscripcionesNew = new ArrayList<>();
            for (Inscripcion inscripcionesNewInscripcionToAttach : inscripcionesNew) {
                inscripcionesNewInscripcionToAttach = em.getReference(inscripcionesNewInscripcionToAttach.getClass(), inscripcionesNewInscripcionToAttach.getActividadMetodoPagoPK());
                attachedInscripcionesNew.add(inscripcionesNewInscripcionToAttach);
            }
            inscripcionesNew = attachedInscripcionesNew;
            metodoPago.setInscripciones(inscripcionesNew);
            metodoPago = em.merge(metodoPago);
            for (Inscripcion inscripcionesOldInscripcion : inscripcionesOld) {
                if (!inscripcionesNew.contains(inscripcionesOldInscripcion)) {
                    inscripcionesOldInscripcion.setMetodoPago(null);
                    inscripcionesOldInscripcion = em.merge(inscripcionesOldInscripcion);
                }
            }
            for (Inscripcion inscripcionesNewInscripcion : inscripcionesNew) {
                if (!inscripcionesOld.contains(inscripcionesNewInscripcion)) {
                    MetodoPago oldMetodoPagoOfInscripcionesNewInscripcion = inscripcionesNewInscripcion.getMetodoPago();
                    inscripcionesNewInscripcion.setMetodoPago(metodoPago);
                    inscripcionesNewInscripcion = em.merge(inscripcionesNewInscripcion);
                    if (oldMetodoPagoOfInscripcionesNewInscripcion != null && !oldMetodoPagoOfInscripcionesNewInscripcion.equals(metodoPago)) {
                        oldMetodoPagoOfInscripcionesNewInscripcion.getInscripciones().remove(inscripcionesNewInscripcion);
                        oldMetodoPagoOfInscripcionesNewInscripcion = em.merge(oldMetodoPagoOfInscripcionesNewInscripcion);
                    }
                }
            }
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = metodoPago.getIdPago();
                if (findMetodoPago(id) == null) {
                    throw new NonexistentEntityException("The metodoPago with id " + id + " no longer exists.");
                }
            }
            throw ex;
        }
    }

    @Override
    public void destroy(int id) throws NonexistentEntityException {

        MetodoPago metodoPago;
        try {
            metodoPago = em.getReference(MetodoPago.class, id);
            metodoPago.getIdPago();
        } catch (EntityNotFoundException enfe) {
            throw new NonexistentEntityException("The metodoPago with id " + id + " no longer exists.", enfe);
        }
        List<Inscripcion> inscripciones = metodoPago.getInscripciones();
        for (Inscripcion inscripcionesInscripcion : inscripciones) {
            inscripcionesInscripcion.setMetodoPago(null);
            inscripcionesInscripcion = em.merge(inscripcionesInscripcion);
        }
        em.remove(metodoPago);
    }

    @Override
    public List<MetodoPago> findMetodoPagoEntities() {
        return findMetodoPagoEntities(true, -1, -1);
    }

    @Override
    public List<MetodoPago> findMetodoPagoEntities(int maxResults, int firstResult) {
        return findMetodoPagoEntities(false, maxResults, firstResult);
    }

    @Override
    public List<MetodoPago> findMetodoPagoEntities(boolean all, int maxResults, int firstResult) {

        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(MetodoPago.class));
        Query q = em.createQuery(cq);
        if (!all) {
            q.setMaxResults(maxResults);
            q.setFirstResult(firstResult);
        }
        return q.getResultList();
    }

    @Override
    public MetodoPago findMetodoPago(int id) {
        return em.find(MetodoPago.class, id);
    }

    @Override
    public int getMetodoPagoCount() {
        
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        Root<MetodoPago> rt = cq.from(MetodoPago.class);
        cq.select(em.getCriteriaBuilder().count(rt));
        Query q = em.createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
}
