/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deportessa.proyectodeportes.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author pryet
 */
@Entity
@Table(name = "actividad")
public class Actividad implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_actividad")
    private Integer idActividad;
    
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_actividad")
    private String nombre;
    
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "lugar_actividad")
    private String lugar;

    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "descripcion_actividad")
    private String descripcion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation

    @NotNull
    @Column(name = "precio_actividad")
    private BigDecimal precio;

    @Column(name = "dias_de_clase")
    @Size(max = 20)
    private String dias;
   
    @JoinColumn(name = "id_entrenador_actividad", referencedColumnName = "id_entrenador")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Entrenador idEntrenadorActividad;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "actividad", fetch = FetchType.LAZY)
    private List<Inscripcion> inscripciones;

    public Actividad() {
    }

    public Actividad(Integer idActividad) {
        this.idActividad = idActividad;
    }

    public Actividad(String nombre, String lugar, String descripcion, BigDecimal precio, String dias) {
        this.nombre = nombre;
        this.lugar = lugar;
        this.descripcion = descripcion;
        this.precio = precio;
        this.dias = dias;
    }
    
    

    public Actividad(Integer idActividad, String nombre, String lugar, String descripcion, BigDecimal precio) {
        this.idActividad = idActividad;
        this.nombre = nombre;
        this.lugar = lugar;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public Integer getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(Integer idActividad) {
        this.idActividad = idActividad;
    }


    public Entrenador getIdEntrenadorActividad() {
        return idEntrenadorActividad;
    }

    public void setIdEntrenadorActividad(Entrenador idEntrenadorActividad) {
        this.idEntrenadorActividad = idEntrenadorActividad;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.idActividad);
        hash = 37 * hash + Objects.hashCode(this.nombre);
        hash = 37 * hash + Objects.hashCode(this.lugar);
        hash = 37 * hash + Objects.hashCode(this.descripcion);
        hash = 37 * hash + Objects.hashCode(this.precio);
        hash = 37 * hash + Objects.hashCode(this.dias);
        hash = 37 * hash + Objects.hashCode(this.idEntrenadorActividad);
        hash = 37 * hash + Objects.hashCode(this.inscripciones);
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
        final Actividad other = (Actividad) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.lugar, other.lugar)) {
            return false;
        }
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        if (!Objects.equals(this.dias, other.dias)) {
            return false;
        }
        if (!Objects.equals(this.idActividad, other.idActividad)) {
            return false;
        }
        if (!Objects.equals(this.precio, other.precio)) {
            return false;
        }
        if (!Objects.equals(this.idEntrenadorActividad, other.idEntrenadorActividad)) {
            return false;
        }
        return true;//Objects.equals(this.inscripciones, other.inscripciones);
    }


    public List<Inscripcion> getInscripciones() {
        return inscripciones;
    }

    public void setInscripciones(List<Inscripcion> inscripciones) {
        this.inscripciones = inscripciones;
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

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public String getDias() {
        return dias;
    }

    public void setDias(String dias) {
        this.dias = dias;
    }

    @Override
    public String toString() {
        return "Actividad{" + "idActividad=" + idActividad + ", nombre=" + nombre + ", lugar=" + lugar + ", descripcion=" + descripcion + ", precio=" + precio + ", dias=" + dias + ", idEntrenadorActividad=" + idEntrenadorActividad +'}';
    }

    
}
