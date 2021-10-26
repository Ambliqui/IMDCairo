/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deportessa.proyectodeportes.listener;


import com.deportessa.proyectodeportes.daojpa.ActividadFacadeLocal;
import com.deportessa.proyectodeportes.servicios.ActividadServicio;
import javax.inject.Inject;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Web application lifecycle listener.
 *
 * @author pryet
 */
public class InicioAppListener implements ServletContextListener {

    @Inject
    ActividadServicio actividadServicio;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().setAttribute("listaActividades", actividadServicio.findAll());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
