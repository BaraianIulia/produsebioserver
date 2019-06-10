package com.aplicatie.magazinbio.repository;

import com.aplicatie.magazinbio.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryRecipe  extends JpaRepository<Recipe, Integer> {
}
