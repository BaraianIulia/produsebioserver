package com.aplicatie.magazinbio.model;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "retete")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idreteta")
    private Integer idreteta;

    @Column(name = "nume")
    private String nume;

    @Column(name = "poza")
    private byte[] imagine;

    @Column(name = "lista_produse")
    private String listaproduse;

    @Column(name = "mod_preparare")
    private String modpreparare;

    @Column(name = "buget")
    private Float buget;

    @Column(name = "timp")
    private String timp;

    @Column(name = "mail")
    private String mail;

    @Transient
    private String poza;


    public Recipe(String nume, String poza, String listaProduse, String modPreparare, Float buget, String timp, String mail) {
        this.nume = nume;
        this.listaproduse = listaProduse;
        this.modpreparare = modPreparare;
        this.buget = buget;
        this.timp = timp;
        this.poza = poza;
        this.mail = mail;
    }

    public Recipe(String nume, byte[] imagine, String listaProduse, String modPreparare, Float buget, String timp, String mail) {
        this.nume = nume;
        this.imagine = imagine;
        this.listaproduse = listaProduse;
        this.modpreparare = modPreparare;
        this.buget = buget;
        this.timp = timp;
        this.mail = mail;
    }

    public Recipe() {
    }

    public Integer getIdreteta() {
        return idreteta;
    }

    public void setIdreteta(Integer idreteta) {
        this.idreteta = idreteta;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public byte[] getImagine() {
        return imagine;
    }

    public void setImagine(byte[] imagine) {
        this.imagine = imagine;
    }

    public String getListaproduse() {
        return listaproduse;
    }

    public void setListaproduse(String listaproduse) {
        this.listaproduse = listaproduse;
    }

    public String getModpreparare() {
        return modpreparare;
    }

    public void setModpreparare(String modpreparare) {
        this.modpreparare = modpreparare;
    }

    public Float getBuget() {
        return buget;
    }

    public void setBuget(Float buget) {
        this.buget = buget;
    }

    public String getTimp() {
        return timp;
    }

    public void setTimp(String timp) {
        this.timp = timp;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPoza() {
        return poza;
    }

    public void setPoza(String poza) {
        this.poza = poza;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "idreteta=" + idreteta +
                ", nume='" + nume + '\'' +
                ", imagine=" + Arrays.toString(imagine) +
                ", listaProduse='" + listaproduse + '\'' +
                ", modPreparare=" + modpreparare +
                ", buget=" + buget +
                ", timp='" + timp + '\'' +
                ", mail='" + mail + '\'' +
                ", poza='" + poza + '\'' +
                '}';
    }
}
