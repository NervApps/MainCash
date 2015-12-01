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
public class MotivosPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODEMPRESA")
    private long codempresa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODMOTIVO")
    private long codmotivo;

    public MotivosPK() {
    }

    public MotivosPK(long codempresa, long codmotivo) {
        this.codempresa = codempresa;
        this.codmotivo = codmotivo;
    }

    public long getCodempresa() {
        return codempresa;
    }

    public void setCodempresa(long codempresa) {
        this.codempresa = codempresa;
    }

    public long getCodmotivo() {
        return codmotivo;
    }

    public void setCodmotivo(long codmotivo) {
        this.codmotivo = codmotivo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codempresa;
        hash += (int) codmotivo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MotivosPK)) {
            return false;
        }
        MotivosPK other = (MotivosPK) object;
        if (this.codempresa != other.codempresa) {
            return false;
        }
        if (this.codmotivo != other.codmotivo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nerv.cash.core.entity.MotivosPK[ codempresa=" + codempresa + ", codmotivo=" + codmotivo + " ]";
    }
    
}
