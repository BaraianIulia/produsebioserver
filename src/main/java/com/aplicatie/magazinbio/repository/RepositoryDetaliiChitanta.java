package com.aplicatie.magazinbio.repository;

import com.aplicatie.magazinbio.model.DetaliiChitanta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryDetaliiChitanta extends JpaRepository<DetaliiChitanta, Integer> {
}
