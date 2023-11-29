package com.senac.provanivelamento.provanivelamento.entity;

import jakarta.persistence.*;

@Table(name = "rota_trajeto")
@Entity
public class RotaTrajeto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "rota_trajeto_id")
    private Long id;

    @Column(name = "acordo_coleta_ordem")
    private int ordem;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rota_id")
    private Rota rota;

    @JoinColumn(name = "coleta_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private AcordoColeta acordo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getOrdem() {
        return ordem;
    }

    public void setOrdem(int ordem) {
        this.ordem = ordem;
    }

    public Rota getRota() {
        return rota;
    }

    public void setRota(Rota rota) {
        this.rota = rota;
    }

    public AcordoColeta getAcordo() {
        return acordo;
    }

    public void setAcordo(AcordoColeta acordo) {
        this.acordo = acordo;
    }
}