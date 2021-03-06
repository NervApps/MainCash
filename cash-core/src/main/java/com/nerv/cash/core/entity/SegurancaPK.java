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
public class SegurancaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODEMPRESA")
    private long codempresa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODSEGURANCA")
    private long codseguranca;

    public SegurancaPK() {
    }

    public SegurancaPK(long codempresa, long codseguranca) {
        this.codempresa = codempresa;
        this.codseguranca = codseguranca;
    }

    public long getCodempresa() {
        return codempresa;
    }

    public void setCodempresa(long codempresa) {
        this.codempresa = codempresa;
    }

    public long getCodseguranca() {
        return codseguranca;
    }

    public void setCodseguranca(long codseguranca) {
        this.codseguranca = codseguranca;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codempresa;
        hash += (int) codseguranca;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegurancaPK)) {
            return false;
        }
        SegurancaPK other = (SegurancaPK) object;
        if (this.codempresa != other.codempresa) {
            return false;
        }
        if (this.codseguranca != other.codseguranca) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nerv.cash.core.entity.SegurancaPK[ codempresa=" + codempresa + ", codseguranca=" + codseguranca + " ]";
    }
    
}
