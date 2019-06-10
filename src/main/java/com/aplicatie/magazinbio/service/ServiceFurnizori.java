package com.aplicatie.magazinbio.service;

import com.aplicatie.magazinbio.exception.ExceptionAlreadyExists;
import com.aplicatie.magazinbio.exception.ExceptionNotFound;
import com.aplicatie.magazinbio.model.Client;
import com.aplicatie.magazinbio.model.EditData;
import com.aplicatie.magazinbio.model.Furnizor;
import com.aplicatie.magazinbio.model.RegisterData;
import com.aplicatie.magazinbio.repository.RepositoryFurnizor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.List;

@Service
public class ServiceFurnizori {
    @Autowired
    private RepositoryFurnizor repositoryFurnizor;

    public List<Furnizor> getAllFurnizori() {

        List<Furnizor> furnizori= repositoryFurnizor.findAll();
        for(Furnizor furnizor: furnizori){
            String str = new String(furnizor.getFileToUpload(), StandardCharsets.UTF_8);

            furnizor.setPoza(str);
        }
        return furnizori;
    }

    public Furnizor login(String mail, String parola) throws ExceptionNotFound {

        Furnizor furnizor = repositoryFurnizor.findFurnizorByMailAndParola(mail, parola);
        if (furnizor == null) {
            System.out.println("exceptie");
            throw new ExceptionNotFound("Mail sau parola incorecta");
        }
        System.out.println(furnizor.toString());
        System.out.println("furnizor");
        String str = new String(furnizor.getFileToUpload(), StandardCharsets.UTF_8);
        furnizor.setParola(null);
        furnizor.setPoza(str);
        return furnizor;
    }

    public void register(RegisterData registerData) throws ExceptionAlreadyExists, SQLException, IOException {
        System.out.println(repositoryFurnizor.findFurnizorByMail(registerData.getMail()));
        if (repositoryFurnizor.findFurnizorByMail(registerData.getMail()) != null) {
            throw new ExceptionAlreadyExists("Acest mail este deja folosit.");
        }

        byte[] byteImg = registerData.getFileToUpload().getBytes();
        Furnizor furnizor = new Furnizor(registerData.getNume(), registerData.getPrenume(), registerData.getDatanasterii(), registerData.getMail(), registerData.getParola(),
                registerData.getTelefon(), registerData.getAdresa(), registerData.getCodiban(), registerData.getDescriere(),
                registerData.getPuncte(), byteImg);
        System.out.println("furnizorul este");
        System.out.println(furnizor);
        repositoryFurnizor.save(furnizor);

    }

    public Furnizor editData(EditData editData) throws ExceptionNotFound, ExceptionAlreadyExists {
        Furnizor furnizor;
        if(editData.getParolaVeche().equals("")){
            furnizor= repositoryFurnizor.findFurnizorByMail(editData.getMail());
        }else{
            furnizor= repositoryFurnizor.findFurnizorByMailAndParola(editData.getMail(),editData.getParolaVeche());
        }
        if(repositoryFurnizor.findFurnizorByMailAndTelefon(editData.getMail(),editData.getTelefon())!= null){
            throw new ExceptionAlreadyExists("Alt utilizator deține acest număr de telefon.");
        }

        if(furnizor == null){
            throw  new ExceptionNotFound("Parola incorectă.");
        }
        if(!editData.getPrenume().equals("")){
            furnizor.setPrenume(editData.getPrenume());
        }
        if(!editData.getTelefon().equals("")){
            furnizor.setTelefon(editData.getTelefon());
        }
        if(!editData.getAdresa().equals("")){
            furnizor.setAdresa(editData.getAdresa());
        }
        if(!editData.getDescriere().equals("")){
            furnizor.setDescriere(editData.getDescriere());
        }
        if(editData.getFileToUpload() != null){
            furnizor.setFileToUpload(editData.getFileToUpload().getBytes());
            furnizor.setPoza(editData.getFileToUpload());
        }
        if(!editData.getParolaNoua().equals("")){
            furnizor.setParola(editData.getParolaNoua());
        }
        repositoryFurnizor.save(furnizor);
        return furnizor;
    }

    public void editCodIBAN(String codIBAN, String mail) {
        Furnizor furnizor= repositoryFurnizor.findFurnizorByMail(mail);
        furnizor.setCodiban(codIBAN);
        repositoryFurnizor.save(furnizor);
    }

    public String viewCodIBAN(String mail) {
        Furnizor furnizor= repositoryFurnizor.findFurnizorByMail(mail);

        return furnizor.getCodiban();
    }
}
