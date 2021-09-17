/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.imd.model.pagosDAO;

import com.arelance.imd.domain.FormaPago;
import com.arelance.imd.domain.Usuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Mefisto
 */

@Local
public interface PagosDAO {
    
    List<FormaPago> metodosPagoUsuario(Usuario usuario);
}
