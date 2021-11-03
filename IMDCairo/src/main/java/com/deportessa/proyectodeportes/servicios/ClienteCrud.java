/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deportessa.proyectodeportes.servicios;

import com.deportessa.proyectodeportes.daojpa.ClienteFacadeLocal;
import com.deportessa.proyectodeportes.modelo.Cliente;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author Mefisto
 */

public class ClienteCrud implements Crud<Cliente>{
    
    
    @Inject
    ClienteFacadeLocal clienteFacadeLocal;

    @Override
    public void create(Cliente t) {
        clienteFacadeLocal.create(t);
    }

    @Override
    public void update(Cliente t) {
        clienteFacadeLocal.edit(t);
    }

    @Override
    public void delete(Cliente t) {
        clienteFacadeLocal.remove(t);
    }

    @Override
    public Cliente read(Integer n) {
        return clienteFacadeLocal.find(n);
    }

    @Override
    public List<Cliente> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
