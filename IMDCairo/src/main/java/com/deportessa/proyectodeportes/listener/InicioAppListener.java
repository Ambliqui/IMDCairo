/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deportessa.proyectodeportes.listener;

import com.deportessa.proyectodeportes.daojpa.factory.DaoAbstractFactoryLocal;
import com.deportessa.proyectodeportes.frontController.FrontControlerLocal;
import com.deportessa.proyectodeportes.frontController.factory.AccionFactoryLocal;
import com.deportessa.proyectodeportes.metodosPago.factory.MetodoPagoFactoryLocal;
import com.deportessa.proyectodeportes.metodosPago.MetodoPagoLocal;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.ResourceBundle;

/**
 * Web application lifecycle listener.
 *
 * @author pryet
 */
public class InicioAppListener implements ServletContextListener {


    //Inyeccion de dependencias
    @Inject
    private DaoAbstractFactoryLocal daoFactoryLocal;
    
    @Inject
    private AccionFactoryLocal factory;
    
    @Inject
    private MetodoPagoFactoryLocal pagoFactory;
    
    private final ResourceBundle bdAcciones = ResourceBundle.getBundle("bundle.acciones");
    private final ResourceBundle bdMPago = ResourceBundle.getBundle("bundle.metodosPago");


    @Override
    public void contextInitialized(ServletContextEvent sce) {

        //Mapa controlador Frontal
        Map<String,FrontControlerLocal> accionesController=new HashMap<>();
        accionesController.put(bdAcciones.getString("Login"), factory.getControlerLogin());
        accionesController.put(bdAcciones.getString("RegistroPag1"), factory.getRegistroDatosLogin());
        accionesController.put(bdAcciones.getString("RegistroPag2"), factory.getRegistroUsuario());
        accionesController.put(bdAcciones.getString("Inscribirse"), factory.getInscripcion());
        accionesController.put(bdAcciones.getString("Modificar"), factory.getModificar());
        accionesController.put(bdAcciones.getString("PrePrincipalServlet"), factory.getPreprincipal());
        accionesController.put(bdAcciones.getString("PreRegistroUsuarioServlet"), factory.getPreRegistroUsuario());
        accionesController.put(bdAcciones.getString("BajaActividad"), factory.getBajaActividad());
        accionesController.put(bdAcciones.getString("DetalleActividad"), factory.getDetalleActividad());
        accionesController.put(bdAcciones.getString("MisActividades"), factory.getMisActividades());
        accionesController.put(bdAcciones.getString("CerrarSesion"), factory.getCerrarSesion());
        accionesController.put(bdAcciones.getString("Perfil"), factory.getPerfilUsuario());
        sce.getServletContext().setAttribute("accionesController", accionesController);
        
        //Mapa metodos de pago
        Map<String,MetodoPagoLocal> mPago=new HashMap<>();
        mPago.put(bdMPago.getString("Tarjeta"), pagoFactory.getPagoTarjeta());
        mPago.put(bdMPago.getString("Paypal"), pagoFactory.getPagoPayPal());
        mPago.put(bdMPago.getString("Transferencia"), pagoFactory.getPagoTransferencia());
        sce.getServletContext().setAttribute("metodosPago", mPago);

        
        
        //Subimos las actividades al contexto
        sce.getServletContext().setAttribute("listaActividades", daoFactoryLocal.getActividadDaoLocal().findAll());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
