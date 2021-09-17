/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.imd.services.login;

import com.arelance.imd.domain.Login;
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
