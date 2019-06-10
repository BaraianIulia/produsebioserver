package com.aplicatie.magazinbio.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "recenzii")
public class Recenzie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idrecenzie")
    private Integer idrecenzie;

    @Column(name = "idprodus")
    private Integer idprodus;

    @Column(name = "text_recenzie")
    private String textRecenzie;

    @Column(name = "vot")
    private Float vot;

    @Column(name = "data_recenzie")
    private Date dataRecenzie;

    @Column(name = "autor")
    private String autor;

    public Recenzie() {
    }

    public Recenzie(Integer idprodus, String textRecenzie, Float vot, Date dataRecenzie, String autor) {
        this.idprodus = idprodus;
        this.textRecenzie = textRecenzie;
        this.vot = vot;
        this.dataRecenzie = dataRecenzie;
        this.autor = autor;
    }

    public Recenzie(Integer idprodus, Float vot, String autor, Date dataRecenzie) {
        this.idprodus = idprodus;
        this.vot = vot;
        this.autor = autor;
        this.dataRecenzie= dataRecenzie;
    }

    public Integer getIdrecenzie() {
        return idrecenzie;
    }

    public void setIdrecenzie(Integer idrecenzie) {
        this.idrecenzie = idrecenzie;
    }

    public Integer getIdprodus() {
        return idprodus;
    }

    public void setIdprodus(Integer idprodus) {
        this.idprodus = idprodus;
    }

    public String getTextRecenzie() {
        return textRecenzie;
    }

    public void setTextRecenzie(String textRecenzie) {
        this.textRecenzie = textRecenzie;
    }

    public Float getVot() {
        return vot;
    }

    public void setVot(Float vot) {
        this.vot = vot;
    }

    public Date getDataRecenzie() {
        return dataRecenzie;
    }

    public void setDataRecenzie(Date dataRecenzie) {
        this.dataRecenzie = dataRecenzie;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Recenzie{" +
                "idrecenzie=" + idrecenzie +
                ", idprodus=" + idprodus +
                ", textRecenzie='" + textRecenzie + '\'' +
                ", vot=" + vot +
                ", dataRecenzie=" + dataRecenzie +
                ", autor='" + autor + '\'' +
                '}';
    }
}