/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deportessa.proyectodeportes.pruebas.isi;

import com.deportessa.proyectodeportes.modelo.Cliente;
import javax.ejb.Local;

/**
 *
 * @author Mefisto
 */
@Local
public interface ClienteTest {
    
    
    Cliente findEmail(Cliente cliente);
    
    Cliente findEmail(String email);
    
}
