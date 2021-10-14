/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deportessa.proyectodeportes.dao.implAntiguos;

import com.deportessa.proyectodeportes.daoAntiguo.TarjetaDAOLocal;
import com.deportessa.proyectodeportes.modelo.Cliente;
import com.deportessa.proyectodeportes.modelo.Tarjeta;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Antonio
 */
@Stateless
public class TarjetaDAOImpl implements TarjetaDAOLocal {

    @PersistenceContext(unitName = "pu")
    private EntityManager em;
    
    @Override
    public void guardar(Tarjeta tarjeta) {
        em.persist(tarjeta);
    }

    @Override
    public Tarjeta buscarPorId(int id) {
        return (Tarjeta) em.createNamedQuery("Tarjeta.findByIdTarjeta")
                .setParameter("idTarjeta", id) 
                .getResultList().get(0);
    }

    @Override
    public Tarjeta buscarTarjetaClientePorNumero(Cliente cliente, int numTarjeta) {
        
        return  (Tarjeta)em.createQuery("SELECT t FROM Tarjeta t WHERE t.numTarjeta = :numTarjeta AND t.cliente = :cliente")
                .setParameter("numTarjeta", numTarjeta)
                .setParameter("cliente", cliente)
                .getSingleResult();
    }
    
}
