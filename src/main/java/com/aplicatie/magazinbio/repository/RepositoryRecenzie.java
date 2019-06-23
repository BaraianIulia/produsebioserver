package com.aplicatie.magazinbio.repository;

import com.aplicatie.magazinbio.model.Recenzie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryRecenzie extends JpaRepository<Recenzie, Integer> {

    @Query("select r from Recenzie r where r.idprodus = ?1 and r.autor = ?2")
    Recenzie getRecenzieByIdprodusAndMail(Integer idprodus, String mail);

    @Query("select r from Recenzie r where r.idprodus = ?1")
    List<Recenzie> getRecenzieByIdprodus(Integer idprodus);


    @Query("select r from Recenzie r where r.idprodus = ?1 and r.textRecenzie is not null")
    List<Recenzie> getRecenzieByIdprodusAndNoNullDescription(Integer idprodus);
}
