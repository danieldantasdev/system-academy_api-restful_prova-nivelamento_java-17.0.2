package com.senac.provanivelamento.provanivelamento.entity;

import jakarta.persistence.*;

@Table(name = "endereco")
@Entity
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "endereco_id")
    private Long id;

    @Column(name = "endereco_place_id")
    private String placeId;

    @Column(name = "endereco_rua")
    private String rua;

    @Column(name = "endereco_numero")
    private int numero;

    @Column(name = "endereco_complemento")
    private String complemento;

    @Column(name = "endereco_cep")
    private String cep;

    @OneToOne
    @JoinColumn(name = "bairro_id")
    private Bairro bairro;

    @OneToOne
    @JoinColumn(name = "cidade_id")
    private Cidade cidade;

    @OneToOne
    @JoinColumn(name = "estado_id")
    private Estado estado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
