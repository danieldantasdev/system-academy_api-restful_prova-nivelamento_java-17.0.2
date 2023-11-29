package com.senac.provanivelamento.provanivelamento.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Table(name = "descarte")
@Entity
public class Descarte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "descarte_id")
    private Long id;

    @Column(name = "descarte_data")
    private LocalDateTime data;

    @Column(name = "descarte_status")
    private Integer status;

    @Column(name = "descarte_tempo_disponivel")
    private LocalDateTime tempoDisponivel;

    @OneToOne
    @JoinColumn(name = "descartardor_id")
    private Descartador descartador;

    @OneToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    @OneToMany(mappedBy = "descarte", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<DescarteMaterial> descartes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public LocalDateTime getTempoDisponivel() {
        return tempoDisponivel;
    }

    public void setTempoDisponivel(LocalDateTime tempoDisponivel) {
        this.tempoDisponivel = tempoDisponivel;
    }

    public Descartador getDescartador() {
        return descartador;
    }

    public void setDescartador(Descartador descartador) {
        this.descartador = descartador;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<DescarteMaterial> getDescartes() {
        return descartes;
    }

    public void setDescartes(List<DescarteMaterial> descartes) {
        this.descartes = descartes;
    }
}