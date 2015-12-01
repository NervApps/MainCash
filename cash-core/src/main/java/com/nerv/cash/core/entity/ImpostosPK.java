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
public class ImpostosPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODEMPRESA")
    private long codempresa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIMPOSTO")
    private long codimposto;

    public ImpostosPK() {
    }

    public ImpostosPK(long codempresa, long codimposto) {
        this.codempresa = codempresa;
        this.codimposto = codimposto;
    }

    public long getCodempresa() {
        return codempresa;
    }

    public void setCodempresa(long codempresa) {
        this.codempresa = codempresa;
    }

    public long getCodimposto() {
        return codimposto;
    }

    public void setCodimposto(long codimposto) {
        this.codimposto = codimposto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codempresa;
        hash += (int) codimposto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ImpostosPK)) {
            return false;
        }
        ImpostosPK other = (ImpostosPK) object;
        if (this.codempresa != other.codempresa) {
            return false;
        }
        if (this.codimposto != other.codimposto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nerv.cash.core.entity.ImpostosPK[ codempresa=" + codempresa + ", codimposto=" + codimposto + " ]";
    }
    
}
