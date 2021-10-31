/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deportessa.proyectodeportes.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author pryet
 */
@Entity
@Table(name = "entrenador")
public class Entrenador implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_entrenador")
    private Integer idEntrenador;

    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_entrenador")
    private String nombreEntrenador;

    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "apellido_1_entrenador")
    private String apellido1Entrenador;

    @NotNull
    @Column(name = "fecha_alta_entrenador")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAltaEntrenador;

    public Entrenador() {
    }

    public Entrenador(Integer idEntrenador) {
        this.idEntrenador = idEntrenador;
    }

    public Integer getIdEntrenador() {
        return idEntrenador;
    }

    public void setIdEntrenador(Integer idEntrenador) {
        this.idEntrenador = idEntrenador;
    }

    public String getNombreEntrenador() {
        return nombreEntrenador;
    }

    public void setNombreEntrenador(String nombreEntrenador) {
        this.nombreEntrenador = nombreEntrenador;
    }

    public String getApellido1Entrenador() {
        return apellido1Entrenador;
    }

    public void setApellido1Entrenador(String apellido1Entrenador) {
        this.apellido1Entrenador = apellido1Entrenador;
    }
    
    public Date getFechaAltaEntrenador() {
        return fechaAltaEntrenador;
    }

    public void setFechaAltaEntrenador(Date fechaAltaEntrenador) {
        this.fechaAltaEntrenador = fechaAltaEntrenador;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + Objects.hashCode(this.idEntrenador);    
        hash = 19 * hash + Objects.hashCode(this.nombreEntrenador);
        hash = 19 * hash + Objects.hashCode(this.apellido1Entrenador);
        hash = 19 * hash + Objects.hashCode(this.fechaAltaEntrenador);
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
        final Entrenador other = (Entrenador) obj;
        if (!Objects.equals(this.nombreEntrenador, other.nombreEntrenador)) {
            return false;
        }
        if (!Objects.equals(this.apellido1Entrenador, other.apellido1Entrenador)) {
            return false;
        }
        if (!Objects.equals(this.idEntrenador, other.idEntrenador)) {
            return false;
        }
        return Objects.equals(this.fechaAltaEntrenador, other.fechaAltaEntrenador);
    }



    @Override
    public String toString() {
        return "Entrenador{" + "idEntrenador=" + idEntrenador +  ", nombreEntrenador=" + nombreEntrenador + ", apellido1Entrenador=" + apellido1Entrenador + ", fechaAltaEntrenador=" + fechaAltaEntrenador + '}';
    }

   

}
