/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package com.deportessa.proyectodeportes.daojpa.impl.postgre;

import com.deportessa.proyectodeportes.daojpa.ClienteLocal;
import com.deportessa.proyectodeportes.daojpa.DaoGenericoAbstracto;
import com.deportessa.proyectodeportes.daojpa.qulifiers.ClientePostgre;
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
@ClientePostgre
public class ClientePostgreImpl extends DaoGenericoAbstracto<Cliente, Integer> implements ClienteLocal{

    @PersistenceContext(unitName = "postgre")
    private EntityManager em;

    public ClientePostgreImpl() {
        super(Cliente.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
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
