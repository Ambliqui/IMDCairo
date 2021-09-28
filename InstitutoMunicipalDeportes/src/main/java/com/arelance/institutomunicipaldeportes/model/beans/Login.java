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
@NamedQueries({@NamedQuery(name="Login.findLogin",query= "FROM Login l  WHERE l.email =:email")
}
)
public class Login implements Serializable {
    
    private static Long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario_login")
    private Integer idLogin;
    @Column(name = "email_login")
    private String email;
    @Column(name = "password_login")
    private String password;

    public Login() {
    }
    
    public Login(Integer idLogin, String email, String password) {
        this.idLogin = idLogin;
        this.email = email;
        this.password = password;
    }

    public Integer getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(Integer idLogin) {
        this.idLogin = idLogin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Login{" + "idLogin=" + idLogin + ", email=" + email + ", password=" + password + '}';
    }
    
}
