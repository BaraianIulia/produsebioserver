package com.aplicatie.magazinbio.model;

import javax.persistence.*;
import java.sql.Blob;
import java.util.Date;

@Entity
@Table(name = "clienti")
public class Client {

    @Column(name = "nume")
    private String nume;

    @Column(name = "prenume")
    private String prenume;

    @Column(name = "data_nasterii")
    private Date datanasterii;

    @Id
    @Column(name = "mail", nullable = false)
    private String mail;

    @Column(name = "parola")
    private String parola;

    @Column(name = "telefon")
    private String telefon;

    @Column(name = "adresa")
    private String adresa;

    @Column(name = "idcard")
    private int idcard;

    @Column(name = "puncte")
    private int puncte;


    @Column(name = "poza")
    private byte[] fileToUpload;

    @Transient
    private String poza;

    public Client() {
    }

    public Client(String nume, String prenume, Date data_nasterii, String mail, String telefon, String adresa, int idcard, int puncte, byte[] fileToUpload) {
        this.nume = nume;
        this.prenume = prenume;
        this.datanasterii = data_nasterii;
        this.mail = mail;
        this.telefon = telefon;
        this.adresa = adresa;
        this.idcard = idcard;
        this.puncte = puncte;
        this.fileToUpload = fileToUpload;
    }

    public Client(String nume, String prenume, Date datanasterii, String mail, String parola, String telefon, String adresa, int idcard, int puncte, byte[] fileToUpload) {
        this.nume = nume;
        this.prenume = prenume;
        this.datanasterii = datanasterii;
        this.mail = mail;
        this.parola = parola;
        this.telefon = telefon;
        this.adresa = adresa;
        this.idcard = idcard;
        this.puncte = puncte;
        this.fileToUpload = fileToUpload;
    }

    public byte[] getFileToUpload() {
        return fileToUpload;
    }

    public void setFileToUpload(byte[] fileToUpload) {
        this.fileToUpload = fileToUpload;
    }
    @Transient
    public void setPoza(String poza) {
        this.poza = poza;
    }
    @Transient
    public String getPoza() {
        return poza;
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

    public int getIdcard() {
        return idcard;
    }

    public void setIdcard(int idcard) {
        this.idcard = idcard;
    }

    public int getPuncte() {
        return puncte;
    }

    public void setPuncte(int puncte) {
        this.puncte = puncte;
    }



    @Override
    public String toString() {
        return "Client{" +
                ", nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", datanasterii=" + datanasterii +
                ", mail='" + mail + '\'' +
                ", parola='" + parola + '\'' +
                ", telefon='" + telefon + '\'' +
                ", adresa='" + adresa + '\'' +
                ", idcard=" + idcard +
                ", puncte='" + puncte + '\'' +
                ", poza=" + fileToUpload +
                '}';
    }
}
