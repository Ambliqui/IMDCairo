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
 * @author pryet
 */
@Table(name = "paypal")
@Entity
@PrimaryKeyJoinColumn(referencedColumnName = "id_pago")
public class Paypal extends MetodoPago implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "num_paypal")
    private int numPaypal;

    public Paypal() {
    }

//    public Paypal(int numPaypal, Cliente cliente) {
//        super(cliente);
//        this.numPaypal = numPaypal;
//    }

    public Paypal(int numPaypal) {
        this.numPaypal = numPaypal;
    }
    
    @Override
    public void editarMetodoPago(MetodoPago metodoPago) {
        this.numPaypal=((Paypal)metodoPago).numPaypal;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + this.numPaypal;
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
        final Paypal other = (Paypal) obj;
        return this.numPaypal == other.numPaypal;
    }

    public int getNumPaypal() {
        return numPaypal;
    }

    public void setNumPaypal(int numPaypal) {
        this.numPaypal = numPaypal;
    }

}
