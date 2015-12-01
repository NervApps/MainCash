/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nerv.cash.core.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;





/**
 *
 * @author Philipe
 */
@Embeddable
public class UsuariosPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODEMPRESA")
    private long codempresa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODUSUARIO")
    private long codusuario;

    public UsuariosPK() {
    }

    public UsuariosPK(long codempresa, long codusuario) {
        this.codempresa = codempresa;
        this.codusuario = codusuario;
    }

    public long getCodempresa() {
        return codempresa;
    }

    public void setCodempresa(long codempresa) {
        this.codempresa = codempresa;
    }

    public long getCodusuario() {
        return codusuario;
    }

    public void setCodusuario(long codusuario) {
        this.codusuario = codusuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codempresa;
        hash += (int) codusuario;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuariosPK)) {
            return false;
        }
        UsuariosPK other = (UsuariosPK) object;
        if (this.codempresa != other.codempresa) {
            return false;
        }
        if (this.codusuario != other.codusuario) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nerv.cash.core.entity.UsuariosPK[ codempresa=" + codempresa + ", codusuario=" + codusuario + " ]";
    }
    
}
