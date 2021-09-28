/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.imd.domain;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Mefisto
 */
@Entity
@Table(name = "entrenador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Entrenador.findAll", query = "SELECT e FROM Entrenador e"),
    @NamedQuery(name = "Entrenador.findByIdEntrenador", query = "SELECT e FROM Entrenador e WHERE e.idEntrenador = :idEntrenador"),
    @NamedQuery(name = "Entrenador.findByNombreEntrenador", query = "SELECT e FROM Entrenador e WHERE e.nombreEntrenador = :nombreEntrenador"),
    @NamedQuery(name = "Entrenador.findByApellidosEntrenador", query = "SELECT e FROM Entrenador e WHERE e.apellidosEntrenador = :apellidosEntrenador")})
public class Entrenador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_entrenador")
    private Integer idEntrenador;
    @Size(max = 45)
    @Column(name = "nombre_entrenador")
    private String nombreEntrenador;
    @Size(max = 45)
    @Column(name = "apellidos_entrenador")
    private String apellidosEntrenador;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEntrenadorActividad")
    private Collection<Actividad> actividadCollection;

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

    public String getApellidosEntrenador() {
        return apellidosEntrenador;
    }

    public void setApellidosEntrenador(String apellidosEntrenador) {
        this.apellidosEntrenador = apellidosEntrenador;
    }

    @XmlTransient
    public Collection<Actividad> getActividadCollection() {
        return actividadCollection;
    }

    public void setActividadCollection(Collection<Actividad> actividadCollection) {
        this.actividadCollection = actividadCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEntrenador != null ? idEntrenador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entrenador)) {
            return false;
        }
        Entrenador other = (Entrenador) object;
        if ((this.idEntrenador == null && other.idEntrenador != null) || (this.idEntrenador != null && !this.idEntrenador.equals(other.idEntrenador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.arelance.imd.domain.Entrenador[ idEntrenador=" + idEntrenador + " ]";
    }
    
}
