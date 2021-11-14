/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deportessa.proyectodeportes.servicios;

import com.deportessa.proyectodeportes.modelo.Actividad;
import com.deportessa.proyectodeportes.modelo.Cliente;
import com.deportessa.proyectodeportes.modelo.MetodoPago;
import com.deportessa.proyectodeportes.servicios.excepciones.EmailNoExistsException;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Mefisto
 * @param <T>
 */
@Local
public interface ClienteServicio {

    List<Actividad> getMisActividades(Cliente cliente);
    
    Cliente loginCliente(Cliente cliente);

    Cliente findEmail(Cliente cliente);

    Cliente findEmail(String email)throws EmailNoExistsException;
    
    List<MetodoPago> findMetodoPagoByTipo(Cliente cliente,Class tipo);
}
