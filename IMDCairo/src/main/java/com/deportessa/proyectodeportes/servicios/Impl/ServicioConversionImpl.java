/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deportessa.proyectodeportes.servicios.Impl;

import com.deportessa.proyectodeportes.servicios.ServicioConversionLocal;
import javax.ejb.Stateless;

/**
 *
 * @author Antonio
 */
@Stateless
public class ServicioConversionImpl implements ServicioConversionLocal{

//    @Override
//    public List<ActividadDTO> listaActividadAlistaDTO(List<Actividad> lista) {
//        List<ActividadDTO> listaDTO = new ArrayList<>();
//        lista.parallelStream()
//                .forEach(actividad -> listaDTO
//                            .add(actividadAactividadDTO(actividad)));
//        return listaDTO;
//    }
//
//    @Override
//    public ActividadDTO actividadAactividadDTO(Actividad actividad) {
//        return new ActividadDTO(actividad.getIdActividad(),
//                 actividad.getNombre(),
//                 actividad.getLugar(),
//                 actividad.getDescripcion(),
//                 actividad.getPrecio(),
//                 actividad.getFoto());
//    }
//
//    @Override
//    public Cliente clienteRegistroACliente(ClienteRegistroDTO clienteDTO) {
//        return new Cliente(clienteDTO.getPass(),
//                 clienteDTO.getNombre(),
//                 clienteDTO.getApellido1(),
//                 clienteDTO.getApellido2(),
//                 clienteDTO.getTelefono(),
//                 clienteDTO.getEmail());
//    }
//
//    @Override
//    public ClienteSesionDTO clienteAClienteSesionDTO(Cliente cliente) {
//        return new ClienteSesionDTO(cliente.getIdCliente(),
//                 cliente.getNombre(),
//                 cliente.getApellido1(),
//                 cliente.getApellido2(),
//                 cliente.getTelefono(),
//                 cliente.getEmail(),
//                 cliente.getFechaRegistro());
//    }
//
//    @Override
//    public Cliente clienteSesionDTOaCliente(ClienteSesionDTO clienteSesion) {
//        return new Cliente(clienteSesion.getIdCliente()
//                , clienteSesion.getNombre()
//                , clienteSesion.getApellido1()
//                , clienteSesion.getApellido2()
//                , clienteSesion.getTelefono()
//                , clienteSesion.getEmail()
//                , clienteSesion.getFechaRegistro());
//    }
//    
//    @Override
//    public Tarjeta tarjetaDTOaTarjeta(TarjetaDTO tDTO) {
//        return new Tarjeta(tDTO.getNumTarjeta(),tDTO.getIdTarjeta(), clienteSesionDTOaCliente(tDTO.getCliente()));
//    }
//
//    @Override
//    public TarjetaDTO tarjetaAtarjetaDTO(Tarjeta tarjeta) {
//        return new TarjetaDTO(tarjeta.getNumTarjeta(), tarjeta.getIdTarjeta(),clienteAClienteSesionDTO( tarjeta.getCliente()));
//    }
//
//    @Override
//    public Actividad actividadDTOaActividad(ActividadDTO actividadDTO) {
//        return new Actividad(actividadDTO.getId()
//                , actividadDTO.getNombre()
//                , actividadDTO.getLugar()
//                , actividadDTO.getDescripcion()
//                , actividadDTO.getPrecio());
//    }

    

    
}
