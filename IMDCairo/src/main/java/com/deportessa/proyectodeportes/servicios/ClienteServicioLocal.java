/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deportessa.proyectodeportes.servicios;

import com.deportessa.proyectodeportes.excepcionesAntiguas.EmailEnUsoException;
import com.deportessa.proyectodeportes.excepcionesAntiguas.EmailIncorrectoException;
import com.deportessa.proyectodeportes.excepcionesAntiguas.PasswordIncorrectaException;
import com.deportessa.proyectodeportes.vista.clienteDto.ClienteRegistroDTO;
import com.deportessa.proyectodeportes.vista.clienteDto.ClienteSesionDTO;
import com.deportessa.proyectodeportes.vista.tarjetaDto.TarjetaDTO;
import javax.ejb.Local;

/**
 *
 * @author pryet
 */
@Local
public interface ClienteServicioLocal {
    
//    ClienteSesionDTO login(String email,String password)throws PasswordIncorrectaException, EmailIncorrectoException;
//      
//    void registrar(ClienteRegistroDTO clienteDTO) throws EmailEnUsoException;
//    

}
