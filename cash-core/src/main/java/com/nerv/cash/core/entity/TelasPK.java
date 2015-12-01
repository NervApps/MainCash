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
public class TelasPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODEMPRESA")
    private long codempresa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODTELA")
    private long codtela;

    public TelasPK() {
    }

    public TelasPK(long codempresa, long codtela) {
        this.codempresa = codempresa;
        this.codtela = codtela;
    }

    public long getCodempresa() {
        return codempresa;
    }

    public void setCodempresa(long codempresa) {
        this.codempresa = codempresa;
    }

    public long getCodtela() {
        return codtela;
    }

    public void setCodtela(long codtela) {
        this.codtela = codtela;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codempresa;
        hash += (int) codtela;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TelasPK)) {
            return false;
        }
        TelasPK other = (TelasPK) object;
        if (this.codempresa != other.codempresa) {
            return false;
        }
        if (this.codtela != other.codtela) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nerv.cash.core.entity.TelasPK[ codempresa=" + codempresa + ", codtela=" + codtela + " ]";
    }
    
}
