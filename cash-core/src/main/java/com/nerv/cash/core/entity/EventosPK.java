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
public class EventosPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODEMPRESA")
    private long codempresa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODEVENTO")
    private long codevento;

    public EventosPK() {
    }

    public EventosPK(long codempresa, long codevento) {
        this.codempresa = codempresa;
        this.codevento = codevento;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codempresa;
        hash += (int) codevento;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EventosPK)) {
            return false;
        }
        EventosPK other = (EventosPK) object;
        if (this.codempresa != other.codempresa) {
            return false;
        }
        if (this.codevento != other.codevento) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nerv.cash.core.entity.EventosPK[ codempresa=" + codempresa + ", codevento=" + codevento + " ]";
    }
    
}
