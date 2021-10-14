/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deportessa.proyectodeportes.vista.actividadDto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author pryet
 */
public class ActividadDTO implements Serializable{
    
    private static final long serialVersionUID=1L;
    private int id;
    private String nombre;
    private String lugar;
    private String descripcion;
    private BigDecimal precio;
    private String foto;

    public ActividadDTO(int id, String nombre, String lugar, String descripcion, BigDecimal precio, String foto) {
        this.id = id;
        this.nombre = nombre;
        this.lugar = lugar;
        this.descripcion = descripcion;
        this.precio = precio;
        this.foto = foto;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }


    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }



    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ActividadDTO other = (ActividadDTO) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "ActividadDTO{" + "id=" + id + ", nombre=" + nombre + ", lugar=" + lugar + ", descripcion=" + descripcion + ", precio=" + precio + '}';
    }
    
    
    
}
