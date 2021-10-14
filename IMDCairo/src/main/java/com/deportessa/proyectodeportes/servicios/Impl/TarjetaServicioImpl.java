/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deportessa.proyectodeportes.servicios.Impl;

import com.deportessa.proyectodeportes.daoAntiguo.ClienteDAOLocal;
import com.deportessa.proyectodeportes.excepcionesAntiguas.TarjetaRepetidaException;
import com.deportessa.proyectodeportes.daoAntiguo.TarjetaDAOLocal;
import com.deportessa.proyectodeportes.modelo.Cliente;
import com.deportessa.proyectodeportes.modelo.Tarjeta;
import com.deportessa.proyectodeportes.servicios.ClienteServicioLocal;
import com.deportessa.proyectodeportes.servicios.ServicioConversionLocal;
import com.deportessa.proyectodeportes.servicios.ServicioValidacionLocal;
import com.deportessa.proyectodeportes.servicios.TarjetaServicioLocal;
import com.deportessa.proyectodeportes.vista.clienteDto.ClienteSesionDTO;
import com.deportessa.proyectodeportes.vista.tarjetaDto.TarjetaDTO;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Antonio
 */
@Stateless
public class TarjetaServicioImpl implements TarjetaServicioLocal {

//    @Inject
//    private TarjetaDAOLocal tDAO;
//    @Inject
//    private ServicioConversionLocal conversor;
//    @Inject
//    private ServicioValidacionLocal validador;
//    @Inject
//    private ClienteDAOLocal cDAO;
//    @Override
//    public void guardar(TarjetaDTO tarjeta)throws TarjetaRepetidaException{
//        if(validador.validarTarjeta(tarjeta)){
//        tDAO.guardar(conversor.tarjetaDTOaTarjeta(tarjeta));
//        }else{
//            throw new TarjetaRepetidaException("Ya existe esta tarjeta");
//        }
//    }
//
//    @Override
//    public List<TarjetaDTO> buscarTarjetasCliente(ClienteSesionDTO clienteDTO) {
//        List<TarjetaDTO> listaDTO=new ArrayList<>();
//        for (Tarjeta tarjeta : cDAO.buscaPorEmail(clienteDTO.getEmail()).getTarjetaList()) {
//            listaDTO.add(conversor.tarjetaAtarjetaDTO(tarjeta));
//        }
//        return listaDTO;
//    }
//
//    @Override
//    public TarjetaDTO buscarTarjetaCliente(ClienteSesionDTO clienteDTO, int numTarjeta) {
//        Tarjeta tarjeta=tDAO.buscarTarjetaClientePorNumero(conversor.clienteSesionDTOaCliente(clienteDTO),numTarjeta);
//        return conversor.tarjetaAtarjetaDTO(tarjeta);
//    }

}
