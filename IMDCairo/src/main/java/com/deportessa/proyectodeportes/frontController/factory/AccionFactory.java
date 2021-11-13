/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deportessa.proyectodeportes.frontController.factory;

import com.deportessa.proyectodeportes.frontController.qualifiers.AccionLogin;
import com.deportessa.proyectodeportes.frontController.qualifiers.RegistroDatosLogin;
import javax.inject.Inject;
import com.deportessa.proyectodeportes.frontController.FrontControlerLocal;
import com.deportessa.proyectodeportes.frontController.qualifiers.BajaActividad;
import com.deportessa.proyectodeportes.frontController.qualifiers.CerrarSesion;
import com.deportessa.proyectodeportes.frontController.qualifiers.Inscripcion;
import com.deportessa.proyectodeportes.frontController.qualifiers.PrePrincipal;
import com.deportessa.proyectodeportes.frontController.qualifiers.PreRegistro;
import com.deportessa.proyectodeportes.frontController.qualifiers.RegistroUsuario;
import javax.ejb.Stateless;
import com.deportessa.proyectodeportes.frontController.qualifiers.DetalleActividad;
import com.deportessa.proyectodeportes.frontController.qualifiers.MisActividades;

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
    
    @Inject
    @PrePrincipal
    private FrontControlerLocal controlerPrePrincipal;
    
    @Inject
    @PreRegistro
    private FrontControlerLocal controlerPreRegistro;
    
    @Inject
    @BajaActividad
    private FrontControlerLocal controlerBaja;
    
    @Inject
    @DetalleActividad
    private FrontControlerLocal controlerDetalle;
    
    @Inject
    @MisActividades
    private FrontControlerLocal controlerMisActividades;
    
    @Inject
    @CerrarSesion
    private FrontControlerLocal controlerCerrarSesion;

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

    @Override
    public FrontControlerLocal getPreprincipal() {
        return controlerPrePrincipal;
    }

    @Override
    public FrontControlerLocal getPreRegistroUsuario() {
        return controlerPreRegistro;
    }

    @Override
    public FrontControlerLocal getBajaActividad() {
        return controlerBaja;
    }

    @Override
    public FrontControlerLocal getDetalleActividad() {
        return controlerDetalle;
    }

    @Override
    public FrontControlerLocal getMisActividades() {
        return controlerMisActividades;
    }

    @Override
    public FrontControlerLocal getCerrarSesion() {
        return controlerCerrarSesion;
    }
}
