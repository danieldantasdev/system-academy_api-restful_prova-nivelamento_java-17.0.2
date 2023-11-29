package com.senac.provanivelamento.provanivelamento.entity;

import jakarta.persistence.*;

@Table(name = "bairro")
@Entity
public class Bairro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bairro_id")
    private Long id;

    @Column(name = "bairro_nome")
    private String nome;

    @Column(name = "bairro_status")
    private int status;

    @OneToOne
    @JoinColumn(name = "cidade_id")
    private Cidade cidade;

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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
}
