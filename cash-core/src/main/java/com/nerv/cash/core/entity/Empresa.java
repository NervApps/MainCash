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
@Table(name = "EMPRESA")
@NamedQueries({
    @NamedQuery(name = "Empresa.findAll", query = "SELECT e FROM Empresa e"),
    @NamedQuery(name = "Empresa.findByCodempresa", query = "SELECT e FROM Empresa e WHERE e.codempresa = :codempresa"),
    @NamedQuery(name = "Empresa.findByNome", query = "SELECT e FROM Empresa e WHERE e.nome = :nome"),
    @NamedQuery(name = "Empresa.findByCnpj", query = "SELECT e FROM Empresa e WHERE e.cnpj = :cnpj"),
    @NamedQuery(name = "Empresa.findByEndereco", query = "SELECT e FROM Empresa e WHERE e.endereco = :endereco"),
    @NamedQuery(name = "Empresa.findByTelefone", query = "SELECT e FROM Empresa e WHERE e.telefone = :telefone"),
    @NamedQuery(name = "Empresa.findByCodramo", query = "SELECT e FROM Empresa e WHERE e.codramo = :codramo"),
    @NamedQuery(name = "Empresa.findByNomefantasia", query = "SELECT e FROM Empresa e WHERE e.nomefantasia = :nomefantasia"),
    @NamedQuery(name = "Empresa.findByDtcriacao", query = "SELECT e FROM Empresa e WHERE e.dtcriacao = :dtcriacao"),
    @NamedQuery(name = "Empresa.findByCodusuariocriacao", query = "SELECT e FROM Empresa e WHERE e.codusuariocriacao = :codusuariocriacao"),
    @NamedQuery(name = "Empresa.findByDtultalteracao", query = "SELECT e FROM Empresa e WHERE e.dtultalteracao = :dtultalteracao"),
    @NamedQuery(name = "Empresa.findByCodusuarioultalteracao", query = "SELECT e FROM Empresa e WHERE e.codusuarioultalteracao = :codusuarioultalteracao")})
public class Empresa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODEMPRESA")
    private Long codempresa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOME")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CNPJ")
    private long cnpj;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ENDERECO")
    private String endereco;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TELEFONE")
    private long telefone;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODRAMO")
    private long codramo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMEFANTASIA")
    private String nomefantasia;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresa", fetch = FetchType.LAZY)
    private Collection<Eventos> eventosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresa", fetch = FetchType.LAZY)
    private Collection<Usuarios> usuariosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresa", fetch = FetchType.LAZY)
    private Collection<Telas> telasCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresa", fetch = FetchType.LAZY)
    private Collection<Atraso> atrasoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresa", fetch = FetchType.LAZY)
    private Collection<Categorias> categoriasCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresa", fetch = FetchType.LAZY)
    private Collection<Impostos> impostosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresa", fetch = FetchType.LAZY)
    private Collection<Licenca> licencaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresa", fetch = FetchType.LAZY)
    private Collection<Clientes> clientesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresa", fetch = FetchType.LAZY)
    private Collection<Motivos> motivosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresa", fetch = FetchType.LAZY)
    private Collection<Seguranca> segurancaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresa", fetch = FetchType.LAZY)
    private Collection<Contas> contasCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresa", fetch = FetchType.LAZY)
    private Collection<Cargos> cargosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresa", fetch = FetchType.LAZY)
    private Collection<Perfil> perfilCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresa", fetch = FetchType.LAZY)
    private Collection<Subevento> subeventoCollection;

    public Empresa() {
    }

    public Empresa(Long codempresa) {
        this.codempresa = codempresa;
    }

    public Empresa(Long codempresa, String nome, long cnpj, String endereco, long telefone, long codramo, String nomefantasia, Date dtcriacao, String codusuariocriacao, Date dtultalteracao, String codusuarioultalteracao) {
        this.codempresa = codempresa;
        this.nome = nome;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.telefone = telefone;
        this.codramo = codramo;
        this.nomefantasia = nomefantasia;
        this.dtcriacao = dtcriacao;
        this.codusuariocriacao = codusuariocriacao;
        this.dtultalteracao = dtultalteracao;
        this.codusuarioultalteracao = codusuarioultalteracao;
    }

    public Long getCodempresa() {
        return codempresa;
    }

    public void setCodempresa(Long codempresa) {
        this.codempresa = codempresa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getCnpj() {
        return cnpj;
    }

    public void setCnpj(long cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public long getTelefone() {
        return telefone;
    }

    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }

    public long getCodramo() {
        return codramo;
    }

    public void setCodramo(long codramo) {
        this.codramo = codramo;
    }

    public String getNomefantasia() {
        return nomefantasia;
    }

    public void setNomefantasia(String nomefantasia) {
        this.nomefantasia = nomefantasia;
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

    public Collection<Usuarios> getUsuariosCollection() {
        return usuariosCollection;
    }

    public void setUsuariosCollection(Collection<Usuarios> usuariosCollection) {
        this.usuariosCollection = usuariosCollection;
    }

    public Collection<Telas> getTelasCollection() {
        return telasCollection;
    }

    public void setTelasCollection(Collection<Telas> telasCollection) {
        this.telasCollection = telasCollection;
    }

    public Collection<Atraso> getAtrasoCollection() {
        return atrasoCollection;
    }

    public void setAtrasoCollection(Collection<Atraso> atrasoCollection) {
        this.atrasoCollection = atrasoCollection;
    }

    public Collection<Categorias> getCategoriasCollection() {
        return categoriasCollection;
    }

    public void setCategoriasCollection(Collection<Categorias> categoriasCollection) {
        this.categoriasCollection = categoriasCollection;
    }

    public Collection<Impostos> getImpostosCollection() {
        return impostosCollection;
    }

    public void setImpostosCollection(Collection<Impostos> impostosCollection) {
        this.impostosCollection = impostosCollection;
    }

    public Collection<Licenca> getLicencaCollection() {
        return licencaCollection;
    }

    public void setLicencaCollection(Collection<Licenca> licencaCollection) {
        this.licencaCollection = licencaCollection;
    }

    public Collection<Clientes> getClientesCollection() {
        return clientesCollection;
    }

    public void setClientesCollection(Collection<Clientes> clientesCollection) {
        this.clientesCollection = clientesCollection;
    }

    public Collection<Motivos> getMotivosCollection() {
        return motivosCollection;
    }

    public void setMotivosCollection(Collection<Motivos> motivosCollection) {
        this.motivosCollection = motivosCollection;
    }

    public Collection<Seguranca> getSegurancaCollection() {
        return segurancaCollection;
    }

    public void setSegurancaCollection(Collection<Seguranca> segurancaCollection) {
        this.segurancaCollection = segurancaCollection;
    }

    public Collection<Contas> getContasCollection() {
        return contasCollection;
    }

    public void setContasCollection(Collection<Contas> contasCollection) {
        this.contasCollection = contasCollection;
    }

    public Collection<Cargos> getCargosCollection() {
        return cargosCollection;
    }

    public void setCargosCollection(Collection<Cargos> cargosCollection) {
        this.cargosCollection = cargosCollection;
    }

    public Collection<Perfil> getPerfilCollection() {
        return perfilCollection;
    }

    public void setPerfilCollection(Collection<Perfil> perfilCollection) {
        this.perfilCollection = perfilCollection;
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
        hash += (codempresa != null ? codempresa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empresa)) {
            return false;
        }
        Empresa other = (Empresa) object;
        if ((this.codempresa == null && other.codempresa != null) || (this.codempresa != null && !this.codempresa.equals(other.codempresa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nerv.cash.core.entity.Empresa[ codempresa=" + codempresa + " ]";
    }
    
}
