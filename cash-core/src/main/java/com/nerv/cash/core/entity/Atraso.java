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
@Table(name = "ATRASO")
@NamedQueries({
    @NamedQuery(name = "Atraso.findAll", query = "SELECT a FROM Atraso a"),
    @NamedQuery(name = "Atraso.findByCodempresa", query = "SELECT a FROM Atraso a WHERE a.atrasoPK.codempresa = :codempresa"),
    @NamedQuery(name = "Atraso.findByCodatraso", query = "SELECT a FROM Atraso a WHERE a.atrasoPK.codatraso = :codatraso"),
    @NamedQuery(name = "Atraso.findByCodmotivo", query = "SELECT a FROM Atraso a WHERE a.codmotivo = :codmotivo"),
    @NamedQuery(name = "Atraso.findByDtestimada", query = "SELECT a FROM Atraso a WHERE a.dtestimada = :dtestimada"),
    @NamedQuery(name = "Atraso.findByCodcliente", query = "SELECT a FROM Atraso a WHERE a.codcliente = :codcliente"),
    @NamedQuery(name = "Atraso.findByCodcontaestimado", query = "SELECT a FROM Atraso a WHERE a.codcontaestimado = :codcontaestimado"),
    @NamedQuery(name = "Atraso.findByCodproduto", query = "SELECT a FROM Atraso a WHERE a.codproduto = :codproduto"),
    @NamedQuery(name = "Atraso.findByDescatraso", query = "SELECT a FROM Atraso a WHERE a.descatraso = :descatraso"),
    @NamedQuery(name = "Atraso.findByValorprometido", query = "SELECT a FROM Atraso a WHERE a.valorprometido = :valorprometido"),
    @NamedQuery(name = "Atraso.findByDtprometida", query = "SELECT a FROM Atraso a WHERE a.dtprometida = :dtprometida"),
    @NamedQuery(name = "Atraso.findByCodbancoprometido", query = "SELECT a FROM Atraso a WHERE a.codbancoprometido = :codbancoprometido"),
    @NamedQuery(name = "Atraso.findByCodcontaprometido", query = "SELECT a FROM Atraso a WHERE a.codcontaprometido = :codcontaprometido"),
    @NamedQuery(name = "Atraso.findByDtcriacao", query = "SELECT a FROM Atraso a WHERE a.dtcriacao = :dtcriacao"),
    @NamedQuery(name = "Atraso.findByCodusuariocriacao", query = "SELECT a FROM Atraso a WHERE a.codusuariocriacao = :codusuariocriacao"),
    @NamedQuery(name = "Atraso.findByDtultalteracao", query = "SELECT a FROM Atraso a WHERE a.dtultalteracao = :dtultalteracao"),
    @NamedQuery(name = "Atraso.findByCodusuarioultalteracao", query = "SELECT a FROM Atraso a WHERE a.codusuarioultalteracao = :codusuarioultalteracao")})
public class Atraso implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AtrasoPK atrasoPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODMOTIVO")
    private long codmotivo;
    @Column(name = "DTESTIMADA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtestimada;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODCLIENTE")
    private long codcliente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODCONTAESTIMADO")
    private long codcontaestimado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODPRODUTO")
    private long codproduto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "DESCATRASO")
    private String descatraso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VALORPROMETIDO")
    private long valorprometido;
    @Column(name = "DTPROMETIDA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtprometida;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODBANCOPROMETIDO")
    private long codbancoprometido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODCONTAPROMETIDO")
    private long codcontaprometido;
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

    public Atraso() {
    }

    public Atraso(AtrasoPK atrasoPK) {
        this.atrasoPK = atrasoPK;
    }

    public Atraso(AtrasoPK atrasoPK, long codmotivo, long codcliente, long codcontaestimado, long codproduto, String descatraso, long valorprometido, long codbancoprometido, long codcontaprometido, Date dtcriacao, String codusuariocriacao, Date dtultalteracao, String codusuarioultalteracao) {
        this.atrasoPK = atrasoPK;
        this.codmotivo = codmotivo;
        this.codcliente = codcliente;
        this.codcontaestimado = codcontaestimado;
        this.codproduto = codproduto;
        this.descatraso = descatraso;
        this.valorprometido = valorprometido;
        this.codbancoprometido = codbancoprometido;
        this.codcontaprometido = codcontaprometido;
        this.dtcriacao = dtcriacao;
        this.codusuariocriacao = codusuariocriacao;
        this.dtultalteracao = dtultalteracao;
        this.codusuarioultalteracao = codusuarioultalteracao;
    }

    public Atraso(long codempresa, long codatraso) {
        this.atrasoPK = new AtrasoPK(codempresa, codatraso);
    }

    public AtrasoPK getAtrasoPK() {
        return atrasoPK;
    }

    public void setAtrasoPK(AtrasoPK atrasoPK) {
        this.atrasoPK = atrasoPK;
    }

    public long getCodmotivo() {
        return codmotivo;
    }

    public void setCodmotivo(long codmotivo) {
        this.codmotivo = codmotivo;
    }

    public Date getDtestimada() {
        return dtestimada;
    }

    public void setDtestimada(Date dtestimada) {
        this.dtestimada = dtestimada;
    }

    public long getCodcliente() {
        return codcliente;
    }

    public void setCodcliente(long codcliente) {
        this.codcliente = codcliente;
    }

    public long getCodcontaestimado() {
        return codcontaestimado;
    }

    public void setCodcontaestimado(long codcontaestimado) {
        this.codcontaestimado = codcontaestimado;
    }

    public long getCodproduto() {
        return codproduto;
    }

    public void setCodproduto(long codproduto) {
        this.codproduto = codproduto;
    }

    public String getDescatraso() {
        return descatraso;
    }

    public void setDescatraso(String descatraso) {
        this.descatraso = descatraso;
    }

    public long getValorprometido() {
        return valorprometido;
    }

    public void setValorprometido(long valorprometido) {
        this.valorprometido = valorprometido;
    }

    public Date getDtprometida() {
        return dtprometida;
    }

    public void setDtprometida(Date dtprometida) {
        this.dtprometida = dtprometida;
    }

    public long getCodbancoprometido() {
        return codbancoprometido;
    }

    public void setCodbancoprometido(long codbancoprometido) {
        this.codbancoprometido = codbancoprometido;
    }

    public long getCodcontaprometido() {
        return codcontaprometido;
    }

    public void setCodcontaprometido(long codcontaprometido) {
        this.codcontaprometido = codcontaprometido;
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
        hash += (atrasoPK != null ? atrasoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Atraso)) {
            return false;
        }
        Atraso other = (Atraso) object;
        if ((this.atrasoPK == null && other.atrasoPK != null) || (this.atrasoPK != null && !this.atrasoPK.equals(other.atrasoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nerv.cash.core.entity.Atraso[ atrasoPK=" + atrasoPK + " ]";
    }
    
}
