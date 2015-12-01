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
@Table(name = "TELAS")
@NamedQueries({
    @NamedQuery(name = "Telas.findAll", query = "SELECT t FROM Telas t"),
    @NamedQuery(name = "Telas.findByCodempresa", query = "SELECT t FROM Telas t WHERE t.telasPK.codempresa = :codempresa"),
    @NamedQuery(name = "Telas.findByCodtela", query = "SELECT t FROM Telas t WHERE t.telasPK.codtela = :codtela"),
    @NamedQuery(name = "Telas.findByDesctelas", query = "SELECT t FROM Telas t WHERE t.desctelas = :desctelas"),
    @NamedQuery(name = "Telas.findByDtcriacao", query = "SELECT t FROM Telas t WHERE t.dtcriacao = :dtcriacao"),
    @NamedQuery(name = "Telas.findByCodusuariocriacao", query = "SELECT t FROM Telas t WHERE t.codusuariocriacao = :codusuariocriacao"),
    @NamedQuery(name = "Telas.findByDtultalteracao", query = "SELECT t FROM Telas t WHERE t.dtultalteracao = :dtultalteracao"),
    @NamedQuery(name = "Telas.findByCodusuarioultalteracao", query = "SELECT t FROM Telas t WHERE t.codusuarioultalteracao = :codusuarioultalteracao")})
public class Telas implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TelasPK telasPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "DESCTELAS")
    private String desctelas;
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

    public Telas() {
    }

    public Telas(TelasPK telasPK) {
        this.telasPK = telasPK;
    }

    public Telas(TelasPK telasPK, String desctelas, Date dtcriacao, String codusuariocriacao, Date dtultalteracao, String codusuarioultalteracao) {
        this.telasPK = telasPK;
        this.desctelas = desctelas;
        this.dtcriacao = dtcriacao;
        this.codusuariocriacao = codusuariocriacao;
        this.dtultalteracao = dtultalteracao;
        this.codusuarioultalteracao = codusuarioultalteracao;
    }

    public Telas(long codempresa, long codtela) {
        this.telasPK = new TelasPK(codempresa, codtela);
    }

    public TelasPK getTelasPK() {
        return telasPK;
    }

    public void setTelasPK(TelasPK telasPK) {
        this.telasPK = telasPK;
    }

    public String getDesctelas() {
        return desctelas;
    }

    public void setDesctelas(String desctelas) {
        this.desctelas = desctelas;
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
        hash += (telasPK != null ? telasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Telas)) {
            return false;
        }
        Telas other = (Telas) object;
        if ((this.telasPK == null && other.telasPK != null) || (this.telasPK != null && !this.telasPK.equals(other.telasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nerv.cash.core.entity.Telas[ telasPK=" + telasPK + " ]";
    }
    
}
