/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deportessa.proyectodeportes.servicios.impl;

import com.deportessa.proyectodeportes.daojpa.ClienteFacadeLocal;
import com.deportessa.proyectodeportes.modelo.Cliente;
import com.deportessa.proyectodeportes.servicios.ClienteServicio;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class ClienteServicioImpl implements ClienteServicio {

    @Inject
    ClienteFacadeLocal clienteDao;
    
    @Override
    public Cliente loginCliente(Cliente cliente) {
        //TODO: Devolver un cliente administrado desde el DAO
//        cliente = clienteDao.edit(cliente);
        return clienteDao.find(cliente.getIdCliente());
    }
    
}
