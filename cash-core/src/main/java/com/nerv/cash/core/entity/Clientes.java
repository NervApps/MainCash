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
@Table(name = "CLIENTES")
@NamedQueries({
    @NamedQuery(name = "Clientes.findAll", query = "SELECT c FROM Clientes c"),
    @NamedQuery(name = "Clientes.findByCodempresa", query = "SELECT c FROM Clientes c WHERE c.clientesPK.codempresa = :codempresa"),
    @NamedQuery(name = "Clientes.findByCodcliente", query = "SELECT c FROM Clientes c WHERE c.clientesPK.codcliente = :codcliente"),
    @NamedQuery(name = "Clientes.findByNome", query = "SELECT c FROM Clientes c WHERE c.nome = :nome"),
    @NamedQuery(name = "Clientes.findBySituacao", query = "SELECT c FROM Clientes c WHERE c.situacao = :situacao"),
    @NamedQuery(name = "Clientes.findByDtnascimento", query = "SELECT c FROM Clientes c WHERE c.dtnascimento = :dtnascimento"),
    @NamedQuery(name = "Clientes.findByCodalerta", query = "SELECT c FROM Clientes c WHERE c.codalerta = :codalerta"),
    @NamedQuery(name = "Clientes.findByEndereco", query = "SELECT c FROM Clientes c WHERE c.endereco = :endereco"),
    @NamedQuery(name = "Clientes.findByTelefone", query = "SELECT c FROM Clientes c WHERE c.telefone = :telefone"),
    @NamedQuery(name = "Clientes.findByCodramo", query = "SELECT c FROM Clientes c WHERE c.codramo = :codramo"),
    @NamedQuery(name = "Clientes.findByCnpjCpf", query = "SELECT c FROM Clientes c WHERE c.cnpjCpf = :cnpjCpf"),
    @NamedQuery(name = "Clientes.findByEMail", query = "SELECT c FROM Clientes c WHERE c.eMail = :eMail"),
    @NamedQuery(name = "Clientes.findByLinkedin", query = "SELECT c FROM Clientes c WHERE c.linkedin = :linkedin"),
    @NamedQuery(name = "Clientes.findByFacebook", query = "SELECT c FROM Clientes c WHERE c.facebook = :facebook"),
    @NamedQuery(name = "Clientes.findByEMail2", query = "SELECT c FROM Clientes c WHERE c.eMail2 = :eMail2"),
    @NamedQuery(name = "Clientes.findByOutros", query = "SELECT c FROM Clientes c WHERE c.outros = :outros"),
    @NamedQuery(name = "Clientes.findBySexo", query = "SELECT c FROM Clientes c WHERE c.sexo = :sexo"),
    @NamedQuery(name = "Clientes.findByDtcriacao", query = "SELECT c FROM Clientes c WHERE c.dtcriacao = :dtcriacao"),
    @NamedQuery(name = "Clientes.findByCodusuariocriacao", query = "SELECT c FROM Clientes c WHERE c.codusuariocriacao = :codusuariocriacao"),
    @NamedQuery(name = "Clientes.findByDtultalteracao", query = "SELECT c FROM Clientes c WHERE c.dtultalteracao = :dtultalteracao"),
    @NamedQuery(name = "Clientes.findByCodusuarioultalteracao", query = "SELECT c FROM Clientes c WHERE c.codusuarioultalteracao = :codusuarioultalteracao")})
public class Clientes implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ClientesPK clientesPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOME")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "SITUACAO")
    private String situacao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DTNASCIMENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtnascimento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODALERTA")
    private long codalerta;
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
    @Column(name = "CNPJ_CPF")
    private long cnpjCpf;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "E_MAIL")
    private String eMail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "LINKEDIN")
    private String linkedin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "FACEBOOK")
    private String facebook;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "E_MAIL2")
    private String eMail2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "OUTROS")
    private String outros;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "SEXO")
    private String sexo;
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

    public Clientes() {
    }

    public Clientes(ClientesPK clientesPK) {
        this.clientesPK = clientesPK;
    }

    public Clientes(ClientesPK clientesPK, String nome, String situacao, Date dtnascimento, long codalerta, String endereco, long telefone, long codramo, long cnpjCpf, String eMail, String linkedin, String facebook, String eMail2, String outros, String sexo, Date dtcriacao, String codusuariocriacao, Date dtultalteracao, String codusuarioultalteracao) {
        this.clientesPK = clientesPK;
        this.nome = nome;
        this.situacao = situacao;
        this.dtnascimento = dtnascimento;
        this.codalerta = codalerta;
        this.endereco = endereco;
        this.telefone = telefone;
        this.codramo = codramo;
        this.cnpjCpf = cnpjCpf;
        this.eMail = eMail;
        this.linkedin = linkedin;
        this.facebook = facebook;
        this.eMail2 = eMail2;
        this.outros = outros;
        this.sexo = sexo;
        this.dtcriacao = dtcriacao;
        this.codusuariocriacao = codusuariocriacao;
        this.dtultalteracao = dtultalteracao;
        this.codusuarioultalteracao = codusuarioultalteracao;
    }

    public Clientes(long codempresa, long codcliente) {
        this.clientesPK = new ClientesPK(codempresa, codcliente);
    }

    public ClientesPK getClientesPK() {
        return clientesPK;
    }

    public void setClientesPK(ClientesPK clientesPK) {
        this.clientesPK = clientesPK;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Date getDtnascimento() {
        return dtnascimento;
    }

    public void setDtnascimento(Date dtnascimento) {
        this.dtnascimento = dtnascimento;
    }

    public long getCodalerta() {
        return codalerta;
    }

    public void setCodalerta(long codalerta) {
        this.codalerta = codalerta;
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

    public long getCnpjCpf() {
        return cnpjCpf;
    }

    public void setCnpjCpf(long cnpjCpf) {
        this.cnpjCpf = cnpjCpf;
    }

    public String getEMail() {
        return eMail;
    }

    public void setEMail(String eMail) {
        this.eMail = eMail;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getEMail2() {
        return eMail2;
    }

    public void setEMail2(String eMail2) {
        this.eMail2 = eMail2;
    }

    public String getOutros() {
        return outros;
    }

    public void setOutros(String outros) {
        this.outros = outros;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
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
        hash += (clientesPK != null ? clientesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clientes)) {
            return false;
        }
        Clientes other = (Clientes) object;
        if ((this.clientesPK == null && other.clientesPK != null) || (this.clientesPK != null && !this.clientesPK.equals(other.clientesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nerv.cash.core.entity.Clientes[ clientesPK=" + clientesPK + " ]";
    }
    
}
