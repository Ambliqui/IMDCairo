/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.institutomunicipaldeportes.services.pagos.impl;

import com.arelance.institutomunicipaldeportes.model.beans.MetodoPago;
import com.arelance.institutomunicipaldeportes.model.beans.Usuario;
import com.arelance.institutomunicipaldeportes.model.pagosDAO.PagosDAO;
import com.arelance.institutomunicipaldeportes.services.pagos.ServicesPago;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author Mefisto
 */
public class ServicesPagoImpl implements ServicesPago{

    @Inject
    PagosDAO pagosDAO;
    
    @Override
    public List<MetodoPago> metodosPagoUsuario(Usuario usuario) {
        return pagosDAO.metodosPagoUsuario(usuario);
    }
    
    
}
