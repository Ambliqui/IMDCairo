/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deportessa.proyectodeportes.daojpa;

import com.deportessa.proyectodeportes.modelo.Cliente;
import com.deportessa.proyectodeportes.daojpa.exceptions.NonexistentEntityException;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Mefisto
 */
@Local
public interface ClienteJpaControllerDao {

    public void create(Cliente cliente);

    public void edit(Cliente cliente) throws NonexistentEntityException, Exception;

    public void destroy(Integer id) throws NonexistentEntityException;

    public List<Cliente> findClienteEntities();

    public List<Cliente> findClienteEntities(int maxResults, int firstResult);

    public List<Cliente> findClienteEntities(boolean all, int maxResults, int firstResult);

    public Cliente findCliente(Integer id);

    public int getClienteCount();
}
