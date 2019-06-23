package com.aplicatie.magazinbio.repository;

import com.aplicatie.magazinbio.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Blob;
import java.util.Date;
import java.util.List;

@Repository
public interface RepositoryClient extends JpaRepository<Client, Integer> {

    @Override
    List<Client> findAll();

    @Query("SELECT u FROM Client u WHERE u.mail = ?1 and u.parola = ?2")
    Client findClientByMailAndParola(String mail, String parola);

    @Query("SELECT u from Client u WHERE u.mail = ?1")
    Client findClientByMail(String mail);

    @Query("SELECT u FROM Client u WHERE u.mail = ?1 and u.telefon = ?2")
    Client findClientByMailAndTelefon(String mail, String telefon);

    @Query("update Client c set c.puncte = c.puncte + 1 where c.mail = ?1")
    void addPoint(String mail);
}
