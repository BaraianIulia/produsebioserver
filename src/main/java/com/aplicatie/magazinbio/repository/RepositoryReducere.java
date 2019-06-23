package com.aplicatie.magazinbio.repository;

import com.aplicatie.magazinbio.model.Reducere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface RepositoryReducere extends JpaRepository<Reducere, Integer> {

    @Query("SELECT r from Reducere r WHERE r.idprodus = ?1 and r.dataStart<= ?2 and r.dataFinal>= ?2")
    Reducere getReducereByIdProdusAndDate(Integer idprodus, Date date);

    @Query("SELECT r from Reducere r WHERE r.idprodus = ?1 and ((r.dataStart<= ?2 and r.dataFinal>= ?3) or (r.dataStart>= ?2 and r.dataFinal>= ?3) or (r.dataStart<= ?2 and r.dataFinal<=?3) or (r.dataStart>= ?2 and r.dataFinal<= ?3))")
    List<Reducere> getReducereByIdProdusAndDates(Integer produse, Date dataStart, Date dataFinal);
}
