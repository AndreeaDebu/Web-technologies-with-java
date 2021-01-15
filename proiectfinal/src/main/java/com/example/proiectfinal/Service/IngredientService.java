package com.example.proiectfinal.Service;

import com.example.proiectfinal.Model.Ingredient;
import com.example.proiectfinal.Repository.IngredientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class IngredientService {

    private final IngredientRepository ingredientRepository;

    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Transactional
    //se foloseste in principiu pe serviciu
    //o tranzactie reprezinta (fietoate,fieniciuna,seface rollback),consistenta, variabilitate,conservare
    public void saveIngredients(List<Ingredient> ingredients) {
        //pentru fiecare ingredient il add in BD
        ingredients.forEach(ingredient -> ingredientRepository.save(ingredient));
    }
}
