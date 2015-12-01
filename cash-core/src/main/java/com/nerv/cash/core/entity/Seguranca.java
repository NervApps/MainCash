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
@Table(name = "SEGURANCA")
@NamedQueries({
    @NamedQuery(name = "Seguranca.findAll", query = "SELECT s FROM Seguranca s"),
    @NamedQuery(name = "Seguranca.findByCodempresa", query = "SELECT s FROM Seguranca s WHERE s.segurancaPK.codempresa = :codempresa"),
    @NamedQuery(name = "Seguranca.findByCodseguranca", query = "SELECT s FROM Seguranca s WHERE s.segurancaPK.codseguranca = :codseguranca"),
    @NamedQuery(name = "Seguranca.findByDescseguranca", query = "SELECT s FROM Seguranca s WHERE s.descseguranca = :descseguranca"),
    @NamedQuery(name = "Seguranca.findByCodtela", query = "SELECT s FROM Seguranca s WHERE s.codtela = :codtela"),
    @NamedQuery(name = "Seguranca.findByCodusuario", query = "SELECT s FROM Seguranca s WHERE s.codusuario = :codusuario"),
    @NamedQuery(name = "Seguranca.findByInsere", query = "SELECT s FROM Seguranca s WHERE s.insere = :insere"),
    @NamedQuery(name = "Seguranca.findByAltera", query = "SELECT s FROM Seguranca s WHERE s.altera = :altera"),
    @NamedQuery(name = "Seguranca.findByConsulta", query = "SELECT s FROM Seguranca s WHERE s.consulta = :consulta"),
    @NamedQuery(name = "Seguranca.findByExclusao", query = "SELECT s FROM Seguranca s WHERE s.exclusao = :exclusao"),
    @NamedQuery(name = "Seguranca.findByRelatorios", query = "SELECT s FROM Seguranca s WHERE s.relatorios = :relatorios"),
    @NamedQuery(name = "Seguranca.findByDtcriacao", query = "SELECT s FROM Seguranca s WHERE s.dtcriacao = :dtcriacao"),
    @NamedQuery(name = "Seguranca.findByCodusuariocriacao", query = "SELECT s FROM Seguranca s WHERE s.codusuariocriacao = :codusuariocriacao"),
    @NamedQuery(name = "Seguranca.findByDtultalteracao", query = "SELECT s FROM Seguranca s WHERE s.dtultalteracao = :dtultalteracao"),
    @NamedQuery(name = "Seguranca.findByCodusuarioultalteracao", query = "SELECT s FROM Seguranca s WHERE s.codusuarioultalteracao = :codusuarioultalteracao")})
public class Seguranca implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SegurancaPK segurancaPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "DESCSEGURANCA")
    private String descseguranca;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODTELA")
    private long codtela;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODUSUARIO")
    private long codusuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "INSERE")
    private String insere;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "ALTERA")
    private String altera;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "CONSULTA")
    private String consulta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "EXCLUSAO")
    private String exclusao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "RELATORIOS")
    private String relatorios;
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

    public Seguranca() {
    }

    public Seguranca(SegurancaPK segurancaPK) {
        this.segurancaPK = segurancaPK;
    }

    public Seguranca(SegurancaPK segurancaPK, String descseguranca, long codtela, long codusuario, String insere, String altera, String consulta, String exclusao, String relatorios, Date dtcriacao, String codusuariocriacao, Date dtultalteracao, String codusuarioultalteracao) {
        this.segurancaPK = segurancaPK;
        this.descseguranca = descseguranca;
        this.codtela = codtela;
        this.codusuario = codusuario;
        this.insere = insere;
        this.altera = altera;
        this.consulta = consulta;
        this.exclusao = exclusao;
        this.relatorios = relatorios;
        this.dtcriacao = dtcriacao;
        this.codusuariocriacao = codusuariocriacao;
        this.dtultalteracao = dtultalteracao;
        this.codusuarioultalteracao = codusuarioultalteracao;
    }

    public Seguranca(long codempresa, long codseguranca) {
        this.segurancaPK = new SegurancaPK(codempresa, codseguranca);
    }

    public SegurancaPK getSegurancaPK() {
        return segurancaPK;
    }

    public void setSegurancaPK(SegurancaPK segurancaPK) {
        this.segurancaPK = segurancaPK;
    }

    public String getDescseguranca() {
        return descseguranca;
    }

    public void setDescseguranca(String descseguranca) {
        this.descseguranca = descseguranca;
    }

    public long getCodtela() {
        return codtela;
    }

    public void setCodtela(long codtela) {
        this.codtela = codtela;
    }

    public long getCodusuario() {
        return codusuario;
    }

    public void setCodusuario(long codusuario) {
        this.codusuario = codusuario;
    }

    public String getInsere() {
        return insere;
    }

    public void setInsere(String insere) {
        this.insere = insere;
    }

    public String getAltera() {
        return altera;
    }

    public void setAltera(String altera) {
        this.altera = altera;
    }

    public String getConsulta() {
        return consulta;
    }

    public void setConsulta(String consulta) {
        this.consulta = consulta;
    }

    public String getExclusao() {
        return exclusao;
    }

    public void setExclusao(String exclusao) {
        this.exclusao = exclusao;
    }

    public String getRelatorios() {
        return relatorios;
    }

    public void setRelatorios(String relatorios) {
        this.relatorios = relatorios;
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
        hash += (segurancaPK != null ? segurancaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Seguranca)) {
            return false;
        }
        Seguranca other = (Seguranca) object;
        if ((this.segurancaPK == null && other.segurancaPK != null) || (this.segurancaPK != null && !this.segurancaPK.equals(other.segurancaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nerv.cash.core.entity.Seguranca[ segurancaPK=" + segurancaPK + " ]";
    }
    
}
