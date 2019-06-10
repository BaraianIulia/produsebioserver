package com.aplicatie.magazinbio.service;

import com.aplicatie.magazinbio.exception.ExceptionAlreadyExists;
import com.aplicatie.magazinbio.exception.ExceptionIncorrectInput;
import com.aplicatie.magazinbio.exception.ExceptionNotFound;
import com.aplicatie.magazinbio.model.*;
import com.aplicatie.magazinbio.repository.RepositoryCard;
import com.aplicatie.magazinbio.repository.RepositoryClient;
import com.aplicatie.magazinbio.repository.RepositoryFurnizor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.rowset.serial.SerialBlob;
import java.nio.charset.StandardCharsets;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@Service
public class ServiceClienti {
    @Autowired
    private RepositoryClient repositoryClient;
    @Autowired
    private RepositoryCard repositoryCard;

    public List<Client> getAllClienti() {

        return repositoryClient.findAll();
    }

    public Client login(String mail, String parola) throws ExceptionNotFound, SQLException {

        Client client = repositoryClient.findClientByMailAndParola(mail, parola);
        System.out.println("am luat client");
        if (client == null) {
            System.out.println("exceptie");
            throw new ExceptionNotFound("Mail sau parola incorecta");
        }
        System.out.println("client");


        System.out.println(client.toString());
        client.setParola(null);
        String str = new String(client.getFileToUpload(), StandardCharsets.UTF_8);
        client.setPoza(str);
        System.out.println(str);
        return client;
    }

    public void register(RegisterData registerData) throws ExceptionAlreadyExists, SQLException {

        System.out.println(repositoryClient.findClientByMail(registerData.getMail()));
        if (repositoryClient.findClientByMail(registerData.getMail()) != null) {
            throw new ExceptionAlreadyExists("Acest mail este deja folosit.");
        }
        System.out.println("adaug card");
        Card card = new Card(registerData.getCard().getNumar(), registerData.getCard().getDataexpirare(), registerData.getCard().getCvvcod());

        repositoryCard.save(card);
        System.out.println(repositoryCard.findIdCardByNumarAndDataexpirareAndCvvcod(registerData.getCard().getNumar(), registerData.getCard().getDataexpirare(), registerData.getCard().getCvvcod()));

        System.out.println("blob");
        byte[] byteImg = registerData.getFileToUpload().getBytes();
        String str = new String(byteImg, StandardCharsets.UTF_8);
        System.out.println(str);
        System.out.println("gata blob");
        Client client = new Client(registerData.getNume(), registerData.getPrenume(), registerData.getDatanasterii(), registerData.getMail(), registerData.getParola(),
                registerData.getTelefon(), registerData.getAdresa(),
                repositoryCard.findIdCardByNumarAndDataexpirareAndCvvcod(registerData.getCard().getNumar(), registerData.getCard().getDataexpirare(), registerData.getCard().getCvvcod()),
                registerData.getPuncte(), byteImg);
        repositoryClient.save(client);
    }


    public Client editData(EditData editData) throws ExceptionNotFound, ExceptionAlreadyExists {
        Client client;
        if (editData.getParolaVeche().equals("")) {
            client = repositoryClient.findClientByMail(editData.getMail());
        } else {
            client = repositoryClient.findClientByMailAndParola(editData.getMail(), editData.getParolaVeche());
        }
        if (repositoryClient.findClientByMailAndTelefon(editData.getMail(), editData.getTelefon()) != null) {
            throw new ExceptionAlreadyExists("Alt utilizator deține acest număr de telefon.");
        }

        if (client == null) {
            throw new ExceptionNotFound("Parola incorectă.");
        }
        if (!editData.getPrenume().equals("")) {
            client.setPrenume(editData.getPrenume());
        }
        if (!editData.getTelefon().equals("")) {
            client.setTelefon(editData.getTelefon());
        }
        if (!editData.getAdresa().equals("")) {
            client.setAdresa(editData.getAdresa());
        }
        if (editData.getFileToUpload() != null) {
            client.setFileToUpload(editData.getFileToUpload().getBytes());
            client.setPoza(editData.getFileToUpload());
        }
        if (!editData.getParolaNoua().equals("")) {
            client.setParola(editData.getParolaNoua());
        }
        repositoryClient.save(client);
        return client;
    }

    public void editCard(Card card, String mail) {
        Client client = repositoryClient.findClientByMail(mail);
        Card card1 = new Card();
        card1.setIdcard(client.getIdcard());
        card1.setNumar(card.getNumar());
        card1.setDataexpirare(card.getDataexpirare());
        card1.setCvvcod(card.getCvvcod());
        repositoryCard.save(card1);
    }

    public Card viewCard(String mail) {
        Client client = repositoryClient.findClientByMail(mail);
        String numar = repositoryCard.findNumarByIdcard(client.getIdcard());
        String dataexpirare = repositoryCard.findDataexpirareByIdcard(client.getIdcard());
        Card card1 = new Card();
        card1.setNumar(numar);
        card1.setDataexpirare(dataexpirare);
        System.out.println(card1.toString());
        return card1;
    }
}

