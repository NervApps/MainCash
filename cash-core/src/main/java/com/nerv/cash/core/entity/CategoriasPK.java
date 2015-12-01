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
public class CategoriasPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODEMPRESA")
    private long codempresa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODCATEGORIA")
    private long codcategoria;

    public CategoriasPK() {
    }

    public CategoriasPK(long codempresa, long codcategoria) {
        this.codempresa = codempresa;
        this.codcategoria = codcategoria;
    }

    public long getCodempresa() {
        return codempresa;
    }

    public void setCodempresa(long codempresa) {
        this.codempresa = codempresa;
    }

    public long getCodcategoria() {
        return codcategoria;
    }

    public void setCodcategoria(long codcategoria) {
        this.codcategoria = codcategoria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codempresa;
        hash += (int) codcategoria;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CategoriasPK)) {
            return false;
        }
        CategoriasPK other = (CategoriasPK) object;
        if (this.codempresa != other.codempresa) {
            return false;
        }
        if (this.codcategoria != other.codcategoria) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nerv.cash.core.entity.CategoriasPK[ codempresa=" + codempresa + ", codcategoria=" + codcategoria + " ]";
    }
    
}
