/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deportessa.proyectodeportes.dao.implAntiguos;

import javax.ejb.Stateless;
import com.deportessa.proyectodeportes.modelo.Cliente;
import com.deportessa.proyectodeportes.excepcionesAntiguas.EmailIncorrectoException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.deportessa.proyectodeportes.daoAntiguo.ClienteDAOLocal;

/**
 *
 * @author pryet
 */
@Stateless
public class ClienteDAOImpl implements ClienteDAOLocal {

    @PersistenceContext(unitName = "pu")
    private EntityManager em;
    
    @Override
    public Cliente buscaPorEmail(String email){     
            return (Cliente)em.createNamedQuery("Cliente.findByEmail").setParameter("email", email).getSingleResult();
    }

    @Override
    public void guardar(Cliente cliente){
            em.persist(cliente);
    }

    @Override
    public List<Cliente> buscarTodo() {
        return em.createNamedQuery("Cliente.findAll").getResultList();
    }

    @Override
    public void refresh(Cliente cliente) {
        em.refresh(cliente);
    }

}
