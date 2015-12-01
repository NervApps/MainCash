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
public class AtrasoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODEMPRESA")
    private long codempresa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODATRASO")
    private long codatraso;

    public AtrasoPK() {
    }

    public AtrasoPK(long codempresa, long codatraso) {
        this.codempresa = codempresa;
        this.codatraso = codatraso;
    }

    public long getCodempresa() {
        return codempresa;
    }

    public void setCodempresa(long codempresa) {
        this.codempresa = codempresa;
    }

    public long getCodatraso() {
        return codatraso;
    }

    public void setCodatraso(long codatraso) {
        this.codatraso = codatraso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codempresa;
        hash += (int) codatraso;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AtrasoPK)) {
            return false;
        }
        AtrasoPK other = (AtrasoPK) object;
        if (this.codempresa != other.codempresa) {
            return false;
        }
        if (this.codatraso != other.codatraso) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nerv.cash.core.entity.AtrasoPK[ codempresa=" + codempresa + ", codatraso=" + codatraso + " ]";
    }
    
}
