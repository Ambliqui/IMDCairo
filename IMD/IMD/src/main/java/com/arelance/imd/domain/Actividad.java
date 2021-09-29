/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.imd.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Mefisto
 */
@Entity
@Table(name = "actividad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Actividad.findAll", query = "SELECT a FROM Actividad a"),
    @NamedQuery(name = "Actividad.findByIdActividad", query = "SELECT a FROM Actividad a WHERE a.idActividad = :idActividad"),
    @NamedQuery(name = "Actividad.findByNombreActividad", query = "SELECT a FROM Actividad a WHERE a.nombreActividad = :nombreActividad"),
    @NamedQuery(name = "Actividad.findByPrecioActividad", query = "SELECT a FROM Actividad a WHERE a.precioActividad = :precioActividad"),
    @NamedQuery(name = "Actividad.findByLugarActividad", query = "SELECT a FROM Actividad a WHERE a.lugarActividad = :lugarActividad"),
    @NamedQuery(name = "Actividad.findByDescripcionActividad", query = "SELECT a FROM Actividad a WHERE a.descripcionActividad = :descripcionActividad"),
    @NamedQuery(name = "Actividad.findByCalendarioActividad", query = "SELECT a FROM Actividad a WHERE a.calendarioActividad = :calendarioActividad"),
    @NamedQuery(name = "Actividad.findByHoraComienzoActividad", query = "SELECT a FROM Actividad a WHERE a.horaComienzoActividad = :horaComienzoActividad"),
    @NamedQuery(name = "Actividad.findByHoraFinActividad", query = "SELECT a FROM Actividad a WHERE a.horaFinActividad = :horaFinActividad")})
public class Actividad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_actividad")
    private Integer idActividad;
    @Size(max = 45)
    @Column(name = "nombre_actividad")
    private String nombreActividad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precio_actividad")
    private Double precioActividad;
    @Size(max = 45)
    @Column(name = "lugar_actividad")
    private String lugarActividad;
    @Size(max = 10000)
    @Column(name = "descripcion_actividad")
    private String descripcionActividad;
    @Size(max = 45)
    @Column(name = "calendario_actividad")
    private String calendarioActividad;
    @Column(name = "hora_comienzo_actividad")
    @Temporal(TemporalType.TIME)
    private Date horaComienzoActividad;
    @Column(name = "hora_fin_actividad")
    @Temporal(TemporalType.TIME)
    private Date horaFinActividad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "actividad")
    private Collection<Inscripcion> inscripcionCollection;
    @JoinColumn(name = "id_entrenador_actividad", referencedColumnName = "id_entrenador")
    @ManyToOne(optional = false)
    private Entrenador idEntrenadorActividad;

    public Actividad() {
    }

    public Actividad(Integer idActividad) {
        this.idActividad = idActividad;
    }

    public Integer getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(Integer idActividad) {
        this.idActividad = idActividad;
    }

    public String getNombreActividad() {
        return nombreActividad;
    }

    public void setNombreActividad(String nombreActividad) {
        this.nombreActividad = nombreActividad;
    }

    public Double getPrecioActividad() {
        return precioActividad;
    }

    public void setPrecioActividad(Double precioActividad) {
        this.precioActividad = precioActividad;
    }

    public String getLugarActividad() {
        return lugarActividad;
    }

    public void setLugarActividad(String lugarActividad) {
        this.lugarActividad = lugarActividad;
    }

    public String getDescripcionActividad() {
        return descripcionActividad;
    }

    public void setDescripcionActividad(String descripcionActividad) {
        this.descripcionActividad = descripcionActividad;
    }

    public String getCalendarioActividad() {
        return calendarioActividad;
    }

    public void setCalendarioActividad(String calendarioActividad) {
        this.calendarioActividad = calendarioActividad;
    }

    public Date getHoraComienzoActividad() {
        return horaComienzoActividad;
    }

    public void setHoraComienzoActividad(Date horaComienzoActividad) {
        this.horaComienzoActividad = horaComienzoActividad;
    }

    public Date getHoraFinActividad() {
        return horaFinActividad;
    }

    public void setHoraFinActividad(Date horaFinActividad) {
        this.horaFinActividad = horaFinActividad;
    }

    @XmlTransient
    public Collection<Inscripcion> getInscripcionCollection() {
        return inscripcionCollection;
    }

    public void setInscripcionCollection(Collection<Inscripcion> inscripcionCollection) {
        this.inscripcionCollection = inscripcionCollection;
    }

    public Entrenador getIdEntrenadorActividad() {
        return idEntrenadorActividad;
    }

    public void setIdEntrenadorActividad(Entrenador idEntrenadorActividad) {
        this.idEntrenadorActividad = idEntrenadorActividad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idActividad != null ? idActividad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Actividad)) {
            return false;
        }
        Actividad other = (Actividad) object;
        if ((this.idActividad == null && other.idActividad != null) || (this.idActividad != null && !this.idActividad.equals(other.idActividad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.arelance.imd.domain.Actividad[ idActividad=" + idActividad + " ]";
    }
    
}
