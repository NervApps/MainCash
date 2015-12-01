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
public class ContasPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODEMPRESA")
    private long codempresa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODBANCO")
    private long codbanco;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODCONTA")
    private long codconta;

    public ContasPK() {
    }

    public ContasPK(long codempresa, long codbanco, long codconta) {
        this.codempresa = codempresa;
        this.codbanco = codbanco;
        this.codconta = codconta;
    }

    public long getCodempresa() {
        return codempresa;
    }

    public void setCodempresa(long codempresa) {
        this.codempresa = codempresa;
    }

    public long getCodbanco() {
        return codbanco;
    }

    public void setCodbanco(long codbanco) {
        this.codbanco = codbanco;
    }

    public long getCodconta() {
        return codconta;
    }

    public void setCodconta(long codconta) {
        this.codconta = codconta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codempresa;
        hash += (int) codbanco;
        hash += (int) codconta;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContasPK)) {
            return false;
        }
        ContasPK other = (ContasPK) object;
        if (this.codempresa != other.codempresa) {
            return false;
        }
        if (this.codbanco != other.codbanco) {
            return false;
        }
        if (this.codconta != other.codconta) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nerv.cash.core.entity.ContasPK[ codempresa=" + codempresa + ", codbanco=" + codbanco + ", codconta=" + codconta + " ]";
    }
    
}
