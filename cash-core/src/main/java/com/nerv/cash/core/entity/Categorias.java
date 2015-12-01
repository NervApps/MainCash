/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nerv.cash.core.entity;

import java.io.Serializable;
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
@Table(name = "CATEGORIAS")
@NamedQueries({
    @NamedQuery(name = "Categorias.findAll", query = "SELECT c FROM Categorias c"),
    @NamedQuery(name = "Categorias.findByCodempresa", query = "SELECT c FROM Categorias c WHERE c.categoriasPK.codempresa = :codempresa"),
    @NamedQuery(name = "Categorias.findByCodcategoria", query = "SELECT c FROM Categorias c WHERE c.categoriasPK.codcategoria = :codcategoria"),
    @NamedQuery(name = "Categorias.findByDesccategorias", query = "SELECT c FROM Categorias c WHERE c.desccategorias = :desccategorias"),
    @NamedQuery(name = "Categorias.findByCodtipofinanceiro", query = "SELECT c FROM Categorias c WHERE c.codtipofinanceiro = :codtipofinanceiro"),
    @NamedQuery(name = "Categorias.findByDtcriacao", query = "SELECT c FROM Categorias c WHERE c.dtcriacao = :dtcriacao"),
    @NamedQuery(name = "Categorias.findByCodusuariocriacao", query = "SELECT c FROM Categorias c WHERE c.codusuariocriacao = :codusuariocriacao"),
    @NamedQuery(name = "Categorias.findByDtultalteracao", query = "SELECT c FROM Categorias c WHERE c.dtultalteracao = :dtultalteracao"),
    @NamedQuery(name = "Categorias.findByCodusuarioultalteracao", query = "SELECT c FROM Categorias c WHERE c.codusuarioultalteracao = :codusuarioultalteracao")})
public class Categorias implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CategoriasPK categoriasPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "DESCCATEGORIAS")
    private String desccategorias;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODTIPOFINANCEIRO")
    private long codtipofinanceiro;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categorias", fetch = FetchType.LAZY)
    private Collection<Subevento> subeventoCollection;

    public Categorias() {
    }

    public Categorias(CategoriasPK categoriasPK) {
        this.categoriasPK = categoriasPK;
    }

    public Categorias(CategoriasPK categoriasPK, String desccategorias, long codtipofinanceiro, Date dtcriacao, String codusuariocriacao, Date dtultalteracao, String codusuarioultalteracao) {
        this.categoriasPK = categoriasPK;
        this.desccategorias = desccategorias;
        this.codtipofinanceiro = codtipofinanceiro;
        this.dtcriacao = dtcriacao;
        this.codusuariocriacao = codusuariocriacao;
        this.dtultalteracao = dtultalteracao;
        this.codusuarioultalteracao = codusuarioultalteracao;
    }

    public Categorias(long codempresa, long codcategoria) {
        this.categoriasPK = new CategoriasPK(codempresa, codcategoria);
    }

    public CategoriasPK getCategoriasPK() {
        return categoriasPK;
    }

    public void setCategoriasPK(CategoriasPK categoriasPK) {
        this.categoriasPK = categoriasPK;
    }

    public String getDesccategorias() {
        return desccategorias;
    }

    public void setDesccategorias(String desccategorias) {
        this.desccategorias = desccategorias;
    }

    public long getCodtipofinanceiro() {
        return codtipofinanceiro;
    }

    public void setCodtipofinanceiro(long codtipofinanceiro) {
        this.codtipofinanceiro = codtipofinanceiro;
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

    public Collection<Subevento> getSubeventoCollection() {
        return subeventoCollection;
    }

    public void setSubeventoCollection(Collection<Subevento> subeventoCollection) {
        this.subeventoCollection = subeventoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (categoriasPK != null ? categoriasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categorias)) {
            return false;
        }
        Categorias other = (Categorias) object;
        if ((this.categoriasPK == null && other.categoriasPK != null) || (this.categoriasPK != null && !this.categoriasPK.equals(other.categoriasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nerv.cash.core.entity.Categorias[ categoriasPK=" + categoriasPK + " ]";
    }
    
}
