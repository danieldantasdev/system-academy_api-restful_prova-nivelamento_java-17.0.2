package com.senac.provanivelamento.provanivelamento.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;


@Table(name = "rota")
@Entity
public class Rota {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "rota_id")
    private Long id;

    @Column(name = "rota_inicio_time")
    private LocalDateTime inicio;

    @Column(name = "rota_otimizada")
    private int otimizada;

    @Column(name = "rota_status")
    private int status;

    @OneToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    @JsonIgnore
    @OneToMany(mappedBy = "rota", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<RotaTrajeto> rotas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public void setInicio(LocalDateTime inicio) {
        this.inicio = inicio;
    }

    public int getOtimizada() {
        return otimizada;
    }

    public void setOtimizada(int otimizada) {
        this.otimizada = otimizada;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<RotaTrajeto> getRotas() {
        return rotas;
    }

    public void setRotas(List<RotaTrajeto> rotas) {
        this.rotas = rotas;
    }
}
