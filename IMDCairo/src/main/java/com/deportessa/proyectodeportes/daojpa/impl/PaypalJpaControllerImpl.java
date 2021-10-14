/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deportessa.proyectodeportes.daojpa.impl;

import com.deportessa.proyectodeportes.daojpa.PaypalJpaControllerDao;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.deportessa.proyectodeportes.modelo.Inscripcion;
import com.deportessa.proyectodeportes.modelo.Paypal;
import com.deportessa.proyectodeportes.daojpa.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

/**
 *
 * @author pryet
 */
public class PaypalJpaControllerImpl implements PaypalJpaControllerDao {

    @PersistenceContext(unitName = "pu")
    private EntityManager em;

    @Override
    public void create(Paypal paypal) {
        if (paypal.getInscripciones() == null) {
            paypal.setInscripciones(new ArrayList<Inscripcion>());
        }
        List<Inscripcion> attachedInscripciones = new ArrayList<Inscripcion>();
        for (Inscripcion inscripcionesInscripcionToAttach : paypal.getInscripciones()) {
            inscripcionesInscripcionToAttach = em.getReference(inscripcionesInscripcionToAttach.getClass(), inscripcionesInscripcionToAttach.getActividadMetodoPagoPK());
            attachedInscripciones.add(inscripcionesInscripcionToAttach);
        }
        paypal.setInscripciones(attachedInscripciones);
        em.persist(paypal);
        for (Inscripcion inscripcionesInscripcion : paypal.getInscripciones()) {
            com.deportessa.proyectodeportes.modelo.MetodoPago oldMetodoPagoOfInscripcionesInscripcion = inscripcionesInscripcion.getMetodoPago();
            inscripcionesInscripcion.setMetodoPago(paypal);
            inscripcionesInscripcion = em.merge(inscripcionesInscripcion);
            if (oldMetodoPagoOfInscripcionesInscripcion != null) {
                oldMetodoPagoOfInscripcionesInscripcion.getInscripciones().remove(inscripcionesInscripcion);
                oldMetodoPagoOfInscripcionesInscripcion = em.merge(oldMetodoPagoOfInscripcionesInscripcion);
            }
        }
    }

    @Override
    public void edit(Paypal paypal) throws NonexistentEntityException, Exception {

        try {
            Paypal persistentPaypal = em.find(Paypal.class, paypal.getIdPago());
            List<Inscripcion> inscripcionesOld = persistentPaypal.getInscripciones();
            List<Inscripcion> inscripcionesNew = paypal.getInscripciones();
            List<Inscripcion> attachedInscripcionesNew = new ArrayList<Inscripcion>();
            for (Inscripcion inscripcionesNewInscripcionToAttach : inscripcionesNew) {
                inscripcionesNewInscripcionToAttach = em.getReference(inscripcionesNewInscripcionToAttach.getClass(), inscripcionesNewInscripcionToAttach.getActividadMetodoPagoPK());
                attachedInscripcionesNew.add(inscripcionesNewInscripcionToAttach);
            }
            inscripcionesNew = attachedInscripcionesNew;
            paypal.setInscripciones(inscripcionesNew);
            paypal = em.merge(paypal);
            for (Inscripcion inscripcionesOldInscripcion : inscripcionesOld) {
                if (!inscripcionesNew.contains(inscripcionesOldInscripcion)) {
                    inscripcionesOldInscripcion.setMetodoPago(null);
                    inscripcionesOldInscripcion = em.merge(inscripcionesOldInscripcion);
                }
            }
            for (Inscripcion inscripcionesNewInscripcion : inscripcionesNew) {
                if (!inscripcionesOld.contains(inscripcionesNewInscripcion)) {
                    Paypal oldMetodoPagoOfInscripcionesNewInscripcion = (Paypal) inscripcionesNewInscripcion.getMetodoPago();
                    inscripcionesNewInscripcion.setMetodoPago(paypal);
                    inscripcionesNewInscripcion = em.merge(inscripcionesNewInscripcion);
                    if (oldMetodoPagoOfInscripcionesNewInscripcion != null && !oldMetodoPagoOfInscripcionesNewInscripcion.equals(paypal)) {
                        oldMetodoPagoOfInscripcionesNewInscripcion.getInscripciones().remove(inscripcionesNewInscripcion);
                        oldMetodoPagoOfInscripcionesNewInscripcion = em.merge(oldMetodoPagoOfInscripcionesNewInscripcion);
                    }
                }
            }
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = paypal.getIdPago();
                if (findPaypal(id) == null) {
                    throw new NonexistentEntityException("The paypal with id " + id + " no longer exists.");
                }
            }
            throw ex;
        }
    }

    @Override
    public void destroy(int id) throws NonexistentEntityException {
        Paypal paypal;
        try {
            paypal = em.getReference(Paypal.class, id);
            paypal.getIdPago();
        } catch (EntityNotFoundException enfe) {
            throw new NonexistentEntityException("The paypal with id " + id + " no longer exists.", enfe);
        }
        List<Inscripcion> inscripciones = paypal.getInscripciones();
        for (Inscripcion inscripcionesInscripcion : inscripciones) {
            inscripcionesInscripcion.setMetodoPago(null);
            inscripcionesInscripcion = em.merge(inscripcionesInscripcion);
        }
        em.remove(paypal);
    }

    @Override
    public List<Paypal> findPaypalEntities() {
        return findPaypalEntities(true, -1, -1);
    }

    @Override
    public List<Paypal> findPaypalEntities(int maxResults, int firstResult) {
        return findPaypalEntities(false, maxResults, firstResult);
    }

    @Override
    public List<Paypal> findPaypalEntities(boolean all, int maxResults, int firstResult) {

        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Paypal.class));
        Query q = em.createQuery(cq);
        if (!all) {
            q.setMaxResults(maxResults);
            q.setFirstResult(firstResult);
        }
        return q.getResultList();
    }

    @Override
    public Paypal findPaypal(int id) {
        return em.find(Paypal.class, id);
    }

    @Override
    public int getPaypalCount() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        Root<Paypal> rt = cq.from(Paypal.class);
        cq.select(em.getCriteriaBuilder().count(rt));
        Query q = em.createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

}
