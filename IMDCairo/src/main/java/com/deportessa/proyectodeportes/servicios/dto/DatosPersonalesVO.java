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
public class DatosPersonalesVO {
    
    private String nombreCliente;
    private String apellido1Cliente;
    private String telefonoCliente;

    public DatosPersonalesVO(String nombreCliente, String apellido1Cliente, String telefonoCliente) {
        this.nombreCliente = nombreCliente;
        this.apellido1Cliente = apellido1Cliente;
        this.telefonoCliente = telefonoCliente;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.nombreCliente);
        hash = 47 * hash + Objects.hashCode(this.apellido1Cliente);
        hash = 47 * hash + Objects.hashCode(this.telefonoCliente);
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
        final DatosPersonalesVO other = (DatosPersonalesVO) obj;
        if (!Objects.equals(this.nombreCliente, other.nombreCliente)) {
            return false;
        }
        if (!Objects.equals(this.apellido1Cliente, other.apellido1Cliente)) {
            return false;
        }
        if (!Objects.equals(this.telefonoCliente, other.telefonoCliente)) {
            return false;
        }
        return true;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellido1Cliente() {
        return apellido1Cliente;
    }

    public void setApellido1Cliente(String apellido1Cliente) {
        this.apellido1Cliente = apellido1Cliente;
    }

    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }
    
}
