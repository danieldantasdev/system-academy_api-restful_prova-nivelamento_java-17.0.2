package com.senac.provanivelamento.provanivelamento.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Table(name = "acordo_coleta")
@Entity
public class AcordoColeta {
    @Id
    @Column(name = "acordo_coleta_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "acordo_coleta_data_solicitacao")
    private LocalDateTime DataSolicitacao;

    @Column(name = "acordo_coleta_data_coleta")
    private LocalDateTime DataColeta;

    @Column(name = "acordo_coleta_status")
    private int status;

    @OneToOne
    @JoinColumn(name = "coletor_id")
    private Coletor coletor;

    @OneToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    private List<RotaTrajeto> rotaTrajeto;

    @OneToMany(mappedBy = "acordoColeta", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<DescarteMaterial> coletas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataSolicitacao() {
        return DataSolicitacao;
    }

    public void setDataSolicitacao(LocalDateTime dataSolicitacao) {
        DataSolicitacao = dataSolicitacao;
    }

    public LocalDateTime getDataColeta() {
        return DataColeta;
    }

    public void setDataColeta(LocalDateTime dataColeta) {
        DataColeta = dataColeta;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Coletor getColetor() {
        return coletor;
    }

    public void setColetor(Coletor coletor) {
        this.coletor = coletor;
    }

    public List<RotaTrajeto> getRotaTrajeto() {
        return rotaTrajeto;
    }

    public void setRotaTrajeto(List<RotaTrajeto> rotaTrajeto) {
        this.rotaTrajeto = rotaTrajeto;
    }

    public List<DescarteMaterial> getColetas() {
        return coletas;
    }

    public void setColetas(List<DescarteMaterial> coletas) {
        this.coletas = coletas;
    }
}
