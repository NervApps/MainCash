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
@Table(name = "CONTAS")
@NamedQueries({
    @NamedQuery(name = "Contas.findAll", query = "SELECT c FROM Contas c"),
    @NamedQuery(name = "Contas.findByCodempresa", query = "SELECT c FROM Contas c WHERE c.contasPK.codempresa = :codempresa"),
    @NamedQuery(name = "Contas.findByCodbanco", query = "SELECT c FROM Contas c WHERE c.contasPK.codbanco = :codbanco"),
    @NamedQuery(name = "Contas.findByCodagencia", query = "SELECT c FROM Contas c WHERE c.codagencia = :codagencia"),
    @NamedQuery(name = "Contas.findByCodconta", query = "SELECT c FROM Contas c WHERE c.contasPK.codconta = :codconta"),
    @NamedQuery(name = "Contas.findByDesccontas", query = "SELECT c FROM Contas c WHERE c.desccontas = :desccontas"),
    @NamedQuery(name = "Contas.findByDtcriacao", query = "SELECT c FROM Contas c WHERE c.dtcriacao = :dtcriacao"),
    @NamedQuery(name = "Contas.findByPadrao", query = "SELECT c FROM Contas c WHERE c.padrao = :padrao"),
    @NamedQuery(name = "Contas.findByCodusuariocriacao", query = "SELECT c FROM Contas c WHERE c.codusuariocriacao = :codusuariocriacao"),
    @NamedQuery(name = "Contas.findByDtultalteracao", query = "SELECT c FROM Contas c WHERE c.dtultalteracao = :dtultalteracao"),
    @NamedQuery(name = "Contas.findByCodusuarioultalteracao", query = "SELECT c FROM Contas c WHERE c.codusuarioultalteracao = :codusuarioultalteracao")})
public class Contas implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ContasPK contasPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODAGENCIA")
    private long codagencia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "DESCCONTAS")
    private String desccontas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DTCRIACAO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtcriacao;
    @Size(max = 1)
    @Column(name = "PADRAO")
    private String padrao;
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
    @JoinColumn(name = "CODBANCO", referencedColumnName = "CODBANCO", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Bancos bancos;
    @JoinColumn(name = "CODEMPRESA", referencedColumnName = "CODEMPRESA", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Empresa empresa;

    public Contas() {
    }

    public Contas(ContasPK contasPK) {
        this.contasPK = contasPK;
    }

    public Contas(ContasPK contasPK, long codagencia, String desccontas, Date dtcriacao, String codusuariocriacao, Date dtultalteracao, String codusuarioultalteracao) {
        this.contasPK = contasPK;
        this.codagencia = codagencia;
        this.desccontas = desccontas;
        this.dtcriacao = dtcriacao;
        this.codusuariocriacao = codusuariocriacao;
        this.dtultalteracao = dtultalteracao;
        this.codusuarioultalteracao = codusuarioultalteracao;
    }

    public Contas(long codempresa, long codbanco, long codconta) {
        this.contasPK = new ContasPK(codempresa, codbanco, codconta);
    }

    public ContasPK getContasPK() {
        return contasPK;
    }

    public void setContasPK(ContasPK contasPK) {
        this.contasPK = contasPK;
    }

    public long getCodagencia() {
        return codagencia;
    }

    public void setCodagencia(long codagencia) {
        this.codagencia = codagencia;
    }

    public String getDesccontas() {
        return desccontas;
    }

    public void setDesccontas(String desccontas) {
        this.desccontas = desccontas;
    }

    public Date getDtcriacao() {
        return dtcriacao;
    }

    public void setDtcriacao(Date dtcriacao) {
        this.dtcriacao = dtcriacao;
    }

    public String getPadrao() {
        return padrao;
    }

    public void setPadrao(String padrao) {
        this.padrao = padrao;
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

    public Bancos getBancos() {
        return bancos;
    }

    public void setBancos(Bancos bancos) {
        this.bancos = bancos;
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
        hash += (contasPK != null ? contasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contas)) {
            return false;
        }
        Contas other = (Contas) object;
        if ((this.contasPK == null && other.contasPK != null) || (this.contasPK != null && !this.contasPK.equals(other.contasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nerv.cash.core.entity.Contas[ contasPK=" + contasPK + " ]";
    }
    
}
