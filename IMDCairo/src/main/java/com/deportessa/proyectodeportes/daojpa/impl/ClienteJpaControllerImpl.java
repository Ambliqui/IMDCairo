/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deportessa.proyectodeportes.daojpa.impl;

import com.deportessa.proyectodeportes.modelo.Cliente;
import com.deportessa.proyectodeportes.daojpa.exceptions.NonexistentEntityException;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.deportessa.proyectodeportes.daojpa.ClienteJpaControllerDao;

/**
 *
 * @author pryet
 */
@Stateless
public class ClienteJpaControllerImpl implements ClienteJpaControllerDao {

    @PersistenceContext(unitName = "pu")
    private EntityManager em;

    @Override
    public void create(Cliente cliente) {
        em.persist(cliente);
    }

    @Override
    public void edit(Cliente cliente) throws NonexistentEntityException, Exception {

        try {
           em.merge(cliente);
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = cliente.getIdCliente();
                if (findCliente(id) == null) {
                    throw new NonexistentEntityException("The cliente with id " + id + " no longer exists.");
                }
            }
            throw ex;
        }
    }

    @Override
    public void destroy(Integer id) throws NonexistentEntityException {
        Cliente cliente;
        try {
            cliente = em.getReference(Cliente.class, id);
            cliente.getIdCliente();
        } catch (EntityNotFoundException enfe) {
            throw new NonexistentEntityException("The cliente with id " + id + " no longer exists.", enfe);
        }
        em.remove(cliente);
    }

    @Override
    public List<Cliente> findClienteEntities() {
        return findClienteEntities(true, -1, -1);
    }

    @Override
    public List<Cliente> findClienteEntities(int maxResults, int firstResult) {
        return findClienteEntities(false, maxResults, firstResult);
    }

    @Override
    public List<Cliente> findClienteEntities(boolean all, int maxResults, int firstResult) {

        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Cliente.class));
        Query q = em.createQuery(cq);
        if (!all) {
            q.setMaxResults(maxResults);
            q.setFirstResult(firstResult);
        }
        return q.getResultList();
    }

    @Override
    public Cliente findCliente(Integer id) {
        return em.find(Cliente.class, id);
    }

    @Override
    public int getClienteCount() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        Root<Cliente> rt = cq.from(Cliente.class);
        cq.select(em.getCriteriaBuilder().count(rt));
        Query q = em.createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

}
