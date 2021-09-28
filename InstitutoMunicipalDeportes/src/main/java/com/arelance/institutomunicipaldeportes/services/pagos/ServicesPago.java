/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.institutomunicipaldeportes.services.pagos;

import com.arelance.institutomunicipaldeportes.model.beans.MetodoPago;
import com.arelance.institutomunicipaldeportes.model.beans.Usuario;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Mefisto
 */

@Remote
public interface ServicesPago {
    
    List<MetodoPago> metodosPagoUsuario(Usuario usuario);
}
