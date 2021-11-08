/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deportessa.proyectodeportes.daojpa.impl.MySql;

import com.deportessa.proyectodeportes.daojpa.DaoGenericoAbstracto;
import com.deportessa.proyectodeportes.daojpa.ClienteLocal;
import com.deportessa.proyectodeportes.daojpa.qulifiers.ClienteMysql;
import com.deportessa.proyectodeportes.modelo.Cliente;
import java.util.Optional;
import javax.ejb.Singleton;
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
@Singleton
@ClienteMysql
public class ClienteMySqlImpl extends DaoGenericoAbstracto<Cliente, Integer> implements ClienteLocal {

     @PersistenceContext(unitName = "mysql", name = "jdbc/Sakila")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClienteMySqlImpl() {
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
        return tQuery.getResultStream().findFirst();
    }
}
