/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.institutomunicipaldeportes.model.loginDAO;

import com.arelance.institutomunicipaldeportes.model.beans.Login;

/**
 *
 * @author Mefisto
 */
public interface LoginDAO {

    void alta(Login login);
    Login findLoginById(Login login);
    Login findLoginByEmail(Login login);
}
