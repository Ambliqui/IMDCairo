/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deportessa.proyectodeportes.pruebas.isi;

import com.deportessa.proyectodeportes.modelo.Cliente;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Stateless
public class ClienteTestImpl implements ClienteTest {

    
    @PersistenceContext(unitName = "mysql")
    private EntityManager em;

    @Override
    public Cliente findEmail(Cliente cliente) {
        return em.merge(cliente);
    }

    @Override
    public Cliente findEmail(String email) {

        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Cliente> criteriaQuery = criteriaBuilder.createQuery(Cliente.class);
        Root root = criteriaQuery.from(Cliente.class);
        criteriaQuery.where(criteriaBuilder.like(root.get("emailCliente"), email));
        
        TypedQuery<Cliente> typedQuery = em.createQuery(criteriaQuery);
        return typedQuery.getSingleResult();
        
    }

}
