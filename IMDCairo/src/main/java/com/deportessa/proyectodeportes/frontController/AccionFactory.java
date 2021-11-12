/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deportessa.proyectodeportes.frontController;

import com.deportessa.proyectodeportes.frontController.qualifiers.AccionLogin;
import com.deportessa.proyectodeportes.frontController.qualifiers.RegistroDatosLogin;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 *
 * @author pryet
 */

@Singleton
public class AccionFactory implements AccionFactoryLocal{
    @Inject
    @AccionLogin
    private FrontControler controlerLogin;
    
    @Inject
    @RegistroDatosLogin
    private FrontControler controlerDatosLogin;
    
    @Override
    public FrontControler getControlerLogin() {
        return controlerLogin;
    }

    @Override
    public FrontControler getRegistroDatosLogin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
