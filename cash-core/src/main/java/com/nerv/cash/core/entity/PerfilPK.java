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
public class PerfilPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODEMPRESA")
    private long codempresa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODPERFIL")
    private long codperfil;

    public PerfilPK() {
    }

    public PerfilPK(long codempresa, long codperfil) {
        this.codempresa = codempresa;
        this.codperfil = codperfil;
    }

    public long getCodempresa() {
        return codempresa;
    }

    public void setCodempresa(long codempresa) {
        this.codempresa = codempresa;
    }

    public long getCodperfil() {
        return codperfil;
    }

    public void setCodperfil(long codperfil) {
        this.codperfil = codperfil;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codempresa;
        hash += (int) codperfil;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PerfilPK)) {
            return false;
        }
        PerfilPK other = (PerfilPK) object;
        if (this.codempresa != other.codempresa) {
            return false;
        }
        if (this.codperfil != other.codperfil) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nerv.cash.core.entity.PerfilPK[ codempresa=" + codempresa + ", codperfil=" + codperfil + " ]";
    }
    
}
