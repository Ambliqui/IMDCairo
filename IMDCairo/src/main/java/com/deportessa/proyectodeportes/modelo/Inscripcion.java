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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author pryet
 */
@Table(name = "inscripcion")
@Entity
public class Inscripcion implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ActividadMetodoPagoPK actividadMetodoPagoPK;

    @NotNull
    @Column(name = "fecha_alta_inscripcion",columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAltaInscripcion;

    @ManyToOne
    @MapsId("idActividadInscripcion")
    @JoinColumn(name = "id_actividad")
    private Actividad actividad;

    @ManyToOne
    @MapsId("idPagoInscripcion")
    @JoinColumn(name = "id_pago")
    private MetodoPago metodoPago;

    public Inscripcion() {
    }

    public Inscripcion(int idActividad, int idCliente) {
        this.actividadMetodoPagoPK = new ActividadMetodoPagoPK(idActividad, idCliente);
    }

    public Inscripcion(Actividad actividad, MetodoPago metodoPago) {
        this.actividad = actividad;
        this.metodoPago = metodoPago;
    }

    public Inscripcion(ActividadMetodoPagoPK actividadMetodoPagoPK) {
        this.actividadMetodoPagoPK = actividadMetodoPagoPK;
    }

    public Inscripcion(ActividadMetodoPagoPK actividadMetodoPagoPK, Date fechaAlta) {
        this.actividadMetodoPagoPK = actividadMetodoPagoPK;
        this.fechaAltaInscripcion = fechaAlta;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.actividadMetodoPagoPK);
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
        final Inscripcion other = (Inscripcion) obj;
        return Objects.equals(this.actividadMetodoPagoPK, other.actividadMetodoPagoPK);
    }
//TODO: Comprobar si es necesario hacer el new DATE() para obtener la fecha 
//o es suficienta con el column definition
    @PrePersist
    public void prePersist() {
        obtenerIds();
        obtenerFecha();
    }

    private void obtenerIds() {
        actividadMetodoPagoPK = new ActividadMetodoPagoPK(actividad.getIdActividad(), metodoPago.getIdPago());
    }

    private void obtenerFecha() {
        fechaAltaInscripcion = new Date();
    }

    public Date getFechaAlta() {
        return fechaAltaInscripcion;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAltaInscripcion = fechaAlta;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    public ActividadMetodoPagoPK getActividadMetodoPagoPK() {
        return actividadMetodoPagoPK;
    }

    public void setActividadMetodoPagoPK(ActividadMetodoPagoPK actividadMetodoPagoPK) {
        this.actividadMetodoPagoPK = actividadMetodoPagoPK;
    }

    public ActividadMetodoPagoPK getActividadClienteTarjetaPK() {
        return actividadMetodoPagoPK;
    }

    public void setActividadClienteTarjetaPK(ActividadMetodoPagoPK actividadMetodoPagoPK) {
        this.actividadMetodoPagoPK = actividadMetodoPagoPK;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    @Override
    public String toString() {
        return "Inscripcion{" + "actividadMetodoPagoPK=" + actividadMetodoPagoPK + ", fechaAlta=" + fechaAltaInscripcion + ", actividad=" + actividad + ", metodoPago=" + metodoPago + '}';
    }

}
