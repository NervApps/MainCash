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
@Table(name = "IMPOSTOS")
@NamedQueries({
    @NamedQuery(name = "Impostos.findAll", query = "SELECT i FROM Impostos i"),
    @NamedQuery(name = "Impostos.findByCodempresa", query = "SELECT i FROM Impostos i WHERE i.impostosPK.codempresa = :codempresa"),
    @NamedQuery(name = "Impostos.findByCodimposto", query = "SELECT i FROM Impostos i WHERE i.impostosPK.codimposto = :codimposto"),
    @NamedQuery(name = "Impostos.findByCodmunicipio", query = "SELECT i FROM Impostos i WHERE i.codmunicipio = :codmunicipio"),
    @NamedQuery(name = "Impostos.findByDescimposto", query = "SELECT i FROM Impostos i WHERE i.descimposto = :descimposto"),
    @NamedQuery(name = "Impostos.findByAliquota", query = "SELECT i FROM Impostos i WHERE i.aliquota = :aliquota"),
    @NamedQuery(name = "Impostos.findByDiavencimento", query = "SELECT i FROM Impostos i WHERE i.diavencimento = :diavencimento"),
    @NamedQuery(name = "Impostos.findByCodrecorrencia", query = "SELECT i FROM Impostos i WHERE i.codrecorrencia = :codrecorrencia"),
    @NamedQuery(name = "Impostos.findByCodalerta", query = "SELECT i FROM Impostos i WHERE i.codalerta = :codalerta"),
    @NamedQuery(name = "Impostos.findByPercdesconto", query = "SELECT i FROM Impostos i WHERE i.percdesconto = :percdesconto"),
    @NamedQuery(name = "Impostos.findByStatus", query = "SELECT i FROM Impostos i WHERE i.status = :status"),
    @NamedQuery(name = "Impostos.findByDtvigenciainicial", query = "SELECT i FROM Impostos i WHERE i.dtvigenciainicial = :dtvigenciainicial"),
    @NamedQuery(name = "Impostos.findByDtvigenciafinal", query = "SELECT i FROM Impostos i WHERE i.dtvigenciafinal = :dtvigenciafinal"),
    @NamedQuery(name = "Impostos.findByDtcriacao", query = "SELECT i FROM Impostos i WHERE i.dtcriacao = :dtcriacao"),
    @NamedQuery(name = "Impostos.findByCodusuariocriacao", query = "SELECT i FROM Impostos i WHERE i.codusuariocriacao = :codusuariocriacao"),
    @NamedQuery(name = "Impostos.findByDtultalteracao", query = "SELECT i FROM Impostos i WHERE i.dtultalteracao = :dtultalteracao"),
    @NamedQuery(name = "Impostos.findByCodusuarioultalteracao", query = "SELECT i FROM Impostos i WHERE i.codusuarioultalteracao = :codusuarioultalteracao")})
public class Impostos implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ImpostosPK impostosPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODMUNICIPIO")
    private long codmunicipio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "DESCIMPOSTO")
    private String descimposto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "ALIQUOTA")
    private BigDecimal aliquota;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DIAVENCIMENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date diavencimento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODRECORRENCIA")
    private long codrecorrencia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODALERTA")
    private long codalerta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PERCDESCONTO")
    private BigDecimal percdesconto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "STATUS")
    private String status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DTVIGENCIAINICIAL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtvigenciainicial;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DTVIGENCIAFINAL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtvigenciafinal;
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

    public Impostos() {
    }

    public Impostos(ImpostosPK impostosPK) {
        this.impostosPK = impostosPK;
    }

    public Impostos(ImpostosPK impostosPK, long codmunicipio, String descimposto, BigDecimal aliquota, Date diavencimento, long codrecorrencia, long codalerta, BigDecimal percdesconto, String status, Date dtvigenciainicial, Date dtvigenciafinal, Date dtcriacao, String codusuariocriacao, Date dtultalteracao, String codusuarioultalteracao) {
        this.impostosPK = impostosPK;
        this.codmunicipio = codmunicipio;
        this.descimposto = descimposto;
        this.aliquota = aliquota;
        this.diavencimento = diavencimento;
        this.codrecorrencia = codrecorrencia;
        this.codalerta = codalerta;
        this.percdesconto = percdesconto;
        this.status = status;
        this.dtvigenciainicial = dtvigenciainicial;
        this.dtvigenciafinal = dtvigenciafinal;
        this.dtcriacao = dtcriacao;
        this.codusuariocriacao = codusuariocriacao;
        this.dtultalteracao = dtultalteracao;
        this.codusuarioultalteracao = codusuarioultalteracao;
    }

    public Impostos(long codempresa, long codimposto) {
        this.impostosPK = new ImpostosPK(codempresa, codimposto);
    }

    public ImpostosPK getImpostosPK() {
        return impostosPK;
    }

    public void setImpostosPK(ImpostosPK impostosPK) {
        this.impostosPK = impostosPK;
    }

    public long getCodmunicipio() {
        return codmunicipio;
    }

    public void setCodmunicipio(long codmunicipio) {
        this.codmunicipio = codmunicipio;
    }

    public String getDescimposto() {
        return descimposto;
    }

    public void setDescimposto(String descimposto) {
        this.descimposto = descimposto;
    }

    public BigDecimal getAliquota() {
        return aliquota;
    }

    public void setAliquota(BigDecimal aliquota) {
        this.aliquota = aliquota;
    }

    public Date getDiavencimento() {
        return diavencimento;
    }

    public void setDiavencimento(Date diavencimento) {
        this.diavencimento = diavencimento;
    }

    public long getCodrecorrencia() {
        return codrecorrencia;
    }

    public void setCodrecorrencia(long codrecorrencia) {
        this.codrecorrencia = codrecorrencia;
    }

    public long getCodalerta() {
        return codalerta;
    }

    public void setCodalerta(long codalerta) {
        this.codalerta = codalerta;
    }

    public BigDecimal getPercdesconto() {
        return percdesconto;
    }

    public void setPercdesconto(BigDecimal percdesconto) {
        this.percdesconto = percdesconto;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDtvigenciainicial() {
        return dtvigenciainicial;
    }

    public void setDtvigenciainicial(Date dtvigenciainicial) {
        this.dtvigenciainicial = dtvigenciainicial;
    }

    public Date getDtvigenciafinal() {
        return dtvigenciafinal;
    }

    public void setDtvigenciafinal(Date dtvigenciafinal) {
        this.dtvigenciafinal = dtvigenciafinal;
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
        hash += (impostosPK != null ? impostosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Impostos)) {
            return false;
        }
        Impostos other = (Impostos) object;
        if ((this.impostosPK == null && other.impostosPK != null) || (this.impostosPK != null && !this.impostosPK.equals(other.impostosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nerv.cash.core.entity.Impostos[ impostosPK=" + impostosPK + " ]";
    }
    
}
