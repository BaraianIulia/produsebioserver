package com.aplicatie.magazinbio.controller;

import com.aplicatie.magazinbio.exception.ExceptionAlreadyExists;
import com.aplicatie.magazinbio.exception.ExceptionNotFound;
import com.aplicatie.magazinbio.model.Card;
import com.aplicatie.magazinbio.model.Client;
import com.aplicatie.magazinbio.model.EditData;
import com.aplicatie.magazinbio.model.RegisterData;
import com.aplicatie.magazinbio.service.ServiceClienti;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping(path = "/clienti")
public class ControllerClienti {
    @Autowired
    private ServiceClienti serviceClienti;


    @GetMapping(path = "/", produces = "application/json")
    public List<Client> getClienti() {
        return serviceClienti.getAllClienti();
    }




    @PostMapping(path = "/login", produces = "application/json")
    public Client login(@RequestParam(value = "mail") String mail, @RequestParam(value = "parola") String parola) throws ExceptionNotFound {

        try {


            return serviceClienti.login(mail, parola);
        } catch (ExceptionNotFound e) {
            throw new ExceptionNotFound(e.getMessage());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @PostMapping(path = "/register")
    public void register(@RequestBody(required = false) RegisterData registerData) throws ExceptionAlreadyExists {


        System.out.println(registerData.toString());
        try {
            serviceClienti.register(registerData);

        } catch (ExceptionAlreadyExists e) {
            throw new ExceptionAlreadyExists(e.getMessage());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @PostMapping(path = "/editprofile", produces = "application/json")
    public Client editData(@RequestBody(required = false) EditData editData) throws ExceptionNotFound, ExceptionAlreadyExists {

        Client client = serviceClienti.editData(editData);

        System.out.println(client.toString());
        return client;
    }

    @PutMapping(path = "/editcard", produces = "application/json")
    public void editCard(@RequestBody(required = false) Card card, @RequestParam(value = "mail") String mail) {


        serviceClienti.editCard(card, mail);
    }

    @GetMapping(path = "/viewcard", produces = "application/json")
    public Card viewCard(@RequestParam(value = "mail") String mail) {


        return serviceClienti.viewCard(mail);
    }

}
