/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.imd.services.pagos.impl;

import com.arelance.imd.domain.FormaPago;
import com.arelance.imd.domain.Usuario;
import com.arelance.imd.model.pagosDAO.PagosDAO;
import com.arelance.imd.services.pagos.ServicesPago;
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
    public List<FormaPago> metodosPagoUsuario(Usuario usuario) {
        return pagosDAO.metodosPagoUsuario(usuario);
    }
    
    
}
