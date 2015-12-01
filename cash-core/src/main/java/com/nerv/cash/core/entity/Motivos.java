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
@Table(name = "MOTIVOS")
@NamedQueries({
    @NamedQuery(name = "Motivos.findAll", query = "SELECT m FROM Motivos m"),
    @NamedQuery(name = "Motivos.findByCodempresa", query = "SELECT m FROM Motivos m WHERE m.motivosPK.codempresa = :codempresa"),
    @NamedQuery(name = "Motivos.findByCodmotivo", query = "SELECT m FROM Motivos m WHERE m.motivosPK.codmotivo = :codmotivo"),
    @NamedQuery(name = "Motivos.findByDescmotivos", query = "SELECT m FROM Motivos m WHERE m.descmotivos = :descmotivos"),
    @NamedQuery(name = "Motivos.findByDtcriacao", query = "SELECT m FROM Motivos m WHERE m.dtcriacao = :dtcriacao"),
    @NamedQuery(name = "Motivos.findByCodusuariocriacao", query = "SELECT m FROM Motivos m WHERE m.codusuariocriacao = :codusuariocriacao"),
    @NamedQuery(name = "Motivos.findByDtultalteracao", query = "SELECT m FROM Motivos m WHERE m.dtultalteracao = :dtultalteracao"),
    @NamedQuery(name = "Motivos.findByCodusuarioultalteracao", query = "SELECT m FROM Motivos m WHERE m.codusuarioultalteracao = :codusuarioultalteracao")})
public class Motivos implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MotivosPK motivosPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "DESCMOTIVOS")
    private String descmotivos;
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

    public Motivos() {
    }

    public Motivos(MotivosPK motivosPK) {
        this.motivosPK = motivosPK;
    }

    public Motivos(MotivosPK motivosPK, String descmotivos, Date dtcriacao, String codusuariocriacao, Date dtultalteracao, String codusuarioultalteracao) {
        this.motivosPK = motivosPK;
        this.descmotivos = descmotivos;
        this.dtcriacao = dtcriacao;
        this.codusuariocriacao = codusuariocriacao;
        this.dtultalteracao = dtultalteracao;
        this.codusuarioultalteracao = codusuarioultalteracao;
    }

    public Motivos(long codempresa, long codmotivo) {
        this.motivosPK = new MotivosPK(codempresa, codmotivo);
    }

    public MotivosPK getMotivosPK() {
        return motivosPK;
    }

    public void setMotivosPK(MotivosPK motivosPK) {
        this.motivosPK = motivosPK;
    }

    public String getDescmotivos() {
        return descmotivos;
    }

    public void setDescmotivos(String descmotivos) {
        this.descmotivos = descmotivos;
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
        hash += (motivosPK != null ? motivosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Motivos)) {
            return false;
        }
        Motivos other = (Motivos) object;
        if ((this.motivosPK == null && other.motivosPK != null) || (this.motivosPK != null && !this.motivosPK.equals(other.motivosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nerv.cash.core.entity.Motivos[ motivosPK=" + motivosPK + " ]";
    }
    
}
