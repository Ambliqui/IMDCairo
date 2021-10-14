/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deportessa.proyectodeportes.daoAntiguo;

import com.deportessa.proyectodeportes.modelo.Cliente;
import com.deportessa.proyectodeportes.excepcionesAntiguas.EmailIncorrectoException;
import com.deportessa.proyectodeportes.modelo.Tarjeta;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author pryet
 */
@Local
public interface ClienteDAOLocal {
    
    List<Cliente> buscarTodo();
    
    Cliente buscaPorEmail(String email);
    
    void guardar(Cliente cliente);
    
    void refresh(Cliente cliente);
}
