package com.aplicatie.magazinbio.controller;

import com.aplicatie.magazinbio.exception.ExceptionInvalidQuantity;
import com.aplicatie.magazinbio.exception.ExceptionNotFound;
import com.aplicatie.magazinbio.model.CartProducts;
import com.aplicatie.magazinbio.model.Produse;
import com.aplicatie.magazinbio.model.Recenzie;
import com.aplicatie.magazinbio.model.Reducere;
import com.aplicatie.magazinbio.service.ServiceProduse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "/products")
public class ControllerProduse {

    @Autowired
    private ServiceProduse serviceProduse;

    @GetMapping(path = "/", produces = "application/json")
    public List<Produse> getProduse() {
        return serviceProduse.getAllProduse();
    }

    @PostMapping(path = "/insert")
    public void insert(@RequestBody(required = false) Produse produs) {

        System.out.println("incerc adaugat produsul ");
        System.out.println(produs.toString());
        serviceProduse.insert(produs);
        System.out.println("am adaugat produsul ");
    }

    @GetMapping(path = "/find", produces = "application/json")
    public Produse findProduct(@RequestParam(value = "idprodus") Integer idprodus) throws ExceptionNotFound {


        return serviceProduse.findProduct(idprodus);
    }

    @PostMapping(path = "/cart/insert")
    public void insertCart(@RequestBody(required = false) CartProducts produsCos) {


        System.out.println(produsCos.toString());
        serviceProduse.insertCart(produsCos);
        System.out.println("am adaugat produsul ");
    }

    @GetMapping(path = "/cart/get", produces = "application/json")
    public List<CartProducts> getCart() throws ExceptionNotFound {


        return serviceProduse.getCart();
    }

    @PostMapping(path = "/cart/buy")
    public void buyProductsFromCart(@RequestParam(name = "mail") String mail, @RequestParam(name = "tip") String tip) throws ExceptionInvalidQuantity {


        serviceProduse.buyProductsFromCart(mail, tip);
        System.out.println("am adaugat produsul ");
    }

    @DeleteMapping(path = "/cart/delete/{id}")
    public void deleteProductFromCart(@PathVariable("id") int id) {
        System.out.println("incerc sa sterg");
        serviceProduse.deleteProductFromCart(id);
    }

    @GetMapping(path = "/top10", produces = "application/json")
    public List<Produse> getTop10Products() throws ExceptionNotFound {

        System.out.println("iau imagini");
        return serviceProduse.getTop10Products();
    }


    @GetMapping(path = "/mine", produces = "application/json")
    public List<Produse> getAllMyProducts(@RequestParam(name = "mail") String mail) throws ExceptionNotFound {

        System.out.println("iau produsele mele");
        return serviceProduse.getAllMyroducts(mail);
    }

    @PostMapping(path = "/set/discount", produces = "application/json")
    public void setDiscount(@RequestBody(required = false) Reducere reducere) {

        System.out.println("pun reducerile mele");
        serviceProduse.setDiscount(reducere);
    }

    @PostMapping(path = "/set/star", produces = "application/json")
    public void setDiscount(@RequestParam(name = "starvalue") Integer starvalue, @RequestParam(name = "idprodus") Integer idprodus, @RequestParam("mail") String mail) {

        System.out.println("pun stelele mele");
        serviceProduse.setStars(starvalue, idprodus, mail);
    }

    @GetMapping(path = "/get/rating", produces = "application/json")
    public Recenzie getRating(@RequestParam(name = "idprodus") Integer idprodus) {

        System.out.println("iau recenzia mele");
        return serviceProduse.getRating(idprodus);
    }

    @GetMapping(path = "/get/discount", produces = "application/json")
    public Reducere getDiscount(@RequestParam(name = "idprodus") Integer idprodus) {

        System.out.println("iau recenzia mele");
        return serviceProduse.getDiscount(idprodus);
    }

}
