/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nerv.cash.core.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Philipe
 */
@Entity
@Table(name = "RAMOATIVIDADE")
@NamedQueries({
    @NamedQuery(name = "Ramoatividade.findAll", query = "SELECT r FROM Ramoatividade r"),
    @NamedQuery(name = "Ramoatividade.findByCodramo", query = "SELECT r FROM Ramoatividade r WHERE r.codramo = :codramo"),
    @NamedQuery(name = "Ramoatividade.findByDescramoatividade", query = "SELECT r FROM Ramoatividade r WHERE r.descramoatividade = :descramoatividade")})
public class Ramoatividade implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODRAMO")
    private Long codramo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "DESCRAMOATIVIDADE")
    private String descramoatividade;

    public Ramoatividade() {
    }

    public Ramoatividade(Long codramo) {
        this.codramo = codramo;
    }

    public Ramoatividade(Long codramo, String descramoatividade) {
        this.codramo = codramo;
        this.descramoatividade = descramoatividade;
    }

    public Long getCodramo() {
        return codramo;
    }

    public void setCodramo(Long codramo) {
        this.codramo = codramo;
    }

    public String getDescramoatividade() {
        return descramoatividade;
    }

    public void setDescramoatividade(String descramoatividade) {
        this.descramoatividade = descramoatividade;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codramo != null ? codramo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ramoatividade)) {
            return false;
        }
        Ramoatividade other = (Ramoatividade) object;
        if ((this.codramo == null && other.codramo != null) || (this.codramo != null && !this.codramo.equals(other.codramo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nerv.cash.core.entity.Ramoatividade[ codramo=" + codramo + " ]";
    }
    
}
