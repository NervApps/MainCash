/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nerv.cash.core.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "EVENTOS")
@NamedQueries({
    @NamedQuery(name = "Eventos.findAll", query = "SELECT e FROM Eventos e"),
    @NamedQuery(name = "Eventos.findByCodempresa", query = "SELECT e FROM Eventos e WHERE e.eventosPK.codempresa = :codempresa"),
    @NamedQuery(name = "Eventos.findByCodevento", query = "SELECT e FROM Eventos e WHERE e.eventosPK.codevento = :codevento"),
    @NamedQuery(name = "Eventos.findByDesceventos", query = "SELECT e FROM Eventos e WHERE e.desceventos = :desceventos"),
    @NamedQuery(name = "Eventos.findByCodcategoria", query = "SELECT e FROM Eventos e WHERE e.codcategoria = :codcategoria"),
    @NamedQuery(name = "Eventos.findByValorBruto", query = "SELECT e FROM Eventos e WHERE e.valorBruto = :valorBruto"),
    @NamedQuery(name = "Eventos.findByValorLiquido", query = "SELECT e FROM Eventos e WHERE e.valorLiquido = :valorLiquido"),
    @NamedQuery(name = "Eventos.findByDtevento", query = "SELECT e FROM Eventos e WHERE e.dtevento = :dtevento"),
    @NamedQuery(name = "Eventos.findByDtvencimento", query = "SELECT e FROM Eventos e WHERE e.dtvencimento = :dtvencimento"),
    @NamedQuery(name = "Eventos.findByNumnotafiscal", query = "SELECT e FROM Eventos e WHERE e.numnotafiscal = :numnotafiscal"),
    @NamedQuery(name = "Eventos.findByNumdocumento", query = "SELECT e FROM Eventos e WHERE e.numdocumento = :numdocumento"),
    @NamedQuery(name = "Eventos.findByCodimposto", query = "SELECT e FROM Eventos e WHERE e.codimposto = :codimposto"),
    @NamedQuery(name = "Eventos.findByQtparcelas", query = "SELECT e FROM Eventos e WHERE e.qtparcelas = :qtparcelas"),
    @NamedQuery(name = "Eventos.findByCodcliente", query = "SELECT e FROM Eventos e WHERE e.codcliente = :codcliente"),
    @NamedQuery(name = "Eventos.findByCodconta", query = "SELECT e FROM Eventos e WHERE e.codconta = :codconta"),
    @NamedQuery(name = "Eventos.findByDtcriacao", query = "SELECT e FROM Eventos e WHERE e.dtcriacao = :dtcriacao"),
    @NamedQuery(name = "Eventos.findByCodusuariocriacao", query = "SELECT e FROM Eventos e WHERE e.codusuariocriacao = :codusuariocriacao"),
    @NamedQuery(name = "Eventos.findByDtultalteracao", query = "SELECT e FROM Eventos e WHERE e.dtultalteracao = :dtultalteracao"),
    @NamedQuery(name = "Eventos.findByCodusuarioultalteracao", query = "SELECT e FROM Eventos e WHERE e.codusuarioultalteracao = :codusuarioultalteracao")})
public class Eventos implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EventosPK eventosPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "DESCEVENTOS")
    private String desceventos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODCATEGORIA")
    private long codcategoria;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "VALOR_BRUTO")
    private BigDecimal valorBruto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VALOR_LIQUIDO")
    private BigDecimal valorLiquido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DTEVENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtevento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DTVENCIMENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtvencimento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUMNOTAFISCAL")
    private long numnotafiscal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUMDOCUMENTO")
    private long numdocumento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIMPOSTO")
    private long codimposto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "QTPARCELAS")
    private short qtparcelas;
    @Column(name = "CODCLIENTE")
    private Long codcliente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODCONTA")
    private long codconta;
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
    @JoinColumn(name = "CODTIPOFINANCEIRO", referencedColumnName = "CODTIPOFINANCEIRO")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Tipofinanceiro codtipofinanceiro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eventos", fetch = FetchType.LAZY)
    private Collection<Subevento> subeventoCollection;

    public Eventos() {
    }

    public Eventos(EventosPK eventosPK) {
        this.eventosPK = eventosPK;
    }

    public Eventos(EventosPK eventosPK, String desceventos, long codcategoria, BigDecimal valorBruto, BigDecimal valorLiquido, Date dtevento, Date dtvencimento, long numnotafiscal, long numdocumento, long codimposto, short qtparcelas, long codconta, Date dtcriacao, String codusuariocriacao, Date dtultalteracao, String codusuarioultalteracao) {
        this.eventosPK = eventosPK;
        this.desceventos = desceventos;
        this.codcategoria = codcategoria;
        this.valorBruto = valorBruto;
        this.valorLiquido = valorLiquido;
        this.dtevento = dtevento;
        this.dtvencimento = dtvencimento;
        this.numnotafiscal = numnotafiscal;
        this.numdocumento = numdocumento;
        this.codimposto = codimposto;
        this.qtparcelas = qtparcelas;
        this.codconta = codconta;
        this.dtcriacao = dtcriacao;
        this.codusuariocriacao = codusuariocriacao;
        this.dtultalteracao = dtultalteracao;
        this.codusuarioultalteracao = codusuarioultalteracao;
    }

    public Eventos(long codempresa, long codevento) {
        this.eventosPK = new EventosPK(codempresa, codevento);
    }

    public EventosPK getEventosPK() {
        return eventosPK;
    }

    public void setEventosPK(EventosPK eventosPK) {
        this.eventosPK = eventosPK;
    }

    public String getDesceventos() {
        return desceventos;
    }

    public void setDesceventos(String desceventos) {
        this.desceventos = desceventos;
    }

    public long getCodcategoria() {
        return codcategoria;
    }

    public void setCodcategoria(long codcategoria) {
        this.codcategoria = codcategoria;
    }

    public BigDecimal getValorBruto() {
        return valorBruto;
    }

    public void setValorBruto(BigDecimal valorBruto) {
        this.valorBruto = valorBruto;
    }

    public BigDecimal getValorLiquido() {
        return valorLiquido;
    }

    public void setValorLiquido(BigDecimal valorLiquido) {
        this.valorLiquido = valorLiquido;
    }

    public Date getDtevento() {
        return dtevento;
    }

    public void setDtevento(Date dtevento) {
        this.dtevento = dtevento;
    }

    public Date getDtvencimento() {
        return dtvencimento;
    }

    public void setDtvencimento(Date dtvencimento) {
        this.dtvencimento = dtvencimento;
    }

    public long getNumnotafiscal() {
        return numnotafiscal;
    }

    public void setNumnotafiscal(long numnotafiscal) {
        this.numnotafiscal = numnotafiscal;
    }

    public long getNumdocumento() {
        return numdocumento;
    }

    public void setNumdocumento(long numdocumento) {
        this.numdocumento = numdocumento;
    }

    public long getCodimposto() {
        return codimposto;
    }

    public void setCodimposto(long codimposto) {
        this.codimposto = codimposto;
    }

    public short getQtparcelas() {
        return qtparcelas;
    }

    public void setQtparcelas(short qtparcelas) {
        this.qtparcelas = qtparcelas;
    }

    public Long getCodcliente() {
        return codcliente;
    }

    public void setCodcliente(Long codcliente) {
        this.codcliente = codcliente;
    }

    public long getCodconta() {
        return codconta;
    }

    public void setCodconta(long codconta) {
        this.codconta = codconta;
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

    public Tipofinanceiro getCodtipofinanceiro() {
        return codtipofinanceiro;
    }

    public void setCodtipofinanceiro(Tipofinanceiro codtipofinanceiro) {
        this.codtipofinanceiro = codtipofinanceiro;
    }

    public Collection<Subevento> getSubeventoCollection() {
        return subeventoCollection;
    }

    public void setSubeventoCollection(Collection<Subevento> subeventoCollection) {
        this.subeventoCollection = subeventoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eventosPK != null ? eventosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Eventos)) {
            return false;
        }
        Eventos other = (Eventos) object;
        if ((this.eventosPK == null && other.eventosPK != null) || (this.eventosPK != null && !this.eventosPK.equals(other.eventosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nerv.cash.core.entity.Eventos[ eventosPK=" + eventosPK + " ]";
    }
    
}
