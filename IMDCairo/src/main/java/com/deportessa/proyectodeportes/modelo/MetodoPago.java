/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deportessa.proyectodeportes.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author pryet
 */
@Entity
@Table(name = "metodo_pago")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class MetodoPago implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pago")
    private int idPago;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_pago")
    private List<Inscripcion> inscripciones;
    
    public abstract void editarMetodoPago(MetodoPago metodoPago);
    
    public MetodoPago() {
    }

    public void addInscripcion(Inscripcion inscripcion){
        if(inscripciones==null){
            inscripciones=new ArrayList<>();
        }
        inscripciones.add(inscripcion);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + this.idPago;
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
        if (this.idPago != other.idPago) {
            return false;
        }
        return true;
    }

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

//    public Cliente getCliente() {
//        return clientePago;
//    }
//
//    public void setCliente(Cliente cliente) {
//        this.clientePago = cliente;
//    }

    public List<Inscripcion> getInscripciones() {
        return inscripciones;
    }

    public void setInscripciones(List<Inscripcion> inscripciones) {
        this.inscripciones = inscripciones;
    }

    @Override
    public String toString() {
        return "MetodoPago{" + "idPago=" + idPago + ", inscripciones=" + inscripciones + '}';
    }

}
