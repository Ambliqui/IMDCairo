/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deportessa.proyectodeportes.servicios.Impl;

import javax.ejb.Stateless;
import com.deportessa.proyectodeportes.servicios.ActividadServicioLocal;
import com.deportessa.proyectodeportes.vista.actividadDto.ActividadDTO;
import java.util.List;

/**
 *
 * @author pryet
 */
@Stateless
public class ActividadServicioImpl implements ActividadServicioLocal {

//
//    @Inject
//    private ActividadDAOLocal actividadDAO;
//    @Inject
//    private ServicioConversionLocal conversor;
//    @Override
//    public List<ActividadDTO> obtenerActividades() {
//        List<Actividad> lista = actividadDAO.buscarTodo();
//        return conversor.listaActividadAlistaDTO(lista);
//    }
//
//    @Override
//    public ActividadDTO buscarPorId(int id) {
//        return conversor.actividadAactividadDTO(actividadDAO.buscarPorId(id));
//    }
//
//    @Override
//    public List<ActividadDTO> buscarPorNombre(String nombre) {
//        List<Actividad> lista = actividadDAO.buscarPorNombre(nombre);
//        return conversor.listaActividadAlistaDTO(lista);
//    }

}
