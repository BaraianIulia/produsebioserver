package com.aplicatie.magazinbio.atutomaticTask;


import com.aplicatie.magazinbio.mailSender.EmailController;
import com.aplicatie.magazinbio.model.Client;
import com.aplicatie.magazinbio.model.Furnizor;
import com.aplicatie.magazinbio.repository.RepositoryClient;
import com.aplicatie.magazinbio.repository.RepositoryFurnizor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class EventCreator {

    @Autowired
    RepositoryClient repositoryClient;
    @Autowired
    RepositoryFurnizor repositoryFurnizor;
    @Autowired
    EmailController emailController;

    String bdayText = "Bună ziua! În această zi speciala pentru tine îți dorim La Mulți Ani și îți oferim cadou un punct.";
    String bdaySujbect = "La Mulți Ani";

    @Scheduled(cron = "0 0 12 * * ?")
    public void birthdayBonus() {
        List<Client> clientList = repositoryClient.findAll();
        for (Client client : clientList) {
            if (client.getDatanasterii().equals(new Date())) {
                client.setPuncte(client.getPuncte() + 1);
                try {
                    emailController.sendEmail(client.getMail(), bdayText, bdaySujbect);
                } catch (Exception e) {

                }
            }
        }
        List<Furnizor> furnizorList = repositoryFurnizor.findAll();
        for (Furnizor furnizor : furnizorList) {
            if (furnizor.getDatanasterii().equals(new Date())) {
                furnizor.setPuncte(furnizor.getPuncte() + 1);
                try {
                    emailController.sendEmail(furnizor.getMail(), bdayText, bdaySujbect);
                } catch (Exception e) {

                }
            }
        }
    }

}
