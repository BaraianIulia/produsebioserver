package com.aplicatie.magazinbio.model;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Date;

@Entity
@Table(name = "produse")
@SecondaryTable(name = "detalii_produse", pkJoinColumns = @PrimaryKeyJoinColumn(name = "idprodus"))
public class Produse {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idprodus")
    private Integer idprodus;

    @Column(name = "mail")
    private String mail;

    @Column(name = "stoc")
    private Integer stoc;

    @Column(name = "zona")
    private String zona;

    @Column(name = "imagine")
    private byte[] imagine;

    @Column(name = "categorie")
    private String categorie;

    @Column(name = "data_producere")
    private Date dataProducere;

    @Column(name = "pret")
    private Float pret;

    @Column(name = "termen_valabilitate")
    private Integer termenValabilitate;

    @Column(table = "detalii_produse", name = "nume")
    private String nume;

    @Column(table = "detalii_produse", name = "descriere")
    private String descriere;

    @Column(table = "detalii_produse", name = "unitate_de_masura")
    private String unitateDeMasura;

    @Column(table = "detalii_produse", name = "valoare_masura")
    private Float valoareMasura;

    @Transient
    private String poza;

    public Produse() {
    }


    public Produse(String mail, Integer stoc, String zona, String categorie, Date dataProducere, Float pret, Integer termenValabilitate, String nume, String descriere, String unitateDeMasura, Float valoareMasura, String poza) {
        this.mail = mail;
        this.stoc = stoc;
        this.zona = zona;
        this.categorie = categorie;
        this.dataProducere = dataProducere;
        this.pret = pret;
        this.termenValabilitate = termenValabilitate;
        this.nume = nume;
        this.descriere = descriere;
        this.unitateDeMasura = unitateDeMasura;
        this.valoareMasura = valoareMasura;
        this.poza = poza;
    }

    public Produse(Integer idprodus, String mail, Integer stoc, String zona, String categorie, Date dataProducere, Float pret, Integer termenValabilitate, String nume, String descriere, String unitateDeMasura, Float valoareMasura, String poza) {
        this.idprodus = idprodus;
        this.mail = mail;
        this.stoc = stoc;
        this.zona = zona;
        this.categorie = categorie;
        this.dataProducere = dataProducere;
        this.pret = pret;
        this.termenValabilitate = termenValabilitate;
        this.nume = nume;
        this.descriere = descriere;
        this.unitateDeMasura = unitateDeMasura;
        this.valoareMasura = valoareMasura;
        this.poza = poza;
    }

    public Produse(String mail, Integer stoc, String zona, byte[] imagine, String categorie, Date dataProducere, Float pret, Integer termenValabilitate, String nume, String descriere, String unitateDeMasura, Float valoareMasura) {
        this.mail = mail;
        this.stoc = stoc;
        this.zona = zona;
        this.imagine = imagine;
        this.categorie = categorie;
        this.dataProducere = dataProducere;
        this.pret = pret;
        this.termenValabilitate = termenValabilitate;
        this.nume = nume;
        this.descriere = descriere;
        this.unitateDeMasura = unitateDeMasura;
        this.valoareMasura = valoareMasura;
    }


    public String getPoza() {
        return poza;
    }

    public void setPoza(String poza) {
        this.poza = poza;
    }

    public Integer getIdprodus() {
        return idprodus;
    }

    public void setIdprodus(Integer idprodus) {
        this.idprodus = idprodus;
    }


    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Integer getStoc() {
        return stoc;
    }

    public void setStoc(Integer stoc) {
        this.stoc = stoc;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public byte[] getImagine() {
        return imagine;
    }

    public void setImagine(byte[] imagine) {
        this.imagine = imagine;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public Date getDataProducere() {
        return dataProducere;
    }

    public void setDataProducere(Date dataProducere) {
        this.dataProducere = dataProducere;
    }

    public Float getPret() {
        return pret;
    }

    public void setPret(Float pret) {
        this.pret = pret;
    }

    public Integer getTermenValabilitate() {
        return termenValabilitate;
    }

    public void setTermenValabilitate(Integer termenValabilitate) {
        this.termenValabilitate = termenValabilitate;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public String getUnitateDeMasura() {
        return unitateDeMasura;
    }

    public void setUnitateDeMasura(String unitateDeMasura) {
        this.unitateDeMasura = unitateDeMasura;
    }

    public Float getValoareMasura() {
        return valoareMasura;
    }

    public void setValoareMasura(Float valoareMasura) {
        this.valoareMasura = valoareMasura;
    }

    @Override
    public String toString() {
        return "Produse{" +
                "idprodus=" + idprodus +
                ", mail='" + mail + '\'' +
                ", stoc=" + stoc +
                ", zona='" + zona + '\'' +
                ", imagine=" + Arrays.toString(imagine) +
                ", categorie='" + categorie + '\'' +
                ", dataProducere=" + dataProducere +
                ", pret=" + pret +
                ", termenValabilitate=" + termenValabilitate +
                ", nume='" + nume + '\'' +
                ", descriere='" + descriere + '\'' +
                ", unitateDeMasura='" + unitateDeMasura + '\'' +
                ", valoareMasura=" + valoareMasura +
                '}';
    }
}
