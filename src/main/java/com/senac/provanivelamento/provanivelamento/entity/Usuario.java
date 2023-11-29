package com.senac.provanivelamento.provanivelamento.entity;

import jakarta.persistence.*;

@Table(name = "usuario")
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
    private Long id;

    @Column(name = "usuario_email_login", length = 45)
    private String emailLogin;

    @Column(name = "usuario_nome", length = 250)
    private String nome;

    @Column(name = "usuario_telefone", length = 15)
    private String telefone;

    @Column(columnDefinition = "LONGBLOB", name = "usuario_foto")
    private byte[] foto;

    @Column(name = "usuario_cpf", length = 11)
    private String cpf;

    @Column(name = "usuario_cnpj", length = 15)
    private String cnpj;

    @Column(name = "usuario_senha", length = 45)
    private String senha;

    @Column(name = "usuario_status")
    private Integer status;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_tipo_id")
    private UsuarioTipo usuarioTipo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmailLogin() {
        return emailLogin;
    }

    public void setEmailLogin(String emailLogin) {
        this.emailLogin = emailLogin;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public UsuarioTipo getUsuarioTipo() {
        return usuarioTipo;
    }

    public void setUsuarioTipo(UsuarioTipo usuarioTipo) {
        this.usuarioTipo = usuarioTipo;
    }
}