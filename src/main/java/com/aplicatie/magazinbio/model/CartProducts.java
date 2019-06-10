package com.aplicatie.magazinbio.model;

public class CartProducts {
    private Produse produs;
    private Integer nrBucati;

    public CartProducts(Produse produs, Integer nrBucati) {
        this.produs = produs;
        this.nrBucati = nrBucati;
    }

    public Produse getProdus() {
        return produs;
    }

    public void setProdus(Produse produs) {
        this.produs = produs;
    }

    public Integer getNrBucati() {
        return nrBucati;
    }

    public void setNrBucati(Integer nrBucati) {
        this.nrBucati = nrBucati;
    }

    @Override
    public String toString() {
        return "CartProducts{" +
                "produs=" + produs +
                ", nrBucati=" + nrBucati +
                '}';
    }
}
