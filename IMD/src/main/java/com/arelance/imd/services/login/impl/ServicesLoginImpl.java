/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.imd.services.login.impl;

import com.arelance.imd.domain.Login;
import com.arelance.imd.model.loginDAO.LoginDAO;
import com.arelance.imd.services.login.ServicesLogin;
import javax.inject.Inject;

/**
 *
 * @author Mefisto
 */
public class ServicesLoginImpl implements ServicesLogin{

    @Inject
    LoginDAO loginDAO;
    
    
    @Override
    public boolean altaLogin(Login login) {
        if(loginDAO.findLoginByEmail(login) == null){
            loginDAO.alta(login);
            return true;
        }
        return false;
    }
    
    @Override
    public Login findLoginById(Login login) {
        return loginDAO.findLoginById(login);
    }

    @Override
    public Login findLoginByEmail(Login login) {
        return loginDAO.findLoginByEmail(login);
    }   
}
