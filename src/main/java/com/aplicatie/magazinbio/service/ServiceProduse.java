package com.aplicatie.magazinbio.service;

import com.aplicatie.magazinbio.exception.ExceptionInvalidQuantity;
import com.aplicatie.magazinbio.exception.ExceptionNotFound;
import com.aplicatie.magazinbio.model.*;
import com.aplicatie.magazinbio.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class ServiceProduse {
    @Autowired
    private RepositoryProduse repositoryProduse;
    @Autowired
    private RepositoryChitanta repositoryChitanta;
    @Autowired
    private RepositoryDetaliiChitanta repositoryDetaliiChitanta;
    @Autowired
    private RepositoryReducere repositoryReducere;
    @Autowired
    private RepositoryRecenzie repositoryRecenzie;

    private List<CartProducts> produseCos;

    public ServiceProduse() {
        produseCos = new ArrayList<>();
    }

    public List<Produse> getAllProduse() {
        String str;

        List<Produse> produses = repositoryProduse.findAll();
        for (Produse p : produses) {
            if (p.getImagine() != null) {
                str = new String(p.getImagine(), StandardCharsets.UTF_8);
                p.setPoza(str);
            }
            System.out.println(p.toString());
        }
        return produses;
    }

    public void insert(Produse produs) {


        byte[] byteImg = produs.getPoza().getBytes();

        produs.setImagine(byteImg);

        System.out.println(produs.toString());
        repositoryProduse.save(produs);
    }

    public Produse findProduct(Integer idprodus) throws ExceptionNotFound {
        System.out.println("caut produs");
        Optional<Produse> produs = repositoryProduse.findById(idprodus);
        if (!produs.isPresent()) {
            throw new ExceptionNotFound("Produs inexistent.");
        }
        System.out.println(produs.get().getNume());
        Produse produsFinal = produs.get();
        String str = new String(produsFinal.getImagine(), StandardCharsets.UTF_8);

        produsFinal.setPoza(str);
        return produs.get();
    }

    public void insertCart(CartProducts produsCos) {
        System.out.println(produseCos.toString());
        produseCos.add(produsCos);
        for (CartProducts c : this.produseCos) {
            System.out.println(c.toString());
        }

    }

    public List<CartProducts> getCart() {
        for (CartProducts c : this.produseCos) {
            System.out.println(c.toString());
        }
        return this.produseCos;
    }

    public Float sumProductsPrice() {
        Float sum = 0.0f;
        for (CartProducts c : this.produseCos) {
            sum = sum + (c.getNrBucati() * c.getProdus().getPret());
        }
        return sum;
    }

    @Transactional(rollbackFor = ExceptionInvalidQuantity.class)
    public void buyProductsFromCart(String mail, String tip) throws ExceptionInvalidQuantity {
        System.out.println("cumpara produs");
        Date date = new Date();
        Float sumaProduse = sumProductsPrice();
        Chitanta chitanta = new Chitanta(mail, date, sumaProduse, tip);
        repositoryChitanta.save(chitanta);
        System.out.println(chitanta.toString());

        Produse produs;
        System.out.println("id ul dorit");
        System.out.println(chitanta.getIdchitanta());
        System.out.println(this.produseCos.size());
        for (CartProducts c : this.produseCos) {
            System.out.println(mail);
            System.out.println(c.getProdus().getNume());
            System.out.println(c.getProdus().getDataProducere());
            produs = repositoryProduse.getProductByMailNameZoneCategoryProductiondatePrice(c.getProdus().getMail(), c.getProdus().getNume(), c.getProdus().getZona(), c.getProdus().getCategorie(), c.getProdus().getDataProducere(), c.getProdus().getPret());
            System.out.println(produs);
            DetaliiChitanta detaliiChitanta = new DetaliiChitanta(produs.getIdprodus(), chitanta.getIdchitanta(), c.getNrBucati(), c.getNrBucati() * c.getProdus().getPret());
            System.out.println(detaliiChitanta);
            if (produs.getStoc() - detaliiChitanta.getCantitate() < 0) {
                throw new ExceptionInvalidQuantity("Nu mai exista numarul de bucati din acest produs.");
            }
            produs.setStoc(produs.getStoc() - detaliiChitanta.getCantitate());
            repositoryProduse.save(produs);
            repositoryDetaliiChitanta.save(detaliiChitanta);
        }
        this.produseCos.clear();
    }

    public void deleteProductFromCart(int id) {
        for (CartProducts c : this.produseCos
        ) {
            if (c.getProdus().getIdprodus() == id) {
                produseCos.remove(c);
            }

        }
    }

    public List<Produse> getTop10Products() {
        List<Produse> produse = this.repositoryProduse.findProductsOrderByDate();

        int top10 = 10;
        String str;
        for (Produse produs : produse) {
            str = new String(produs.getImagine(), StandardCharsets.UTF_8);
            produs.setPoza(str);
            top10--;
            if (top10 == 0) {
                return produse;
            }
        }
        return produse;
    }

    public List<Produse> getAllMyroducts(String mail) {
        List<Produse> produse = repositoryProduse.getProductByMail(mail);
        String str;
        for (Produse produs : produse) {
            str = new String(produs.getImagine(), StandardCharsets.UTF_8);
            produs.setPoza(str);
        }
        return produse;
    }

    public void setDiscount(Reducere reducere) {

        repositoryReducere.save(reducere);

    }

    public void setStars(Integer starvalue, Integer idprodus, String mail) {

        Recenzie recenzie = repositoryRecenzie.getRecenzieByIdprodusAndMail(idprodus, mail);
        Recenzie recenzie1;
        if (recenzie != null) {
            recenzie.setVot(Float.valueOf(starvalue));
            recenzie.setDataRecenzie(new Date());
            repositoryRecenzie.save(recenzie);
        } else {
            recenzie1 = new Recenzie(idprodus, Float.valueOf(starvalue), mail, new Date());
            repositoryRecenzie.save(recenzie1);
        }
    }

    public Recenzie getRating(Integer idprodus) {
        Float sum = 0f;
        List<Recenzie> recenzii = repositoryRecenzie.getRecenzieByIdprodus(idprodus);
        if(recenzii.size()==0){
            Recenzie recenzie = new Recenzie();

            recenzie.setVot(0f);
            return recenzie;
        }
        for (Recenzie r : recenzii
        ) {
            sum = sum + r.getVot();
        }
        Recenzie recenzie = new Recenzie();

        recenzie.setVot(sum / recenzii.size());

        return recenzie;
    }

    public Reducere getDiscount(Integer idprodus) {
        Reducere reducere = repositoryReducere.getReducereByIdProdusAndDate(idprodus,new Date());
        Reducere reducereNuExista = new Reducere();
        System.out.println("recenzia mea");
        System.out.println(reducere);
        if(reducere == null){
            reducereNuExista.setProcent(0);
            System.out.println("nu exista");
            return  reducereNuExista;
        }
        return reducere;
    }
}

