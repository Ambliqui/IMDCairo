/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.deportessa.proyectodeportes.servicios.dto;

import java.util.Objects;

/**
 *
 * @author Mefisto
 */
public class DatosLoginVO {
    
    private String emailCliente;
    private String passCliente;

    public DatosLoginVO(String emailCliente, String passCliente) {
        this.emailCliente = emailCliente;
        this.passCliente = passCliente;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.emailCliente);
        hash = 79 * hash + Objects.hashCode(this.passCliente);
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
        final DatosLoginVO other = (DatosLoginVO) obj;
        if (!Objects.equals(this.emailCliente, other.emailCliente)) {
            return false;
        }
        if (!Objects.equals(this.passCliente, other.passCliente)) {
            return false;
        }
        return true;
    }
    
    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getPassCliente() {
        return passCliente;
    }

    public void setPassCliente(String passCliente) {
        this.passCliente = passCliente;
    }
    
}
