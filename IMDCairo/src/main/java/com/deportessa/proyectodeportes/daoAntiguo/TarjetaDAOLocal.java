/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deportessa.proyectodeportes.daoAntiguo;

import com.deportessa.proyectodeportes.modelo.Cliente;
import com.deportessa.proyectodeportes.modelo.Tarjeta;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Antonio
 */
@Local
public interface TarjetaDAOLocal {
    void guardar(Tarjeta tarjeta);
    Tarjeta buscarPorId(int id);    
    Tarjeta buscarTarjetaClientePorNumero(Cliente clienteSesionDTOaCliente, int numTarjeta);
    
}
