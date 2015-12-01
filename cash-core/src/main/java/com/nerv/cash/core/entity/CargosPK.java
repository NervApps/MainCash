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
public class CargosPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODEMPRESA")
    private long codempresa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODCARGO")
    private long codcargo;

    public CargosPK() {
    }

    public CargosPK(long codempresa, long codcargo) {
        this.codempresa = codempresa;
        this.codcargo = codcargo;
    }

    public long getCodempresa() {
        return codempresa;
    }

    public void setCodempresa(long codempresa) {
        this.codempresa = codempresa;
    }

    public long getCodcargo() {
        return codcargo;
    }

    public void setCodcargo(long codcargo) {
        this.codcargo = codcargo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codempresa;
        hash += (int) codcargo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CargosPK)) {
            return false;
        }
        CargosPK other = (CargosPK) object;
        if (this.codempresa != other.codempresa) {
            return false;
        }
        if (this.codcargo != other.codcargo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nerv.cash.core.entity.CargosPK[ codempresa=" + codempresa + ", codcargo=" + codcargo + " ]";
    }
    
}
