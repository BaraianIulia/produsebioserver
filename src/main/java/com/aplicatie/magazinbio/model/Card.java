package com.aplicatie.magazinbio.model;


import javax.persistence.*;


@Entity
@Table(name = "carduri")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idcard")
    private Integer idcard;

    @Column(name = "numar")
    private String numar;

    @Column(name = "data_expirare")
    private String dataexpirare;

    @Column(name = "cvvcod")
    private String cvvcod;

    public Card(String numar, String dataexpirare, String cvvcod) {
        this.numar = numar;
        this.dataexpirare = dataexpirare;
        this.cvvcod = cvvcod;
    }

    public Card() {
    }

    public Integer getIdcard() {
        return idcard;
    }

    public void setIdcard(Integer idcard) {
        this.idcard = idcard;
    }

    public String getNumar() {
        return numar;
    }

    public void setNumar(String numar) {
        this.numar = numar;
    }

    public String getDataexpirare() {
        return dataexpirare;
    }

    public void setDataexpirare(String dataexpirare) {
        this.dataexpirare = dataexpirare;
    }

    public String getCvvcod() {
        return cvvcod;
    }

    public void setCvvcod(String cvvcod) {
        this.cvvcod = cvvcod;
    }

    @Override
    public String toString() {
        return "Card{" +
                "numar='" + numar + '\'' +
                ", dataexpirare='" + dataexpirare + '\'' +
                ", cvvcod='" + cvvcod + '\'' +
                '}';
    }
}
