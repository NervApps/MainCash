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
@Table(name = "USUARIOS")
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u"),
    @NamedQuery(name = "Usuarios.findByCodempresa", query = "SELECT u FROM Usuarios u WHERE u.usuariosPK.codempresa = :codempresa"),
    @NamedQuery(name = "Usuarios.findByCodusuario", query = "SELECT u FROM Usuarios u WHERE u.usuariosPK.codusuario = :codusuario"),
    @NamedQuery(name = "Usuarios.findByNome", query = "SELECT u FROM Usuarios u WHERE u.nome = :nome"),
    @NamedQuery(name = "Usuarios.findByDatanascimento", query = "SELECT u FROM Usuarios u WHERE u.datanascimento = :datanascimento"),
    @NamedQuery(name = "Usuarios.findByDatainicio", query = "SELECT u FROM Usuarios u WHERE u.datainicio = :datainicio"),
    @NamedQuery(name = "Usuarios.findByDatafim", query = "SELECT u FROM Usuarios u WHERE u.datafim = :datafim"),
    @NamedQuery(name = "Usuarios.findByCodcargo", query = "SELECT u FROM Usuarios u WHERE u.codcargo = :codcargo"),
    @NamedQuery(name = "Usuarios.findByCoddepto", query = "SELECT u FROM Usuarios u WHERE u.coddepto = :coddepto"),
    @NamedQuery(name = "Usuarios.findByCodperfil", query = "SELECT u FROM Usuarios u WHERE u.codperfil = :codperfil"),
    @NamedQuery(name = "Usuarios.findByCodalerta", query = "SELECT u FROM Usuarios u WHERE u.codalerta = :codalerta"),
    @NamedQuery(name = "Usuarios.findByEmail", query = "SELECT u FROM Usuarios u WHERE u.email = :email"),
    @NamedQuery(name = "Usuarios.findByCodgerente", query = "SELECT u FROM Usuarios u WHERE u.codgerente = :codgerente"),
    @NamedQuery(name = "Usuarios.findBySexo", query = "SELECT u FROM Usuarios u WHERE u.sexo = :sexo"),
    @NamedQuery(name = "Usuarios.findByEstadocivil", query = "SELECT u FROM Usuarios u WHERE u.estadocivil = :estadocivil"),
    @NamedQuery(name = "Usuarios.findByDtcriacao", query = "SELECT u FROM Usuarios u WHERE u.dtcriacao = :dtcriacao"),
    @NamedQuery(name = "Usuarios.findByCodusuariocriacao", query = "SELECT u FROM Usuarios u WHERE u.codusuariocriacao = :codusuariocriacao"),
    @NamedQuery(name = "Usuarios.findByDtultalteracao", query = "SELECT u FROM Usuarios u WHERE u.dtultalteracao = :dtultalteracao"),
    @NamedQuery(name = "Usuarios.findByCodusuarioultalteracao", query = "SELECT u FROM Usuarios u WHERE u.codusuarioultalteracao = :codusuarioultalteracao")})
public class Usuarios implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UsuariosPK usuariosPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOME")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATANASCIMENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datanascimento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATAINICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datainicio;
    @Column(name = "DATAFIM")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datafim;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODCARGO")
    private long codcargo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODDEPTO")
    private long coddepto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODPERFIL")
    private long codperfil;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODALERTA")
    private long codalerta;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "CODGERENTE")
    private Long codgerente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "SEXO")
    private String sexo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "ESTADOCIVIL")
    private String estadocivil;
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

    public Usuarios() {
    }

    public Usuarios(UsuariosPK usuariosPK) {
        this.usuariosPK = usuariosPK;
    }

    public Usuarios(UsuariosPK usuariosPK, String nome, Date datanascimento, Date datainicio, long codcargo, long coddepto, long codperfil, long codalerta, String email, String sexo, String estadocivil, Date dtcriacao, String codusuariocriacao, Date dtultalteracao, String codusuarioultalteracao) {
        this.usuariosPK = usuariosPK;
        this.nome = nome;
        this.datanascimento = datanascimento;
        this.datainicio = datainicio;
        this.codcargo = codcargo;
        this.coddepto = coddepto;
        this.codperfil = codperfil;
        this.codalerta = codalerta;
        this.email = email;
        this.sexo = sexo;
        this.estadocivil = estadocivil;
        this.dtcriacao = dtcriacao;
        this.codusuariocriacao = codusuariocriacao;
        this.dtultalteracao = dtultalteracao;
        this.codusuarioultalteracao = codusuarioultalteracao;
    }

    public Usuarios(long codempresa, long codusuario) {
        this.usuariosPK = new UsuariosPK(codempresa, codusuario);
    }

    public UsuariosPK getUsuariosPK() {
        return usuariosPK;
    }

    public void setUsuariosPK(UsuariosPK usuariosPK) {
        this.usuariosPK = usuariosPK;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDatanascimento() {
        return datanascimento;
    }

    public void setDatanascimento(Date datanascimento) {
        this.datanascimento = datanascimento;
    }

    public Date getDatainicio() {
        return datainicio;
    }

    public void setDatainicio(Date datainicio) {
        this.datainicio = datainicio;
    }

    public Date getDatafim() {
        return datafim;
    }

    public void setDatafim(Date datafim) {
        this.datafim = datafim;
    }

    public long getCodcargo() {
        return codcargo;
    }

    public void setCodcargo(long codcargo) {
        this.codcargo = codcargo;
    }

    public long getCoddepto() {
        return coddepto;
    }

    public void setCoddepto(long coddepto) {
        this.coddepto = coddepto;
    }

    public long getCodperfil() {
        return codperfil;
    }

    public void setCodperfil(long codperfil) {
        this.codperfil = codperfil;
    }

    public long getCodalerta() {
        return codalerta;
    }

    public void setCodalerta(long codalerta) {
        this.codalerta = codalerta;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getCodgerente() {
        return codgerente;
    }

    public void setCodgerente(Long codgerente) {
        this.codgerente = codgerente;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEstadocivil() {
        return estadocivil;
    }

    public void setEstadocivil(String estadocivil) {
        this.estadocivil = estadocivil;
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
        hash += (usuariosPK != null ? usuariosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.usuariosPK == null && other.usuariosPK != null) || (this.usuariosPK != null && !this.usuariosPK.equals(other.usuariosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nerv.cash.core.entity.Usuarios[ usuariosPK=" + usuariosPK + " ]";
    }
    
}
