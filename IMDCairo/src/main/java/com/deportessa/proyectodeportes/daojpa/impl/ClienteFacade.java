/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deportessa.proyectodeportes.daojpa.impl;

import com.deportessa.proyectodeportes.daojpa.ClienteFacadeLocal;
import com.deportessa.proyectodeportes.modelo.Cliente;
import java.util.List;
import java.util.Optional;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author Antonio
 */
@Stateless
public class ClienteFacade extends AbstractFacade<Cliente> implements ClienteFacadeLocal {

    @PersistenceContext(unitName = "pu")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClienteFacade() {
        super(Cliente.class);
    }

    @Override
    public Optional<Cliente> findByEmail(String email) {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Cliente> query = cb.createQuery(Cliente.class);
        Root fromEmpleado = query.from(Cliente.class);
        Predicate pEmail = cb.equal(fromEmpleado.get("emailCliente"), email);
        query.select(fromEmpleado).where(pEmail);
        TypedQuery tQuery = em.createQuery(query);
        List<Cliente> resultado= tQuery.getResultList();
        if (resultado.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(resultado.get(0));
    }
    
}
