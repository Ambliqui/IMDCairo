/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deportessa.proyectodeportes.servicios.impl;

import com.deportessa.proyectodeportes.servicios.Excepciones.EmailNoExistsException;
import com.deportessa.proyectodeportes.daojpa.ClienteFacadeLocal;
import com.deportessa.proyectodeportes.modelo.Cliente;
import com.deportessa.proyectodeportes.servicios.ClienteServicio;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.function.Supplier;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class ClienteServicioImpl implements ClienteServicio {

    @Inject
    ClienteFacadeLocal clienteDao;
    
    @Override
    public Cliente loginCliente(Cliente cliente) {
        //TODO: Devolver un cliente DTO
//        cliente = clienteDao.edit(cliente);
        return clienteDao.find(cliente.getIdCliente());
    }

    @Override
    public Cliente findEmail(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cliente findEmail(String email) throws EmailNoExistsException{
        Optional <Cliente> cliente =clienteDao.findByEmail(email);
        return cliente.orElseThrow(() -> new EmailNoExistsException(ResourceBundle.getBundle("bundle.errores").getString("cliente.emailnotfound")));
    }
    
}
