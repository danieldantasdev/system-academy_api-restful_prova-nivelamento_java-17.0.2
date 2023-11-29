package com.senac.provanivelamento.provanivelamento.entity;

import jakarta.persistence.*;

@Table(name = "material_tipo")
@Entity
public class MaterialTipo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "material_tipo_id")
    private Long id;

    @Column(name = "material_tipo_descricao")
    private String descricao;

    @Column(name = "material_tipo_status")
    private int status;
}