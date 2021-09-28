/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.institutomunicipaldeportes.model.beans;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Mefisto
 */
@Entity
@NamedQueries({@NamedQuery(name="Actividad.findAll",query="SELECT a FROM Actividad a ORDER BY a.nombre")
}
)
public class Actividad implements Serializable{
    
    private static Long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_actividad")
    private Integer idActividad;
    @Column(name = "nombre_actividad")
    private String nombre;
    @Column(name = "precio_actividad")
    private Double precio;
    @Column(name = "lugar_actividad")
    private String lugar;
    @Column(name = "id_entrenador_actividad")
    private Integer idEntrenador;
    @Column(name = "descripcion_actividad")
    private String descripcion;
    @Column(name = "calendario_actividad")
    private String calendario;
    @Column(name = "hora_comienzo_actividad")
    private String horaComienzo;
    @Column(name = "hora_fin_actividad")
    private String horaFin;

    
    public Actividad() {
    }

    public Actividad(Integer idActividad, String nombre, Double precio, String lugar, Integer idEntrenador, String descripcion, String calendario, String horaComienzo, String horaFin) {
        this.idActividad = idActividad;
        this.nombre = nombre;
        this.precio = precio;
        this.lugar = lugar;
        this.idEntrenador = idEntrenador;
        this.descripcion = descripcion;
        this.calendario = calendario;
        this.horaComienzo = horaComienzo;
        this.horaFin = horaFin;
    }

    public Integer getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(Integer idActividad) {
        this.idActividad = idActividad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public Integer getIdEntrenador() {
        return idEntrenador;
    }

    public void setIdEntrenador(Integer idEntrenador) {
        this.idEntrenador = idEntrenador;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCalendario() {
        return calendario;
    }

    public void setCalendario(String calendario) {
        this.calendario = calendario;
    }

    public String getHoraComienzo() {
        return horaComienzo;
    }

    public void setHoraComienzo(String horaComienzo) {
        this.horaComienzo = horaComienzo;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    @Override
    public String toString() {
        return "Actividad{" + "id_actividad=" + idActividad + ", nombre_actividad=" + nombre + ", precio_actividad=" + precio + ", lugar_actividad=" + lugar + ", id_entrenador_actividad=" + idEntrenador + ", descripcion_actividad=" + descripcion + ", calendario_actividad=" + calendario + ", hora_comienzo_actividad=" + horaComienzo + ", hora_fin_actividad=" + horaFin + '}';
    }
    
}
