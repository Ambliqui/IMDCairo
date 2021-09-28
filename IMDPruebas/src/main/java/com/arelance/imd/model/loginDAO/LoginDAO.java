/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.imd.model.loginDAO;

import com.arelance.imd.domain.Login;
import javax.ejb.Local;

/**
 *
 * @author Mefisto
 */
@Local
public interface LoginDAO {

    void alta(Login login);
    Login findLoginById(Login login);
    Login findLoginByEmail(Login login);
    void refreshLogin (Login login);
}
