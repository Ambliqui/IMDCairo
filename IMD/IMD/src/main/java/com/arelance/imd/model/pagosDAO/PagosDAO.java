/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.imd.model.pagosDAO;

import com.arelance.imd.domain.FormaPago;
import com.arelance.imd.domain.Usuario;
import java.util.List;

/**
 *
 * @author Mefisto
 */

//TODO: Si pongo @Local casca el programa
public interface PagosDAO {
    
    List<FormaPago> metodosPagoUsuario(Usuario usuario);
}
