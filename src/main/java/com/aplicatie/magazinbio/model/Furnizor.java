package com.aplicatie.magazinbio.model;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Date;

@Entity
@Table(name = "furnizori")
public class Furnizor {

    @Column(name = "nume")
    private String nume;

    @Column(name = "prenume")
    private String prenume;

    @Column(name = "data_nasterii")
    private Date datanasterii;

    @Id
    @Column(name = "mail")
    private String mail;

    @Column(name = "parola")
    private String parola;

    @Column(name = "telefon")
    private String telefon;

    @Column(name = "adresa")
    private String adresa;

    @Column(name = "codiban")
    private String codiban;

    @Column(name = "descriere")
    private String descriere;

    @Column(name = "puncte")
    private int puncte;
    @Lob
    @Column(name = "poza")
    private byte[] fileToUpload;

    @Transient
    private String poza;

    public Furnizor() {
    }

    public Furnizor(String nume, String prenume, Date data_nasterii, String mail, String telefon, String adresa, String codiban, String descriere, int puncte) {
        this.nume = nume;
        this.prenume = prenume;
        this.datanasterii = data_nasterii;
        this.mail = mail;
        this.telefon = telefon;
        this.adresa = adresa;
        this.codiban = codiban;
        this.descriere = descriere;
        this.puncte = puncte;
    }

    public Furnizor(String nume, String prenume, Date datanasterii, String mail, String parola, String telefon, String adresa, String codiban, String descriere, int puncte, byte[] fileToUpload) {
        this.nume = nume;
        this.prenume = prenume;
        this.datanasterii = datanasterii;
        this.mail = mail;
        this.parola = parola;
        this.telefon = telefon;
        this.adresa = adresa;
        this.codiban = codiban;
        this.descriere = descriere;
        this.puncte = puncte;
        this.fileToUpload = fileToUpload;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public Date getDatanasterii() {
        return datanasterii;
    }

    public void setDatanasterii(Date datanasterii) {
        this.datanasterii = datanasterii;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getCodiban() {
        return codiban;
    }

    public void setCodiban(String codiban) {
        this.codiban = codiban;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public int getPuncte() {
        return puncte;
    }

    public void setPuncte(int puncte) {
        this.puncte = puncte;
    }

    public byte[] getFileToUpload() {
        return fileToUpload;
    }

    public void setFileToUpload(byte[] fileToUpload) {
        this.fileToUpload = fileToUpload;
    }

    @Transient
    public String getPoza() {
        return poza;
    }

    @Transient
    public void setPoza(String poza) {
        this.poza = poza;
    }

    @Override
    public String toString() {
        return "Furnizor{" +
                "nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", datanasterii=" + datanasterii +
                ", mail='" + mail + '\'' +
                ", parola='" + parola + '\'' +
                ", telefon='" + telefon + '\'' +
                ", adresa='" + adresa + '\'' +
                ", codiban='" + codiban + '\'' +
                ", descriere='" + descriere + '\'' +
                ", puncte=" + puncte +
                ", fileToUpload=" + Arrays.toString(fileToUpload) +
                ", poza='" + poza + '\'' +
                '}';
    }
}
