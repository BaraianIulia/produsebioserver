package com.aplicatie.magazinbio.repository;

import com.aplicatie.magazinbio.model.Chitanta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface RepositoryChitanta extends JpaRepository<Chitanta, Integer> {

    @Query(value = "SELECT c.idchitanta FROM Chitanta c WHERE c.mail = ?1 and c.dataAchizitie = ?2 and c.pretTotal = ?3 and c.tip = ?4")
    Integer getChitantaByMailDateSumType(String mail, Date date, Float sumProductsPrice, String tip);
}

