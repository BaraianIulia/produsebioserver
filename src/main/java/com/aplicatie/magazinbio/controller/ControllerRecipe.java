package com.aplicatie.magazinbio.controller;

import com.aplicatie.magazinbio.exception.ExceptionNotFound;
import com.aplicatie.magazinbio.model.Recipe;
import com.aplicatie.magazinbio.model.RegisterData;
import com.aplicatie.magazinbio.service.ServiceRecipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/recipe")
public class ControllerRecipe {
    @Autowired
    private ServiceRecipe serviceRecipe;

    @GetMapping(path = "/", produces = "application/json")
    public List<Recipe> getRecipe() {
        return serviceRecipe.getAllRecipe();
    }

    @PostMapping(path = "/add", produces = "application/json")
    public void addRecipe(@RequestBody(required = false) Recipe recipe) {
        System.out.println(recipe.toString());
        serviceRecipe.add(recipe);

    }
    @GetMapping(path = "/find", produces = "application/json")
    public Recipe findRecipe(@RequestParam(value = "idrecipe") Integer idrecipe) throws ExceptionNotFound {


        return serviceRecipe.findRecipe(idrecipe);
    }
}
