package com.aplicatie.magazinbio.model;

import javax.persistence.*;

@Entity
@Table(name = "detalii_chitante")
public class DetaliiChitanta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "iddetalii_chitanta")
    private Integer iddetalii_chitanta;

    @Column(name = "idprodus")
    private Integer idprodus;

    @Column(name = "idchitanta")
    private Integer idchitanta;

    @Column(name = "cantitate")
    private Integer cantitate;

    @Column(name = "pret")
    private Float pret;

    public DetaliiChitanta(Integer idprodus, Integer idchitanta, Integer cantitate, Float pret) {
        this.idprodus = idprodus;
        this.idchitanta = idchitanta;
        this.cantitate = cantitate;
        this.pret = pret;
    }

    public DetaliiChitanta() {
    }

    public Integer getIddetalii_chitanta() {
        return iddetalii_chitanta;
    }

    public void setIddetalii_chitanta(Integer iddetalii_chitanta) {
        this.iddetalii_chitanta = iddetalii_chitanta;
    }

    public Integer getIdprodus() {
        return idprodus;
    }

    public void setIdprodus(Integer idprodus) {
        this.idprodus = idprodus;
    }

    public Integer getIdchitanta() {
        return idchitanta;
    }

    public void setIdchitanta(Integer idchitanta) {
        this.idchitanta = idchitanta;
    }

    public Integer getCantitate() {
        return cantitate;
    }

    public void setCantitate(Integer cantitate) {
        this.cantitate = cantitate;
    }

    public Float getPret() {
        return pret;
    }

    public void setPret(Float pret) {
        this.pret = pret;
    }

    @Override
    public String toString() {
        return "DetaliiChitanta{" +
                "iddetalii_chitanta=" + iddetalii_chitanta +
                ", idprodus=" + idprodus +
                ", idchitanta=" + idchitanta +
                ", cantitate=" + cantitate +
                ", pret=" + pret +
                '}';
    }
}