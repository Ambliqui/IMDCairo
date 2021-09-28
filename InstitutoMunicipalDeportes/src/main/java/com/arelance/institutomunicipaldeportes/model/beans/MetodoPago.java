/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.institutomunicipaldeportes.model.beans;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Mefisto
 */

@Entity
@NamedQueries({
    @NamedQuery(name = "MetodoPago.findAll", query = "SELECT m FROM Actividad m ORDER BY m.nombre")
}
)
public class MetodoPago implements Serializable {
    
    private static Long serialVersionUID = 1L;    
    @Id
    private Integer idMetodo;
    private String nombre;

    public MetodoPago() {
    }
    
    public MetodoPago(Integer idMetodo, String nombre) {
        this.idMetodo = idMetodo;
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.idMetodo);
        hash = 67 * hash + Objects.hashCode(this.nombre);
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
        final MetodoPago other = (MetodoPago) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return Objects.equals(this.idMetodo, other.idMetodo);
    }

    @Override
    public String toString() {
        return "MetodoPago{" + "idMetodo=" + idMetodo + ", nombre=" + nombre + '}';
    }

    public Integer getIdMetodo() {
        return idMetodo;
    }

    public void setIdMetodo(Integer idMetodo) {
        this.idMetodo = idMetodo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
