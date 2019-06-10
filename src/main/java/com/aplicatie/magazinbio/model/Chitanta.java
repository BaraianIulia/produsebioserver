package com.aplicatie.magazinbio.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "chitante")
public class Chitanta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idchitanta")
    private Integer idchitanta;

    @Column(name = "mail")
    private String mail;

    @Column(name = "data_achizitie")
    private Date dataAchizitie;

    @Column(name = "pret_total")
    private Float pretTotal;

    @Column(name = "tip")
    private String tip;

    public Chitanta(String mail, Date dataAchizitie, Float pretTotal, String tip) {
        this.mail = mail;
        this.dataAchizitie = dataAchizitie;
        this.pretTotal = pretTotal;
        this.tip = tip;
    }

    public Chitanta() {
    }

    public Integer getIdchitanta() {
        return idchitanta;
    }

    public void setIdchitanta(Integer idchitanta) {
        this.idchitanta = idchitanta;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Date getDataAchizitie() {
        return dataAchizitie;
    }

    public void setDataAchizitie(Date dataAchizitie) {
        this.dataAchizitie = dataAchizitie;
    }

    public Float getPretTotal() {
        return pretTotal;
    }

    public void setPretTotal(Float pretTotal) {
        this.pretTotal = pretTotal;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    @Override
    public String toString() {
        return "Chitanta{" +
                "idchitanta=" + idchitanta +
                ", mail='" + mail + '\'' +
                ", dataAchizitie=" + dataAchizitie +
                ", pretTotal=" + pretTotal +
                ", tip='" + tip + '\'' +
                '}';
    }
}
