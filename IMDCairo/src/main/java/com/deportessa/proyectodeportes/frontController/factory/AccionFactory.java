/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deportessa.proyectodeportes.frontController.factory;

import com.deportessa.proyectodeportes.frontController.qualifiers.AccionLogin;
import com.deportessa.proyectodeportes.frontController.qualifiers.RegistroDatosLogin;
import javax.inject.Inject;
import javax.inject.Singleton;
import com.deportessa.proyectodeportes.frontController.FrontControlerLocal;
import com.deportessa.proyectodeportes.frontController.qualifiers.Inscripcion;
import com.deportessa.proyectodeportes.frontController.qualifiers.RegistroUsuario;
import javax.ejb.Stateless;

/**
 *
 * @author pryet
 */
@Stateless
public class AccionFactory implements AccionFactoryLocal {

    @Inject
    @AccionLogin
    private FrontControlerLocal controlerLogin;

    @Inject
    @RegistroDatosLogin
    private FrontControlerLocal controlerDatosLogin;

    @Inject
    @RegistroUsuario
    private FrontControlerLocal controlerRegistro;

    @Inject
    @Inscripcion
    private FrontControlerLocal controlerInscripcion;

    @Override
    public FrontControlerLocal getControlerLogin() {
        return controlerLogin;
    }

    @Override
    public FrontControlerLocal getRegistroDatosLogin() {
        return controlerDatosLogin;
    }

    @Override
    public FrontControlerLocal getRegistroUsuario() {
        return controlerRegistro;
    }

    @Override
    public FrontControlerLocal getInscripcion() {
        return controlerInscripcion;
    }
}
