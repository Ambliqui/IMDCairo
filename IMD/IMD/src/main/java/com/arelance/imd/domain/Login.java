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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Mefisto
 */
@Entity
@Table(name = "login")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Login.findAll", query = "SELECT l FROM Login l"),
    @NamedQuery(name = "Login.findByIdUsuarioLogin", query = "SELECT l FROM Login l WHERE l.idUsuarioLogin = :idUsuarioLogin"),
    @NamedQuery(name = "Login.findByEmailLogin", query = "SELECT l FROM Login l WHERE l.emailLogin = :emailLogin"),
    @NamedQuery(name = "Login.findByPasswordLogin", query = "SELECT l FROM Login l WHERE l.passwordLogin = :passwordLogin")})
public class Login implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_usuario_login")
    private Integer idUsuarioLogin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "email_login")
    private String emailLogin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "password_login")
    private String passwordLogin;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "login")
    private Collection<Usuario> usuarioCollection;

    public Login() {
    }

    public Login(Integer idUsuarioLogin) {
        this.idUsuarioLogin = idUsuarioLogin;
    }

    public Login(Integer idUsuarioLogin, String emailLogin, String passwordLogin) {
        this.idUsuarioLogin = idUsuarioLogin;
        this.emailLogin = emailLogin;
        this.passwordLogin = passwordLogin;
    }

    public Integer getIdUsuarioLogin() {
        return idUsuarioLogin;
    }

    public void setIdUsuarioLogin(Integer idUsuarioLogin) {
        this.idUsuarioLogin = idUsuarioLogin;
    }

    public String getEmailLogin() {
        return emailLogin;
    }

    public void setEmailLogin(String emailLogin) {
        this.emailLogin = emailLogin;
    }

    public String getPasswordLogin() {
        return passwordLogin;
    }

    public void setPasswordLogin(String passwordLogin) {
        this.passwordLogin = passwordLogin;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuarioLogin != null ? idUsuarioLogin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Login)) {
            return false;
        }
        Login other = (Login) object;
        if ((this.idUsuarioLogin == null && other.idUsuarioLogin != null) || (this.idUsuarioLogin != null && !this.idUsuarioLogin.equals(other.idUsuarioLogin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.arelance.imd.domain.Login[ idUsuarioLogin=" + idUsuarioLogin + " ]";
    }
    
}
