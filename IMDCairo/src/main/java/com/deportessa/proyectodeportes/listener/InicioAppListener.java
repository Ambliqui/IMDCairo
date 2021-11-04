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
        if(daoFactoryLocal.getActividadDaoLocal().findAll().isEmpty()){
            inicializarbbdd();
        }
        
        //TODO: Poner actividades en Contexto
       // sce.getServletContext().setAttribute("listaActividades", daoFactoryLocal.getActividadDaoLocal().findAll());
    }

    private void inicializarbbdd() {
        //crear clientes
        Cliente cliente = new Cliente("1@1", "1", "Paco", "perez", "666555444");
        Cliente cliente1 = new Cliente("2@2", "1", "Maria", "Martínez", "666333999");
        daoFactoryLocal.getClienteDaoLocal().create(cliente);
        daoFactoryLocal.getClienteDaoLocal().create(cliente1);

        //crear actividades
        Actividad actividad = new Actividad("Fútbol", "Campo de fútbol", "Dale a la pelota con el pie", new BigDecimal(13), "M-Mi-J");
        Actividad actividad2 = new Actividad("Natacióin", "Piscina cubierta", "Respirar siempre con la cabeza fuera del agua", new BigDecimal(18), "M-Mi-J");
        Actividad actividad3 = new Actividad("Ajedrez", "Sala de ajedrez", "Si no quieres lesionarte esta es tu actividad", new BigDecimal(7), "L-M-V");
        Actividad actividad4 = new Actividad("Baloncesto", "Polideportivo", "Te vas a doblar el dedo para atras", new BigDecimal(10), "Mi-V");
        Actividad actividad5 = new Actividad("Jockey", "Polideportivo", "Dale a la pelota con el palo", new BigDecimal(10), "L-Mi-V");
        Actividad actividad6 = new Actividad("Tenis", "Polideportivo", "Por la tele se ve mas facil", new BigDecimal(18), "M-Mi-J");
        daoFactoryLocal.getActividadDaoLocal().create(actividad);
        daoFactoryLocal.getActividadDaoLocal().create(actividad2);
        daoFactoryLocal.getActividadDaoLocal().create(actividad3);
        daoFactoryLocal.getActividadDaoLocal().create(actividad4);
        daoFactoryLocal.getActividadDaoLocal().create(actividad5);
        daoFactoryLocal.getActividadDaoLocal().create(actividad6);

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
