package com.aplicatie.magazinbio.model;

public class EditData {
    private String prenume;
    private String mail;
    private String telefon;
    private String adresa;
    private String fileToUpload;
    private String parolaNoua;
    private String parolaVeche;
    private String descriere;

    public EditData(String prenume, String mail, String telefon, String adresa, String fileToUpload, String parolaNoua, String parolaVeche) {
        this.prenume = prenume;
        this.mail = mail;
        this.telefon = telefon;
        this.adresa = adresa;
        this.fileToUpload = fileToUpload;
        this.parolaNoua = parolaNoua;
        this.parolaVeche = parolaVeche;
    }
    public EditData(String prenume, String mail, String telefon, String adresa, String fileToUpload, String parolaNoua, String parolaVeche, String descriere) {
        this.prenume = prenume;
        this.mail = mail;
        this.telefon = telefon;
        this.adresa = adresa;
        this.fileToUpload = fileToUpload;
        this.parolaNoua = parolaNoua;
        this.parolaVeche = parolaVeche;
        this.descriere = descriere;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
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

    public String getFileToUpload() {
        return fileToUpload;
    }

    public void setFileToUpload(String fileToUpload) {
        this.fileToUpload = fileToUpload;
    }

    public String getParolaNoua() {
        return parolaNoua;
    }

    public void setParolaNoua(String parolaNoua) {
        this.parolaNoua = parolaNoua;
    }

    public String getParolaVeche() {
        return parolaVeche;
    }

    public void setParolaVeche(String parolaVeche) {
        this.parolaVeche = parolaVeche;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    @Override
    public String toString() {
        return "EditData{" +
                "prenume='" + prenume + '\'' +
                ", mail='" + mail + '\'' +
                ", telefon='" + telefon + '\'' +
                ", adresa='" + adresa + '\'' +
                ", fileToUpload='" + fileToUpload + '\'' +
                ", parolaNoua='" + parolaNoua + '\'' +
                ", parolaVeche='" + parolaVeche + '\'' +
                ", descriere='" + descriere + '\'' +
                '}';
    }
}
