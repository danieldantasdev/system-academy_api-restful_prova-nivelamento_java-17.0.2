package com.senac.provanivelamento.provanivelamento.entity;

import jakarta.persistence.*;

@Table(name = "tipo_material_descarte")
@Entity
public class TipoMaterialDescarte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tipo_material_descarte_id")
    private Long id;

    @Column(name = "tipo_material_descarte_nome")
    private String nome;

    @Column(name = "tipo_material_descarte_umedida")
    private String unidadeMedida;

    @Column(name = "material_coleta_status")
    private Integer status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "material_tipo_id")
    private MaterialTipo materialTipo;

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

    public String getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public MaterialTipo getMaterialTipo() {
        return materialTipo;
    }

    public void setMaterialTipo(MaterialTipo materialTipo) {
        this.materialTipo = materialTipo;
    }
}