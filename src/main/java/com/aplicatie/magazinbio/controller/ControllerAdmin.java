package com.aplicatie.magazinbio.controller;


import com.aplicatie.magazinbio.exception.ExceptionNotFound;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/admin")
public class ControllerAdmin {


    private String mail = "admin@yahoo.com";
    private String parola = "admin";

    @PostMapping(path = "/login", produces = "application/json")
    public void login(@RequestParam(value = "mail") String mail, @RequestParam(value = "parola") String parola) throws ExceptionNotFound {

        if (!mail.equals(this.mail) || !parola.equals(this.parola)) {
            throw new ExceptionNotFound("Adresă de mail sau parola incorectă.");
        }
    }
}

