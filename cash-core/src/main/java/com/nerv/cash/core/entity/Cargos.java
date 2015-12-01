/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nerv.cash.core.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Philipe
 */
@Entity
@Table(name = "CARGOS")
@NamedQueries({
    @NamedQuery(name = "Cargos.findAll", query = "SELECT c FROM Cargos c"),
    @NamedQuery(name = "Cargos.findByCodempresa", query = "SELECT c FROM Cargos c WHERE c.cargosPK.codempresa = :codempresa"),
    @NamedQuery(name = "Cargos.findByCodcargo", query = "SELECT c FROM Cargos c WHERE c.cargosPK.codcargo = :codcargo"),
    @NamedQuery(name = "Cargos.findByDesccargos", query = "SELECT c FROM Cargos c WHERE c.desccargos = :desccargos"),
    @NamedQuery(name = "Cargos.findByDtcriacao", query = "SELECT c FROM Cargos c WHERE c.dtcriacao = :dtcriacao"),
    @NamedQuery(name = "Cargos.findByCodusuariocriacao", query = "SELECT c FROM Cargos c WHERE c.codusuariocriacao = :codusuariocriacao"),
    @NamedQuery(name = "Cargos.findByDtultalteracao", query = "SELECT c FROM Cargos c WHERE c.dtultalteracao = :dtultalteracao"),
    @NamedQuery(name = "Cargos.findByCodusuarioultalteracao", query = "SELECT c FROM Cargos c WHERE c.codusuarioultalteracao = :codusuarioultalteracao")})
public class Cargos implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CargosPK cargosPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "DESCCARGOS")
    private String desccargos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DTCRIACAO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtcriacao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CODUSUARIOCRIACAO")
    private String codusuariocriacao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DTULTALTERACAO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtultalteracao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CODUSUARIOULTALTERACAO")
    private String codusuarioultalteracao;
    @JoinColumn(name = "CODEMPRESA", referencedColumnName = "CODEMPRESA", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Empresa empresa;

    public Cargos() {
    }

    public Cargos(CargosPK cargosPK) {
        this.cargosPK = cargosPK;
    }

    public Cargos(CargosPK cargosPK, String desccargos, Date dtcriacao, String codusuariocriacao, Date dtultalteracao, String codusuarioultalteracao) {
        this.cargosPK = cargosPK;
        this.desccargos = desccargos;
        this.dtcriacao = dtcriacao;
        this.codusuariocriacao = codusuariocriacao;
        this.dtultalteracao = dtultalteracao;
        this.codusuarioultalteracao = codusuarioultalteracao;
    }

    public Cargos(long codempresa, long codcargo) {
        this.cargosPK = new CargosPK(codempresa, codcargo);
    }

    public CargosPK getCargosPK() {
        return cargosPK;
    }

    public void setCargosPK(CargosPK cargosPK) {
        this.cargosPK = cargosPK;
    }

    public String getDesccargos() {
        return desccargos;
    }

    public void setDesccargos(String desccargos) {
        this.desccargos = desccargos;
    }

    public Date getDtcriacao() {
        return dtcriacao;
    }

    public void setDtcriacao(Date dtcriacao) {
        this.dtcriacao = dtcriacao;
    }

    public String getCodusuariocriacao() {
        return codusuariocriacao;
    }

    public void setCodusuariocriacao(String codusuariocriacao) {
        this.codusuariocriacao = codusuariocriacao;
    }

    public Date getDtultalteracao() {
        return dtultalteracao;
    }

    public void setDtultalteracao(Date dtultalteracao) {
        this.dtultalteracao = dtultalteracao;
    }

    public String getCodusuarioultalteracao() {
        return codusuarioultalteracao;
    }

    public void setCodusuarioultalteracao(String codusuarioultalteracao) {
        this.codusuarioultalteracao = codusuarioultalteracao;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cargosPK != null ? cargosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cargos)) {
            return false;
        }
        Cargos other = (Cargos) object;
        if ((this.cargosPK == null && other.cargosPK != null) || (this.cargosPK != null && !this.cargosPK.equals(other.cargosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nerv.cash.core.entity.Cargos[ cargosPK=" + cargosPK + " ]";
    }
    
}
