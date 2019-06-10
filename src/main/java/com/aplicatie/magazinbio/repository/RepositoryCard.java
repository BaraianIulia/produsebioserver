package com.aplicatie.magazinbio.repository;

import com.aplicatie.magazinbio.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface RepositoryCard extends JpaRepository<Card, Integer> {

    @Query(value = "SELECT c.idcard FROM Card c WHERE c.numar = ?1 and c.dataexpirare = ?2 and c.cvvcod = ?3")
    Integer findIdCardByNumarAndDataexpirareAndCvvcod(String numar, String dataexpirare, String cvvcod);
    @Query(value = "SELECT c.numar FROM Card c WHERE c.idcard = ?1")
    String findNumarByIdcard(Integer idcard);
    @Query(value = "SELECT c.dataexpirare FROM Card c WHERE c.idcard = ?1")
    String findDataexpirareByIdcard(Integer idcard);

}
