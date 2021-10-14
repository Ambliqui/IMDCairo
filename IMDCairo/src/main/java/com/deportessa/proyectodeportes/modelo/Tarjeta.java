/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deportessa.proyectodeportes.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Antonio
 */
@Table(name = "tarjeta")
@Entity
@PrimaryKeyJoinColumn(referencedColumnName = "id_pago")
public class Tarjeta extends MetodoPago implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "num_tarjeta")
    private int numTarjeta;
    @NotNull
    @Column(name = "mes_tarjeta")
    private int mesTarjeta;
    @NotNull
    @Column(name = "anno_tarjeta")
    private int annoTarjeta;
    @NotNull
    @Column(name = "cvs_tarjeta")
    private int cvsTarjeta;

    public Tarjeta() {
    }

    public Tarjeta(int numTarjeta, int mesTarjeta, int annoTarjeta, int cvsTarjeta) {
        //super(clientePago);
        this.numTarjeta = numTarjeta;
        this.mesTarjeta = mesTarjeta;
        this.annoTarjeta = annoTarjeta;
        this.cvsTarjeta = cvsTarjeta;
    }
    
    @Override
    public void editarMetodoPago(MetodoPago metodoPago) {
        this.annoTarjeta=((Tarjeta)metodoPago).annoTarjeta;
        this.cvsTarjeta=((Tarjeta)metodoPago).cvsTarjeta;
        this.mesTarjeta=((Tarjeta)metodoPago).mesTarjeta;
        this.numTarjeta=((Tarjeta)metodoPago).numTarjeta;
        //super.setCliente(((Tarjeta)metodoPago).getCliente());
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.numTarjeta;
        hash = 37 * hash + this.mesTarjeta;
        hash = 37 * hash + this.annoTarjeta;
        hash = 37 * hash + this.cvsTarjeta;
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
        final Tarjeta other = (Tarjeta) obj;
        if (this.numTarjeta != other.numTarjeta) {
            return false;
        }
        if (this.mesTarjeta != other.mesTarjeta) {
            return false;
        }
        if (this.annoTarjeta != other.annoTarjeta) {
            return false;
        }
        if (this.cvsTarjeta != other.cvsTarjeta) {
            return false;
        }
        return true;
    }

    public int getNumTarjeta() {
        return numTarjeta;
    }

    public void setNumTarjeta(int numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    public int getMesTarjeta() {
        return mesTarjeta;
    }

    public void setMesTarjeta(int mesTarjeta) {
        this.mesTarjeta = mesTarjeta;
    }

    public int getAnnoTarjeta() {
        return annoTarjeta;
    }

    public void setAnnoTarjeta(int annoTarjeta) {
        this.annoTarjeta = annoTarjeta;
    }

    public int getCvsTarjeta() {
        return cvsTarjeta;
    }

    public void setCvsTarjeta(int cvsTarjeta) {
        this.cvsTarjeta = cvsTarjeta;
    }

    @Override
    public String toString() {
        return "Tarjeta{" + "numTarjeta=" + numTarjeta + ", mesTarjeta=" + mesTarjeta + ", annoTarjeta=" + annoTarjeta + ", cvsTarjeta=" + cvsTarjeta + '}';
    }

    

}
