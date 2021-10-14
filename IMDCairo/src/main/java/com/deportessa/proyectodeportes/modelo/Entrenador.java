/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deportessa.proyectodeportes.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEntrenadorActividad", fetch = FetchType.LAZY)
    private List<Actividad> actividadListEntrenador;

    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_entrenador")
    private String nombreEntrenador;

    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "apellido_1_entrenador")
    private String apellido1Entrenador;

    @Size(max = 45)
    @Column(name = "apellido_2_entrenador")
    private String apellido2Entrenador;

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

    public String getApellido2Entrenador() {
        return apellido2Entrenador;
    }

    public void setApellido2Entrenador(String apellido2Entrenador) {
        this.apellido2Entrenador = apellido2Entrenador;
    }

    public Date getFechaAltaEntrenador() {
        return fechaAltaEntrenador;
    }

    public void setFechaAltaEntrenador(Date fechaAltaEntrenador) {
        this.fechaAltaEntrenador = fechaAltaEntrenador;
    }

    public List<Actividad> getActividadListEntrenador() {
        return actividadListEntrenador;
    }

    public void setActividadListEntrenador(List<Actividad> actividadListEntrenador) {
        this.actividadListEntrenador = actividadListEntrenador;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + Objects.hashCode(this.idEntrenador);
        hash = 19 * hash + Objects.hashCode(this.actividadListEntrenador);
        hash = 19 * hash + Objects.hashCode(this.nombreEntrenador);
        hash = 19 * hash + Objects.hashCode(this.apellido1Entrenador);
        hash = 19 * hash + Objects.hashCode(this.apellido2Entrenador);
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
        return true;
    }

    @Override
    public String toString() {
        return "Entrenador{" + "idEntrenador=" + idEntrenador + ", actividadListEntrenador=" + actividadListEntrenador + ", nombreEntrenador=" + nombreEntrenador + ", apellido1Entrenador=" + apellido1Entrenador + ", apellido2Entrenador=" + apellido2Entrenador + ", fechaAltaEntrenador=" + fechaAltaEntrenador + '}';
    }

   

}
