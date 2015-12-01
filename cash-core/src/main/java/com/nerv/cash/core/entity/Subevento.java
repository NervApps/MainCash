/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nerv.cash.core.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
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
@Table(name = "SUBEVENTO")
@NamedQueries({
    @NamedQuery(name = "Subevento.findAll", query = "SELECT s FROM Subevento s"),
    @NamedQuery(name = "Subevento.findByCodempresa", query = "SELECT s FROM Subevento s WHERE s.subeventoPK.codempresa = :codempresa"),
    @NamedQuery(name = "Subevento.findByCodevento", query = "SELECT s FROM Subevento s WHERE s.subeventoPK.codevento = :codevento"),
    @NamedQuery(name = "Subevento.findByCodsubevento", query = "SELECT s FROM Subevento s WHERE s.subeventoPK.codsubevento = :codsubevento"),
    @NamedQuery(name = "Subevento.findByDtvencimento", query = "SELECT s FROM Subevento s WHERE s.dtvencimento = :dtvencimento"),
    @NamedQuery(name = "Subevento.findByCodproduto", query = "SELECT s FROM Subevento s WHERE s.codproduto = :codproduto"),
    @NamedQuery(name = "Subevento.findByValorunitario", query = "SELECT s FROM Subevento s WHERE s.valorunitario = :valorunitario"),
    @NamedQuery(name = "Subevento.findByValorfinal", query = "SELECT s FROM Subevento s WHERE s.valorfinal = :valorfinal"),
    @NamedQuery(name = "Subevento.findByValordesconto", query = "SELECT s FROM Subevento s WHERE s.valordesconto = :valordesconto"),
    @NamedQuery(name = "Subevento.findByCodparcela", query = "SELECT s FROM Subevento s WHERE s.codparcela = :codparcela"),
    @NamedQuery(name = "Subevento.findByCodalerta", query = "SELECT s FROM Subevento s WHERE s.codalerta = :codalerta"),
    @NamedQuery(name = "Subevento.findByDtcriacao", query = "SELECT s FROM Subevento s WHERE s.dtcriacao = :dtcriacao"),
    @NamedQuery(name = "Subevento.findByCodusuariocriacao", query = "SELECT s FROM Subevento s WHERE s.codusuariocriacao = :codusuariocriacao"),
    @NamedQuery(name = "Subevento.findByDtultalteracao", query = "SELECT s FROM Subevento s WHERE s.dtultalteracao = :dtultalteracao"),
    @NamedQuery(name = "Subevento.findByCodusuarioultalteracao", query = "SELECT s FROM Subevento s WHERE s.codusuarioultalteracao = :codusuarioultalteracao")})
public class Subevento implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SubeventoPK subeventoPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DTVENCIMENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtvencimento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODPRODUTO")
    private long codproduto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "VALORUNITARIO")
    private BigDecimal valorunitario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VALORFINAL")
    private BigDecimal valorfinal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VALORDESCONTO")
    private BigDecimal valordesconto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODPARCELA")
    private short codparcela;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODALERTA")
    private long codalerta;
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
    @JoinColumns({
        @JoinColumn(name = "CODEMPRESA", referencedColumnName = "CODEMPRESA", insertable = false, updatable = false),
        @JoinColumn(name = "CODCATEGORIA", referencedColumnName = "CODCATEGORIA")})
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Categorias categorias;
    @JoinColumn(name = "CODEMPRESA", referencedColumnName = "CODEMPRESA", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Empresa empresa;
    @JoinColumns({
        @JoinColumn(name = "CODEMPRESA", referencedColumnName = "CODEMPRESA", insertable = false, updatable = false),
        @JoinColumn(name = "CODEVENTO", referencedColumnName = "CODEVENTO", insertable = false, updatable = false)})
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Eventos eventos;

    public Subevento() {
    }

    public Subevento(SubeventoPK subeventoPK) {
        this.subeventoPK = subeventoPK;
    }

    public Subevento(SubeventoPK subeventoPK, Date dtvencimento, long codproduto, BigDecimal valorunitario, BigDecimal valorfinal, BigDecimal valordesconto, short codparcela, long codalerta, Date dtcriacao, String codusuariocriacao, Date dtultalteracao, String codusuarioultalteracao) {
        this.subeventoPK = subeventoPK;
        this.dtvencimento = dtvencimento;
        this.codproduto = codproduto;
        this.valorunitario = valorunitario;
        this.valorfinal = valorfinal;
        this.valordesconto = valordesconto;
        this.codparcela = codparcela;
        this.codalerta = codalerta;
        this.dtcriacao = dtcriacao;
        this.codusuariocriacao = codusuariocriacao;
        this.dtultalteracao = dtultalteracao;
        this.codusuarioultalteracao = codusuarioultalteracao;
    }

    public Subevento(long codempresa, long codevento, long codsubevento) {
        this.subeventoPK = new SubeventoPK(codempresa, codevento, codsubevento);
    }

    public SubeventoPK getSubeventoPK() {
        return subeventoPK;
    }

    public void setSubeventoPK(SubeventoPK subeventoPK) {
        this.subeventoPK = subeventoPK;
    }

    public Date getDtvencimento() {
        return dtvencimento;
    }

    public void setDtvencimento(Date dtvencimento) {
        this.dtvencimento = dtvencimento;
    }

    public long getCodproduto() {
        return codproduto;
    }

    public void setCodproduto(long codproduto) {
        this.codproduto = codproduto;
    }

    public BigDecimal getValorunitario() {
        return valorunitario;
    }

    public void setValorunitario(BigDecimal valorunitario) {
        this.valorunitario = valorunitario;
    }

    public BigDecimal getValorfinal() {
        return valorfinal;
    }

    public void setValorfinal(BigDecimal valorfinal) {
        this.valorfinal = valorfinal;
    }

    public BigDecimal getValordesconto() {
        return valordesconto;
    }

    public void setValordesconto(BigDecimal valordesconto) {
        this.valordesconto = valordesconto;
    }

    public short getCodparcela() {
        return codparcela;
    }

    public void setCodparcela(short codparcela) {
        this.codparcela = codparcela;
    }

    public long getCodalerta() {
        return codalerta;
    }

    public void setCodalerta(long codalerta) {
        this.codalerta = codalerta;
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

    public Categorias getCategorias() {
        return categorias;
    }

    public void setCategorias(Categorias categorias) {
        this.categorias = categorias;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Eventos getEventos() {
        return eventos;
    }

    public void setEventos(Eventos eventos) {
        this.eventos = eventos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (subeventoPK != null ? subeventoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subevento)) {
            return false;
        }
        Subevento other = (Subevento) object;
        if ((this.subeventoPK == null && other.subeventoPK != null) || (this.subeventoPK != null && !this.subeventoPK.equals(other.subeventoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nerv.cash.core.entity.Subevento[ subeventoPK=" + subeventoPK + " ]";
    }
    
}
