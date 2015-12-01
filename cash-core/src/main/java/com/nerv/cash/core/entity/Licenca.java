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
@Table(name = "LICENCA")
@NamedQueries({
    @NamedQuery(name = "Licenca.findAll", query = "SELECT l FROM Licenca l"),
    @NamedQuery(name = "Licenca.findByCodempresa", query = "SELECT l FROM Licenca l WHERE l.licencaPK.codempresa = :codempresa"),
    @NamedQuery(name = "Licenca.findByCodlicenca", query = "SELECT l FROM Licenca l WHERE l.licencaPK.codlicenca = :codlicenca"),
    @NamedQuery(name = "Licenca.findByCodproduto", query = "SELECT l FROM Licenca l WHERE l.licencaPK.codproduto = :codproduto"),
    @NamedQuery(name = "Licenca.findByDesclicenca", query = "SELECT l FROM Licenca l WHERE l.desclicenca = :desclicenca"),
    @NamedQuery(name = "Licenca.findByDtvigenciainicial", query = "SELECT l FROM Licenca l WHERE l.dtvigenciainicial = :dtvigenciainicial"),
    @NamedQuery(name = "Licenca.findByDtvigenciafinal", query = "SELECT l FROM Licenca l WHERE l.dtvigenciafinal = :dtvigenciafinal"),
    @NamedQuery(name = "Licenca.findByCodalerta", query = "SELECT l FROM Licenca l WHERE l.codalerta = :codalerta"),
    @NamedQuery(name = "Licenca.findByDtcriacao", query = "SELECT l FROM Licenca l WHERE l.dtcriacao = :dtcriacao"),
    @NamedQuery(name = "Licenca.findByCodusuariocriacao", query = "SELECT l FROM Licenca l WHERE l.codusuariocriacao = :codusuariocriacao"),
    @NamedQuery(name = "Licenca.findByDtultalteracao", query = "SELECT l FROM Licenca l WHERE l.dtultalteracao = :dtultalteracao"),
    @NamedQuery(name = "Licenca.findByCodusuarioultalteracao", query = "SELECT l FROM Licenca l WHERE l.codusuarioultalteracao = :codusuarioultalteracao")})
public class Licenca implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LicencaPK licencaPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "DESCLICENCA")
    private String desclicenca;
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
    @JoinColumn(name = "CODEMPRESA", referencedColumnName = "CODEMPRESA", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Empresa empresa;
    @JoinColumn(name = "CODPRODUTO", referencedColumnName = "CODPRODUTO", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Produto produto;

    public Licenca() {
    }

    public Licenca(LicencaPK licencaPK) {
        this.licencaPK = licencaPK;
    }

    public Licenca(LicencaPK licencaPK, String desclicenca, Date dtvigenciainicial, Date dtvigenciafinal, long codalerta, Date dtcriacao, String codusuariocriacao, Date dtultalteracao, String codusuarioultalteracao) {
        this.licencaPK = licencaPK;
        this.desclicenca = desclicenca;
        this.dtvigenciainicial = dtvigenciainicial;
        this.dtvigenciafinal = dtvigenciafinal;
        this.codalerta = codalerta;
        this.dtcriacao = dtcriacao;
        this.codusuariocriacao = codusuariocriacao;
        this.dtultalteracao = dtultalteracao;
        this.codusuarioultalteracao = codusuarioultalteracao;
    }

    public Licenca(long codempresa, long codlicenca, long codproduto) {
        this.licencaPK = new LicencaPK(codempresa, codlicenca, codproduto);
    }

    public LicencaPK getLicencaPK() {
        return licencaPK;
    }

    public void setLicencaPK(LicencaPK licencaPK) {
        this.licencaPK = licencaPK;
    }

    public String getDesclicenca() {
        return desclicenca;
    }

    public void setDesclicenca(String desclicenca) {
        this.desclicenca = desclicenca;
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

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (licencaPK != null ? licencaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Licenca)) {
            return false;
        }
        Licenca other = (Licenca) object;
        if ((this.licencaPK == null && other.licencaPK != null) || (this.licencaPK != null && !this.licencaPK.equals(other.licencaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nerv.cash.core.entity.Licenca[ licencaPK=" + licencaPK + " ]";
    }
    
}
