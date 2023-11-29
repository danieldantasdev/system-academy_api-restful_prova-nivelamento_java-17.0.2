package com.senac.provanivelamento.provanivelamento.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Table(name = "descarte_material")
@Entity
public class DescarteMaterial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "descarte_material_id")
    private Long id;

    @Column(name = "descarte_material_quantidade")
    private Double quantidade;

    @Column(name = "descarte_material_status_coleta")
    private Integer statusColeta;

    @Column(name = "descarte_material_status")
    private Integer status;

    @Column(name = "descarte_material_preco")
    private Double preco;

    @Column(name = "descarte_material_imposto")
    private Double imposto;

    @OneToOne
    @JoinColumn(name = "tipo_material_descarte_id")
    private TipoMaterialDescarte tipoMaterialDescarte;

    @ManyToOne()
    @JoinColumn(name = "descarte_id")
    @JsonBackReference
    private Descarte descarte;

    @ManyToOne
    @JoinColumn(name = "acordo_coleta_id")
    @JsonBackReference
    private AcordoColeta acordoColeta;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public Integer getStatusColeta() {
        return statusColeta;
    }

    public void setStatusColeta(Integer statusColeta) {
        this.statusColeta = statusColeta;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Double getImposto() {
        return imposto;
    }

    public void setImposto(Double imposto) {
        this.imposto = imposto;
    }

    public TipoMaterialDescarte getTipoMaterialDescarte() {
        return tipoMaterialDescarte;
    }

    public void setTipoMaterialDescarte(TipoMaterialDescarte tipoMaterialDescarte) {
        this.tipoMaterialDescarte = tipoMaterialDescarte;
    }

    public Descarte getDescarte() {
        return descarte;
    }

    public void setDescarte(Descarte descarte) {
        this.descarte = descarte;
    }

    public AcordoColeta getAcordoColeta() {
        return acordoColeta;
    }

    public void setAcordoColeta(AcordoColeta acordoColeta) {
        this.acordoColeta = acordoColeta;
    }
}