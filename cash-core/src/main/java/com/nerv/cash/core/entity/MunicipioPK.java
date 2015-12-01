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
public class MunicipioPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODMUNICIPIO")
    private long codmunicipio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODESTADO")
    private short codestado;

    public MunicipioPK() {
    }

    public MunicipioPK(long codmunicipio, short codestado) {
        this.codmunicipio = codmunicipio;
        this.codestado = codestado;
    }

    public long getCodmunicipio() {
        return codmunicipio;
    }

    public void setCodmunicipio(long codmunicipio) {
        this.codmunicipio = codmunicipio;
    }

    public short getCodestado() {
        return codestado;
    }

    public void setCodestado(short codestado) {
        this.codestado = codestado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codmunicipio;
        hash += (int) codestado;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MunicipioPK)) {
            return false;
        }
        MunicipioPK other = (MunicipioPK) object;
        if (this.codmunicipio != other.codmunicipio) {
            return false;
        }
        if (this.codestado != other.codestado) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nerv.cash.core.entity.MunicipioPK[ codmunicipio=" + codmunicipio + ", codestado=" + codestado + " ]";
    }
    
}
