/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.institutomunicipaldeportes.model.pagosDAO;

import com.arelance.institutomunicipaldeportes.model.beans.MetodoPago;
import com.arelance.institutomunicipaldeportes.model.beans.Usuario;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Mefisto
 */

@Remote
public interface PagosDAO {
    
    List<MetodoPago> metodosPagoUsuario(Usuario usuario);
}
