package com.aplicatie.magazinbio.controller;

import com.aplicatie.magazinbio.exception.ExceptionAlreadyExists;
import com.aplicatie.magazinbio.exception.ExceptionIncorrectInput;
import com.aplicatie.magazinbio.exception.ExceptionNotFound;
import com.aplicatie.magazinbio.model.Client;
import com.aplicatie.magazinbio.model.EditData;
import com.aplicatie.magazinbio.model.Furnizor;
import com.aplicatie.magazinbio.model.RegisterData;
import com.aplicatie.magazinbio.service.ServiceFurnizori;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Queue;

@RestController
@RequestMapping(path = "/furnizori")
public class ControllerFurnizori {
    @Autowired
    private ServiceFurnizori serviceFurnizori;


    @GetMapping(path = "/", produces = "application/json")
    public List<Furnizor> getFurnizori() {
        return serviceFurnizori.getAllFurnizori();
    }

    @PostMapping(path = "/login", produces = "application/json")
    public Furnizor login(@RequestParam(value = "mail") String mail, @RequestParam(value = "parola") String parola) throws ExceptionNotFound {
        try {

            return serviceFurnizori.login(mail, parola);
        } catch (ExceptionNotFound e) {
            throw new ExceptionNotFound(e.getMessage());
        }


    }

    @PostMapping(path = "/register", produces = "application/json")
    public void register(@RequestBody(required = false) RegisterData registerData) throws ExceptionAlreadyExists {


        System.out.println(registerData.toString());
        try {
            serviceFurnizori.register(registerData);
            System.out.println("nu err??");
        } catch (ExceptionAlreadyExists e) {
            System.out.println("err?");
            throw new ExceptionAlreadyExists(e.getMessage());
        } catch (SQLException e) {
            System.out.println("err??");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @PostMapping(path = "/editprofile", produces = "application/json")
    public Furnizor editData(@RequestBody(required = false) EditData editData) throws ExceptionNotFound, ExceptionAlreadyExists {

        Furnizor furnizor = serviceFurnizori.editData(editData);

        System.out.println(furnizor.toString());
        return furnizor;
    }
    @PostMapping(path = "/editcodiban", produces = "application/json")
    public void editCodIBAN(@RequestParam(value = "codiban") String codIBAN,  @RequestParam(value = "mail") String mail) throws ExceptionNotFound, ExceptionAlreadyExists {

      serviceFurnizori.editCodIBAN(codIBAN,mail);
    }
    @PostMapping(path = "/viewcodiban", produces = "application/json")
    public Furnizor viewCodIBAN(@RequestParam(value = "mail") String mail) throws ExceptionNotFound, ExceptionAlreadyExists {


        System.out.println(mail);
        String codIBAN = serviceFurnizori.viewCodIBAN(mail);
        System.out.println(codIBAN);
        Furnizor furnizor = new Furnizor();
        furnizor.setCodiban(codIBAN);
        return furnizor;
    }



}
