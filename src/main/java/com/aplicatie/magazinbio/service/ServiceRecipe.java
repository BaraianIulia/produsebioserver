package com.aplicatie.magazinbio.service;

import com.aplicatie.magazinbio.exception.ExceptionNotFound;
import com.aplicatie.magazinbio.model.Recipe;
import com.aplicatie.magazinbio.repository.RepositoryRecipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceRecipe {

    @Autowired
    private RepositoryRecipe repositoryRecipe;


    public List<Recipe> getAllRecipe() {
        String str;

        List<Recipe> recipes = repositoryRecipe.findAll();
        for (Recipe p : recipes) {
            if (p.getImagine() != null) {
                str = new String(p.getImagine(), StandardCharsets.UTF_8);
                p.setPoza(str);
            }
            System.out.println(p.toString());
        }
        return recipes;
    }

    public void add(Recipe recipe) {

        byte[] byteImg = recipe.getPoza().getBytes();

        recipe.setImagine(byteImg);

        repositoryRecipe.save(recipe);
    }

    public Recipe findRecipe(Integer idrecipe) throws ExceptionNotFound {
        System.out.println("caut reteta");
        Optional<Recipe> reteta = repositoryRecipe.findById(idrecipe);
        if (!reteta.isPresent()) {
            throw new ExceptionNotFound("Rețetă inexistentă.");
        }
        System.out.println(reteta.get().getNume());
        Recipe recipeFinal = reteta.get();
        String str = new String(recipeFinal.getImagine(), StandardCharsets.UTF_8);

        recipeFinal.setPoza(str);
        return reteta.get();
    }
}
