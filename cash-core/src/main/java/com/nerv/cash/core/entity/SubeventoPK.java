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
public class SubeventoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODEMPRESA")
    private long codempresa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODEVENTO")
    private long codevento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODSUBEVENTO")
    private long codsubevento;

    public SubeventoPK() {
    }

    public SubeventoPK(long codempresa, long codevento, long codsubevento) {
        this.codempresa = codempresa;
        this.codevento = codevento;
        this.codsubevento = codsubevento;
    }

    public long getCodempresa() {
        return codempresa;
    }

    public void setCodempresa(long codempresa) {
        this.codempresa = codempresa;
    }

    public long getCodevento() {
        return codevento;
    }

    public void setCodevento(long codevento) {
        this.codevento = codevento;
    }

    public long getCodsubevento() {
        return codsubevento;
    }

    public void setCodsubevento(long codsubevento) {
        this.codsubevento = codsubevento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codempresa;
        hash += (int) codevento;
        hash += (int) codsubevento;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SubeventoPK)) {
            return false;
        }
        SubeventoPK other = (SubeventoPK) object;
        if (this.codempresa != other.codempresa) {
            return false;
        }
        if (this.codevento != other.codevento) {
            return false;
        }
        if (this.codsubevento != other.codsubevento) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nerv.cash.core.entity.SubeventoPK[ codempresa=" + codempresa + ", codevento=" + codevento + ", codsubevento=" + codsubevento + " ]";
    }
    
}
