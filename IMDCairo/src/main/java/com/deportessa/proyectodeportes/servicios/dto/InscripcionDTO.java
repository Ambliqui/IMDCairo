/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deportessa.proyectodeportes.servicios.dto;

import com.deportessa.proyectodeportes.modelo.Actividad;
import com.deportessa.proyectodeportes.modelo.Cliente;
import com.deportessa.proyectodeportes.modelo.Inscripcion;
import com.deportessa.proyectodeportes.modelo.MetodoPago;
import java.io.Serializable;

/**
 *
 * @author pryet
 */
public class InscripcionDTO implements Serializable{
    
    private Cliente cliente;
    private Actividad actividad;
    private Inscripcion inscripcion;
    private MetodoPago metodoPago;

    public InscripcionDTO(Cliente cliente, Actividad actividad, Inscripcion inscripcion, MetodoPago metodoPago) {
        this.cliente = cliente;
        this.actividad = actividad;
        this.inscripcion = inscripcion;
        this.metodoPago = metodoPago;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Actividad getactividad() {
        return actividad;
    }

    public void setactividad(Actividad actividad) {
        this.actividad = actividad;
    }

    public Inscripcion getInscripcion() {
        return inscripcion;
    }

    public void setInscripcion(Inscripcion inscripcion) {
        this.inscripcion = inscripcion;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    @Override
    public String toString() {
        return "InscripcionDTO{" + "cliente=" + cliente + ", nombreActividad=" + actividad + ", inscripcion=" + inscripcion + ", metodoPago=" + metodoPago + '}';
    }
    
    
    
}
