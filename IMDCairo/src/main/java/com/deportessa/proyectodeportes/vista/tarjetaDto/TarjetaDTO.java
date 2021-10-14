/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deportessa.proyectodeportes.vista.tarjetaDto;

import com.deportessa.proyectodeportes.modelo.Tarjeta;
import com.deportessa.proyectodeportes.vista.clienteDto.ClienteSesionDTO;
import java.io.Serializable;

/**
 *
 * @author Antonio
 */
public class TarjetaDTO implements Serializable{
    
    private static final long serialVersionUID = 1L;
    private int numTarjeta;
    
    private int idTarjeta;
    
    private ClienteSesionDTO cliente;

    public TarjetaDTO(int numTarjeta, int idTarjeta, ClienteSesionDTO cliente) {
        this.numTarjeta = numTarjeta;
        this.idTarjeta = idTarjeta;
        this.cliente = cliente;
    }

    public TarjetaDTO(int numTarjeta, ClienteSesionDTO cliente) {
        this.numTarjeta = numTarjeta;
        this.cliente = cliente;
    }

    public int getNumTarjeta() {
        return numTarjeta;
    }

    public void setNumTarjeta(int numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    public int getIdTarjeta() {
        return idTarjeta;
    }

    public void setIdTarjeta(int idTarjeta) {
        this.idTarjeta = idTarjeta;
    }

    public ClienteSesionDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteSesionDTO cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "TarjetaDTO{" + "numTarjeta=" + numTarjeta + ", idTarjeta=" + idTarjeta + ", cliente=" + cliente + '}';
    }

    
    
}
