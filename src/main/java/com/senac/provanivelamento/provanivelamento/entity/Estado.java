package com.senac.provanivelamento.provanivelamento.entity;

import jakarta.persistence.*;

@Table(name = "estado")
@Entity
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "estado_id")
    private Long id;

    @Column(name = "estado_nome")
    private String nome;

    @Column(name = "estado_sigla")
    private String sigla;

    @Column(name = "estado_status")
    private int status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}