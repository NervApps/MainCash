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
public class ClientesPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODEMPRESA")
    private long codempresa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODCLIENTE")
    private long codcliente;

    public ClientesPK() {
    }

    public ClientesPK(long codempresa, long codcliente) {
        this.codempresa = codempresa;
        this.codcliente = codcliente;
    }

    public long getCodempresa() {
        return codempresa;
    }

    public void setCodempresa(long codempresa) {
        this.codempresa = codempresa;
    }

    public long getCodcliente() {
        return codcliente;
    }

    public void setCodcliente(long codcliente) {
        this.codcliente = codcliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codempresa;
        hash += (int) codcliente;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClientesPK)) {
            return false;
        }
        ClientesPK other = (ClientesPK) object;
        if (this.codempresa != other.codempresa) {
            return false;
        }
        if (this.codcliente != other.codcliente) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nerv.cash.core.entity.ClientesPK[ codempresa=" + codempresa + ", codcliente=" + codcliente + " ]";
    }
    
}
