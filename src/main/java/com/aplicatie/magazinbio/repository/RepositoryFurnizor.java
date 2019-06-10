package com.aplicatie.magazinbio.repository;

import com.aplicatie.magazinbio.model.Furnizor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryFurnizor extends JpaRepository<Furnizor, Integer> {

    @Override
    List<Furnizor> findAll();

    @Query("SELECT u FROM Furnizor u WHERE u.mail = ?1 and u.parola = ?2")
    Furnizor findFurnizorByMailAndParola(String mail, String parola);

    @Query("SELECT u from Furnizor u WHERE u.mail = ?1")
    Furnizor findFurnizorByMail(String mail);

    @Query("SELECT u FROM Furnizor u WHERE u.mail = ?1 and u.telefon = ?2")
    Furnizor findFurnizorByMailAndTelefon(String mail, String relefon);

}
