package com.aplicatie.magazinbio.model;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "reduceri")
public class Reducere {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idreducere")
    private Integer idreducere;

   @Column(name = "idprodus")
    private Integer idprodus;

    @Column(name = "procent")
    private Integer procent;

    @Column(name = "data_start")
    private Date dataStart;

    @Column(name = "data_final")
    private Date dataFinal;


    public Reducere() {
    }

    public Reducere(Integer idprodus, Integer procent, Date dataStart, Date dataFinal) {
        this.idprodus = idprodus;
        this.procent = procent;
        this.dataStart = dataStart;
        this.dataFinal = dataFinal;
    }

    public Integer getProduse() {
        return idprodus;
    }

    public void setProduse(Integer produse) {
        this.idprodus = produse;
    }

    public Integer getProcent() {
        return procent;
    }

    public void setProcent(Integer procent) {
        this.procent = procent;
    }

    public Date getDataStart() {
        return dataStart;
    }

    public void setDataStart(Date dataStart) {
        this.dataStart = dataStart;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    @Override
    public String toString() {
        return "Reducere{" +
                "idreducere=" + idreducere +
                ", idprodus=" + idprodus +
                ", procent=" + procent +
                ", dataStart=" + dataStart +
                ", dataFinal=" + dataFinal +
                '}';
    }
}
