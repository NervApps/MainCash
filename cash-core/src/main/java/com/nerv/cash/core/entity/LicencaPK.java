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
public class LicencaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODEMPRESA")
    private long codempresa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODLICENCA")
    private long codlicenca;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODPRODUTO")
    private long codproduto;

    public LicencaPK() {
    }

    public LicencaPK(long codempresa, long codlicenca, long codproduto) {
        this.codempresa = codempresa;
        this.codlicenca = codlicenca;
        this.codproduto = codproduto;
    }

    public long getCodempresa() {
        return codempresa;
    }

    public void setCodempresa(long codempresa) {
        this.codempresa = codempresa;
    }

    public long getCodlicenca() {
        return codlicenca;
    }

    public void setCodlicenca(long codlicenca) {
        this.codlicenca = codlicenca;
    }

    public long getCodproduto() {
        return codproduto;
    }

    public void setCodproduto(long codproduto) {
        this.codproduto = codproduto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codempresa;
        hash += (int) codlicenca;
        hash += (int) codproduto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LicencaPK)) {
            return false;
        }
        LicencaPK other = (LicencaPK) object;
        if (this.codempresa != other.codempresa) {
            return false;
        }
        if (this.codlicenca != other.codlicenca) {
            return false;
        }
        if (this.codproduto != other.codproduto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nerv.cash.core.entity.LicencaPK[ codempresa=" + codempresa + ", codlicenca=" + codlicenca + ", codproduto=" + codproduto + " ]";
    }
    
}
