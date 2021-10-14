/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deportessa.proyectodeportes.servicios.Impl;

import com.deportessa.proyectodeportes.excepcionesAntiguas.YaEstasInscritoException;
import com.deportessa.proyectodeportes.daoAntiguo.ActividadClienteTarjetaDAOLocal;
import com.deportessa.proyectodeportes.daoAntiguo.ActividadDAOLocal;
import com.deportessa.proyectodeportes.daoAntiguo.ClienteDAOLocal;
import com.deportessa.proyectodeportes.daoAntiguo.TarjetaDAOLocal;

import com.deportessa.proyectodeportes.modelo.Cliente;
import com.deportessa.proyectodeportes.modelo.Tarjeta;
import com.deportessa.proyectodeportes.servicios.InscripcionTarjetaServicioLocal;
import com.deportessa.proyectodeportes.servicios.ServicioConversionLocal;
import com.deportessa.proyectodeportes.servicios.ServicioValidacionLocal;
import com.deportessa.proyectodeportes.vista.actividadDto.ActividadDTO;
import com.deportessa.proyectodeportes.vista.clienteDto.ClienteSesionDTO;
import com.deportessa.proyectodeportes.vista.tarjetaDto.TarjetaDTO;
import java.math.BigDecimal;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author pryet
 */
@Stateless
public class InscripcionTarjetaServicioImpl implements InscripcionTarjetaServicioLocal {

//    @Inject
//    private ServicioConversionLocal conversor;
//    @Inject
//    private ClienteDAOLocal cDAO;
//    @Inject
//    private ActividadClienteTarjetaDAOLocal actiCliDAO;
//    @Inject
//    private ActividadDAOLocal actiDAO;
//    @Inject
//    private TarjetaDAOLocal tarDAO;
//    @Inject
//    private ServicioValidacionLocal validador;
//    @Override
//    public void inscribir(int idActividad, ClienteSesionDTO clienteDTO, int idTarjeta)throws YaEstasInscritoException {
//        Actividad actividad=actiDAO.buscarPorId(idActividad);
//        Cliente cliente=cDAO.buscaPorEmail(clienteDTO.getEmail());
//        if(!validador.actividadInscrita(cliente, actividad)){
//            Tarjeta tarjeta=tarDAO.buscarPorId(idTarjeta);
//            actiCliDAO.guardar(new ActividadClienteTarjeta(actividad, cliente, tarjeta));
//        }else{
//            throw new YaEstasInscritoException("Ya tienes esta actividad adquirida");
//        }
//        
//    }
//
//    @Override
//    public void anularIscripcion(ClienteSesionDTO clienteDTO, int idActividad) {
//        Cliente cliente=cDAO.buscaPorEmail(clienteDTO.getEmail());
////        cliente.getActividadClienteTarjetaList();
////        cDAO.refresh(cliente);
////        cliente.getActividadClienteTarjetaList();
//        Actividad actividad=actiDAO.buscarPorId(idActividad);
//        actiCliDAO.borrar(cliente,actividad);
        
 //   }

}
