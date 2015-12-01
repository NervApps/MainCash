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
@Table(name = "TIPOFINANCEIRO")
@NamedQueries({
    @NamedQuery(name = "Tipofinanceiro.findAll", query = "SELECT t FROM Tipofinanceiro t"),
    @NamedQuery(name = "Tipofinanceiro.findByCodtipofinanceiro", query = "SELECT t FROM Tipofinanceiro t WHERE t.codtipofinanceiro = :codtipofinanceiro"),
    @NamedQuery(name = "Tipofinanceiro.findByDesctipofinanceiro", query = "SELECT t FROM Tipofinanceiro t WHERE t.desctipofinanceiro = :desctipofinanceiro"),
    @NamedQuery(name = "Tipofinanceiro.findByDtcriacao", query = "SELECT t FROM Tipofinanceiro t WHERE t.dtcriacao = :dtcriacao"),
    @NamedQuery(name = "Tipofinanceiro.findByCodusuariocriacao", query = "SELECT t FROM Tipofinanceiro t WHERE t.codusuariocriacao = :codusuariocriacao"),
    @NamedQuery(name = "Tipofinanceiro.findByDtultalteracao", query = "SELECT t FROM Tipofinanceiro t WHERE t.dtultalteracao = :dtultalteracao"),
    @NamedQuery(name = "Tipofinanceiro.findByCodusuarioultalteracao", query = "SELECT t FROM Tipofinanceiro t WHERE t.codusuarioultalteracao = :codusuarioultalteracao")})
public class Tipofinanceiro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODTIPOFINANCEIRO")
    private Long codtipofinanceiro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "DESCTIPOFINANCEIRO")
    private String desctipofinanceiro;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codtipofinanceiro", fetch = FetchType.LAZY)
    private Collection<Eventos> eventosCollection;

    public Tipofinanceiro() {
    }

    public Tipofinanceiro(Long codtipofinanceiro) {
        this.codtipofinanceiro = codtipofinanceiro;
    }

    public Tipofinanceiro(Long codtipofinanceiro, String desctipofinanceiro, Date dtcriacao, String codusuariocriacao, Date dtultalteracao, String codusuarioultalteracao) {
        this.codtipofinanceiro = codtipofinanceiro;
        this.desctipofinanceiro = desctipofinanceiro;
        this.dtcriacao = dtcriacao;
        this.codusuariocriacao = codusuariocriacao;
        this.dtultalteracao = dtultalteracao;
        this.codusuarioultalteracao = codusuarioultalteracao;
    }

    public Long getCodtipofinanceiro() {
        return codtipofinanceiro;
    }

    public void setCodtipofinanceiro(Long codtipofinanceiro) {
        this.codtipofinanceiro = codtipofinanceiro;
    }

    public String getDesctipofinanceiro() {
        return desctipofinanceiro;
    }

    public void setDesctipofinanceiro(String desctipofinanceiro) {
        this.desctipofinanceiro = desctipofinanceiro;
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

    public Collection<Eventos> getEventosCollection() {
        return eventosCollection;
    }

    public void setEventosCollection(Collection<Eventos> eventosCollection) {
        this.eventosCollection = eventosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codtipofinanceiro != null ? codtipofinanceiro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipofinanceiro)) {
            return false;
        }
        Tipofinanceiro other = (Tipofinanceiro) object;
        if ((this.codtipofinanceiro == null && other.codtipofinanceiro != null) || (this.codtipofinanceiro != null && !this.codtipofinanceiro.equals(other.codtipofinanceiro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nerv.cash.core.entity.Tipofinanceiro[ codtipofinanceiro=" + codtipofinanceiro + " ]";
    }
    
}
