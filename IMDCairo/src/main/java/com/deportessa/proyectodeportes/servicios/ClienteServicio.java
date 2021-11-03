/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deportessa.proyectodeportes.servicios;

import com.deportessa.proyectodeportes.modelo.Cliente;
import com.deportessa.proyectodeportes.servicios.Excepciones.EmailNoExistsException;
import javax.ejb.Local;

/**
 *
 * @author Mefisto
 */
@Local
public interface ClienteServicio {

    
    Cliente loginCliente(Cliente cliente);

    Cliente findEmail(Cliente cliente);

    Cliente findEmail(String email)throws EmailNoExistsException;
}
