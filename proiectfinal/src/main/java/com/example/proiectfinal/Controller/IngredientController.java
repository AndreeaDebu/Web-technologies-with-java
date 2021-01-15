package com.example.proiectfinal.Controller;


import com.example.proiectfinal.Model.Ingredient;
import com.example.proiectfinal.Repository.IngredientRepository;
import com.example.proiectfinal.Service.IngredientService;
import com.example.proiectfinal.exception.NoIngredientFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/ingredient")
public class IngredientController {
    private final IngredientService ingredientService;
    private final IngredientRepository ingredientRepository;

    public IngredientController(IngredientService ingredientService, IngredientRepository ingredientRepository) {
        this.ingredientService = ingredientService;
        this.ingredientRepository = ingredientRepository;
    }


    @PostMapping("/add")
    public void addIngredients(@RequestBody List<Ingredient> ingredients) {
        ingredientService.saveIngredients(ingredients);
    }

    @GetMapping("/getByName")
    public ResponseEntity getIngredientByUserId(@RequestParam  String name) {
        try {
            return ResponseEntity.ok(ingredientRepository.getIngredientByName(name));
        } catch (NoIngredientFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }



}
