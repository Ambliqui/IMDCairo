/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deportessa.proyectodeportes.servicios.Impl;

import com.deportessa.proyectodeportes.daoAntiguo.ClienteDAOLocal;
import com.deportessa.proyectodeportes.excepcionesAntiguas.EmailIncorrectoException;
import com.deportessa.proyectodeportes.excepcionesAntiguas.PasswordIncorrectaException;
import com.deportessa.proyectodeportes.excepcionesAntiguas.EmailEnUsoException;
import com.deportessa.proyectodeportes.modelo.Cliente;
import javax.ejb.Stateless;
import com.deportessa.proyectodeportes.servicios.ClienteServicioLocal;
import com.deportessa.proyectodeportes.servicios.ServicioConversionLocal;
import com.deportessa.proyectodeportes.vista.clienteDto.ClienteRegistroDTO;
import com.deportessa.proyectodeportes.vista.clienteDto.ClienteSesionDTO;
import com.deportessa.proyectodeportes.vista.tarjetaDto.TarjetaDTO;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author pryet
 */



@Stateless
public class ClienteServicioImpl implements ClienteServicioLocal {

//    @Inject
//    private ClienteDAOLocal clienteDAO;
//    @Inject
//    private ServicioConversionLocal conversor;
//    @Override
//    public ClienteSesionDTO login(String email, String password) throws PasswordIncorrectaException, EmailIncorrectoException {
//
//        if (clienteDAO.buscarTodo().contains(new Cliente(email))) {
//            Cliente cliente = clienteDAO.buscaPorEmail(email);
//
//            if (cliente.getPass().equals(password)) {
//                return conversor.clienteAClienteSesionDTO(cliente);
//            }
//            throw new PasswordIncorrectaException("Password Incorrecta");
//        }
//        throw new EmailIncorrectoException("Email no registrado en el sistema");
//
//    }
//
//    @Override
//    public void registrar(ClienteRegistroDTO clienteDTO) throws EmailEnUsoException {
//        List<Cliente> lista = clienteDAO.buscarTodo();
//        Cliente cliente = conversor.clienteRegistroACliente(clienteDTO);
//        if (!lista.contains(cliente)) {
//            clienteDAO.guardar(cliente);
//            return;
//        }
//        throw new EmailEnUsoException("Email en uso");
//
//    }


}
