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
@Table(name = "BANCOS")
@NamedQueries({
    @NamedQuery(name = "Bancos.findAll", query = "SELECT b FROM Bancos b"),
    @NamedQuery(name = "Bancos.findByCodbanco", query = "SELECT b FROM Bancos b WHERE b.codbanco = :codbanco"),
    @NamedQuery(name = "Bancos.findByNome", query = "SELECT b FROM Bancos b WHERE b.nome = :nome"),
    @NamedQuery(name = "Bancos.findByDtcriacao", query = "SELECT b FROM Bancos b WHERE b.dtcriacao = :dtcriacao"),
    @NamedQuery(name = "Bancos.findByCodusuariocriacao", query = "SELECT b FROM Bancos b WHERE b.codusuariocriacao = :codusuariocriacao"),
    @NamedQuery(name = "Bancos.findByDtultalteracao", query = "SELECT b FROM Bancos b WHERE b.dtultalteracao = :dtultalteracao"),
    @NamedQuery(name = "Bancos.findByCodusuarioultalteracao", query = "SELECT b FROM Bancos b WHERE b.codusuarioultalteracao = :codusuarioultalteracao")})
public class Bancos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODBANCO")
    private Long codbanco;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOME")
    private String nome;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bancos", fetch = FetchType.LAZY)
    private Collection<Contas> contasCollection;

    public Bancos() {
    }

    public Bancos(Long codbanco) {
        this.codbanco = codbanco;
    }

    public Bancos(Long codbanco, String nome, Date dtcriacao, String codusuariocriacao, Date dtultalteracao, String codusuarioultalteracao) {
        this.codbanco = codbanco;
        this.nome = nome;
        this.dtcriacao = dtcriacao;
        this.codusuariocriacao = codusuariocriacao;
        this.dtultalteracao = dtultalteracao;
        this.codusuarioultalteracao = codusuarioultalteracao;
    }

    public Long getCodbanco() {
        return codbanco;
    }

    public void setCodbanco(Long codbanco) {
        this.codbanco = codbanco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public Collection<Contas> getContasCollection() {
        return contasCollection;
    }

    public void setContasCollection(Collection<Contas> contasCollection) {
        this.contasCollection = contasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codbanco != null ? codbanco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bancos)) {
            return false;
        }
        Bancos other = (Bancos) object;
        if ((this.codbanco == null && other.codbanco != null) || (this.codbanco != null && !this.codbanco.equals(other.codbanco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nerv.cash.core.entity.Bancos[ codbanco=" + codbanco + " ]";
    }
    
}
