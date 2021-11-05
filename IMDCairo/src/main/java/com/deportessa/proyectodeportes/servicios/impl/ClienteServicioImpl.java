/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deportessa.proyectodeportes.servicios.impl;

import com.deportessa.proyectodeportes.servicios.excepciones.EmailNoExistsException;
import com.deportessa.proyectodeportes.daojpa.factory.DaoAbstractFactoryLocal;
import com.deportessa.proyectodeportes.daojpa.factory.qualifiers.FactoryDaoMySql;
import com.deportessa.proyectodeportes.modelo.Actividad;
import com.deportessa.proyectodeportes.modelo.Cliente;
import com.deportessa.proyectodeportes.servicios.ClienteServicio;
import com.deportessa.proyectodeportes.servicios.InscripcionServicio;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class ClienteServicioImpl implements ClienteServicio {

    
    @Inject
    @FactoryDaoMySql
    private DaoAbstractFactoryLocal daoFactoryLocal;
    
    @Inject
    private InscripcionServicio inscServ;
    
    @Override
    public Cliente loginCliente(Cliente cliente) {
        //TODO: Devolver un cliente DTO
//        cliente = clienteDao.edit(cliente);
        return daoFactoryLocal.getClienteDaoLocal().find(cliente.getIdCliente());
    }
    @Override
    public List<Actividad> getMisActividades(Cliente cliente){
        List<Actividad> misActividades=new ArrayList<>();
        inscServ.getInscripciones(cliente).forEach((insc)->misActividades.add(insc.getActividad()));
        return misActividades;
    }

    @Override
    public Cliente findEmail(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cliente findEmail(String email) throws EmailNoExistsException{
        Optional <Cliente> cliente =daoFactoryLocal.getClienteDaoLocal().findByEmail(email);
        return cliente.orElseThrow(() -> new EmailNoExistsException(ResourceBundle.getBundle("bundle.errores").getString("cliente.emailnotfound")));
    }
    
}
