package com.aplicatie.magazinbio.repository;

import com.aplicatie.magazinbio.model.Produse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface RepositoryProduse extends JpaRepository<Produse, Integer> {


    @Query("SELECT p FROM Produse p WHERE p.mail = ?1 and p.nume = ?2 and p.zona = ?3 and p.categorie = ?4 and p.dataProducere = ?5 and p.pret = ?6 and p.stoc > 0 ")
    Produse getProductByMailNameZoneCategoryProductiondatePrice(String mail, String nume, String zona, String categorie, Date dataProducere, Float pret);


    @Query("SELECT p from Produse p where  p.stoc > 0 ORDER BY p.dataProducere")
    List<Produse> findProductsOrderByDate();

    @Query("SELECT p from Produse p WHERE p.mail = ?1 and p.stoc > 0 ")
    List<Produse> getProductByMail(String mail);

    @Query("SELECT p FROM Produse p WHere p.categorie = ?1")
    List<Produse> findByCategorie(String categorie);

    @Query("SELECT p FROM Produse p WHERE p.mail = ?1")
    List<Produse> getAllProduseByFurnizor(String mail);
}
