/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.institutomunicipaldeportes.services.login;

import com.arelance.institutomunicipaldeportes.model.beans.Login;
import javax.ejb.Local;

/**
 *
 * @author Mefisto
 */

@Local
public interface ServicesLogin {
    
    public boolean altaLogin (Login login);
    public Login findLoginById(Login login);
    public Login findLoginByEmail(Login login);
    
}
