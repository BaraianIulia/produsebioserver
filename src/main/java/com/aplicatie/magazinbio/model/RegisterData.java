package com.aplicatie.magazinbio.model;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.Date;

public class RegisterData {
    private String nume;
    private String prenume;
    private Date datanasterii;
    private String mail;
    private String telefon;
    private String adresa;
    private int puncte;
    private String fileToUpload;
    private Card card;
    private String codiban;
    private String descriere;
    private String parola;

    public RegisterData(String nume, String prenume, Date datanasterii, String mail, String telefon, String adresa, int puncte, String fileToUpload, Card card, String codiban, String descriere, String parola) throws UnsupportedEncodingException, SQLException {
        this.nume = nume;
        this.prenume = prenume;
        this.datanasterii = datanasterii;
        this.mail = mail;
        this.telefon = telefon;
        this.adresa = adresa;
        this.puncte = puncte;
        this.fileToUpload = fileToUpload;
        this.card = card;
        this.codiban = codiban;
        this.descriere = descriere;
        this.parola = parola;
    }

    public RegisterData() {
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

    public int getPuncte() {
        return puncte;
    }

    public void setPuncte(int puncte) {
        this.puncte = puncte;
    }

    public String getFileToUpload() {
        return fileToUpload;
    }

    public void setFileToUpload(String fileToUpload) {
        this.fileToUpload = fileToUpload;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
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

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    @Override
    public String toString() {
        return "RegisterData{" +
                "nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", datanasterii=" + datanasterii +
                ", mail='" + mail + '\'' +
                ", telefon='" + telefon + '\'' +
                ", adresa='" + adresa + '\'' +
                ", puncte=" + puncte +
                ", fileToUpload=" + fileToUpload +
                ", card=" + card +
                ", codiban='" + codiban + '\'' +
                ", descriere='" + descriere + '\'' +
                ", parola='" + parola + '\'' +
                '}';
    }
}
