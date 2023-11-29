package com.senac.provanivelamento.provanivelamento.entity;

import jakarta.persistence.*;

@Table(name = "usuario_tipo")
@Entity
public class UsuarioTipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_tipo_id")
    private Long id;

    @Column(name = "usuario_tipo_descricao", length = 45)
    private String descricao;

    @Column(name = "usuario_tipo_status", length = 45)
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}