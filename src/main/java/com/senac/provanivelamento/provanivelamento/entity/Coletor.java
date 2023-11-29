package com.senac.provanivelamento.provanivelamento.entity;

import jakarta.persistence.*;

@Table(name = "coletor")
@Entity
public class Coletor {

    @Id
    @Column(name = "coletor_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}