/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.sgajpa.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.*;

/**
 *
 * @author salvador
 */
@Entity
@NamedQueries({@NamedQuery(name="Aficion.findAll",query="SELECT a FROM Aficion a ORDER BY a.idAficion")
}
)
@Table(name = "aficiones")
public class Aficion implements Serializable {

    private static Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_aficion")
    private int idAficion;
    @Column(name = "nombre_aficion")
    private String nombre;
    private String descripcion;
    @ManyToOne
    @JoinColumn(name = "id_persona")
    private Persona persona;

    /**
     * @return the idAficion
     */
    public int getIdAficion() {
        return idAficion;
    }

    /**
     * @param idAficion the idAficion to set
     */
    public void setIdAficion(int idAficion) {
        this.idAficion = idAficion;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

//    /**
//     * @return the persona
//     */
    public Persona getPersona() {
        return persona;
    }
//
//    /**
//     * @param persona the persona to set
//     */
    public void setPersona(Persona persona) {
        this.persona = persona;
    }

}
