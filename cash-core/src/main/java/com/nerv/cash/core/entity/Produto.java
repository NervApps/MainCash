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
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
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
@Table(name = "PRODUTO")
@NamedQueries({
    @NamedQuery(name = "Produto.findAll", query = "SELECT p FROM Produto p"),
    @NamedQuery(name = "Produto.findByCodproduto", query = "SELECT p FROM Produto p WHERE p.codproduto = :codproduto"),
    @NamedQuery(name = "Produto.findByNome", query = "SELECT p FROM Produto p WHERE p.nome = :nome"),
    @NamedQuery(name = "Produto.findByCodcategoria", query = "SELECT p FROM Produto p WHERE p.codcategoria = :codcategoria"),
    @NamedQuery(name = "Produto.findByPrecounitario", query = "SELECT p FROM Produto p WHERE p.precounitario = :precounitario"),
    @NamedQuery(name = "Produto.findByCodmunicipio", query = "SELECT p FROM Produto p WHERE p.codmunicipio = :codmunicipio"),
    @NamedQuery(name = "Produto.findByCodimposto", query = "SELECT p FROM Produto p WHERE p.codimposto = :codimposto"),
    @NamedQuery(name = "Produto.findByDtcriacao", query = "SELECT p FROM Produto p WHERE p.dtcriacao = :dtcriacao"),
    @NamedQuery(name = "Produto.findByCodusuariocriacao", query = "SELECT p FROM Produto p WHERE p.codusuariocriacao = :codusuariocriacao"),
    @NamedQuery(name = "Produto.findByDtultalteracao", query = "SELECT p FROM Produto p WHERE p.dtultalteracao = :dtultalteracao"),
    @NamedQuery(name = "Produto.findByCodusuarioultalteracao", query = "SELECT p FROM Produto p WHERE p.codusuarioultalteracao = :codusuarioultalteracao")})
public class Produto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODPRODUTO")
    private Long codproduto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOME")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODCATEGORIA")
    private long codcategoria;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRECOUNITARIO")
    private BigDecimal precounitario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODMUNICIPIO")
    private long codmunicipio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIMPOSTO")
    private long codimposto;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produto", fetch = FetchType.LAZY)
    private Collection<Licenca> licencaCollection;

    public Produto() {
    }

    public Produto(Long codproduto) {
        this.codproduto = codproduto;
    }

    public Produto(Long codproduto, String nome, long codcategoria, BigDecimal precounitario, long codmunicipio, long codimposto, Date dtcriacao, String codusuariocriacao, Date dtultalteracao, String codusuarioultalteracao) {
        this.codproduto = codproduto;
        this.nome = nome;
        this.codcategoria = codcategoria;
        this.precounitario = precounitario;
        this.codmunicipio = codmunicipio;
        this.codimposto = codimposto;
        this.dtcriacao = dtcriacao;
        this.codusuariocriacao = codusuariocriacao;
        this.dtultalteracao = dtultalteracao;
        this.codusuarioultalteracao = codusuarioultalteracao;
    }

    public Long getCodproduto() {
        return codproduto;
    }

    public void setCodproduto(Long codproduto) {
        this.codproduto = codproduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getCodcategoria() {
        return codcategoria;
    }

    public void setCodcategoria(long codcategoria) {
        this.codcategoria = codcategoria;
    }

    public BigDecimal getPrecounitario() {
        return precounitario;
    }

    public void setPrecounitario(BigDecimal precounitario) {
        this.precounitario = precounitario;
    }

    public long getCodmunicipio() {
        return codmunicipio;
    }

    public void setCodmunicipio(long codmunicipio) {
        this.codmunicipio = codmunicipio;
    }

    public long getCodimposto() {
        return codimposto;
    }

    public void setCodimposto(long codimposto) {
        this.codimposto = codimposto;
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

    public Collection<Licenca> getLicencaCollection() {
        return licencaCollection;
    }

    public void setLicencaCollection(Collection<Licenca> licencaCollection) {
        this.licencaCollection = licencaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codproduto != null ? codproduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produto)) {
            return false;
        }
        Produto other = (Produto) object;
        if ((this.codproduto == null && other.codproduto != null) || (this.codproduto != null && !this.codproduto.equals(other.codproduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nerv.cash.core.entity.Produto[ codproduto=" + codproduto + " ]";
    }
    
}
