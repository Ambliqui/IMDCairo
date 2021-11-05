/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deportessa.proyectodeportes.listener;

import com.deportessa.proyectodeportes.daojpa.factory.DaoAbstractFactoryLocal;
import com.deportessa.proyectodeportes.daojpa.factory.qualifiers.FactoryDaoMySql;
import com.deportessa.proyectodeportes.modelo.Actividad;
import com.deportessa.proyectodeportes.modelo.Cliente;
import com.deportessa.proyectodeportes.modelo.Inscripcion;
import com.deportessa.proyectodeportes.modelo.Tarjeta;
import java.math.BigDecimal;
import javax.inject.Inject;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Web application lifecycle listener.
 *
 * @author pryet
 */
public class InicioAppListener implements ServletContextListener {

    // @Inject
    // ActividadServicio actividadServicio;
    @Inject
    @FactoryDaoMySql
    private DaoAbstractFactoryLocal daoFactoryLocal;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        
        //TODO: Poner actividades en Contexto
        // sce.getServletContext().setAttribute("listaActividades", daoFactoryLocal.getActividadDaoLocal().findAll());
    }

   

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
