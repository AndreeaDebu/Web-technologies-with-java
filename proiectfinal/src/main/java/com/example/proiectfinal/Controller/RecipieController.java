package com.example.proiectfinal.Controller;

import com.example.proiectfinal.Model.IngredientRecipie;
import com.example.proiectfinal.Repository.RecipieRepository;
import com.example.proiectfinal.Service.RecipieService;;
import com.example.proiectfinal.dto.RecipieDto;
import com.example.proiectfinal.exception.NoIngredientFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/recipie")
public class RecipieController {
    private final RecipieService recipieService;
    private final RecipieRepository recipieRepository;

    public RecipieController(RecipieService recipieService, RecipieRepository recipieRepository) {
        this.recipieService = recipieService;
        this.recipieRepository = recipieRepository;
    }

    @PostMapping("/create")
    public ResponseEntity create(@RequestBody List<IngredientRecipie> ingredientRecipies, @RequestParam String recipieName){
        RecipieDto recipieDto = recipieService.save(ingredientRecipies, recipieName);
        return ResponseEntity.ok(recipieDto);
    }

    @GetMapping("/getByName")
    public ResponseEntity getIngredientByUserId(@RequestParam  String name) {
        try {
            return ResponseEntity.ok(recipieRepository.getRecipieByName(name));
        } catch (NoIngredientFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

   /* public void createad(@RequestBody List<IngredientRecipie> items) {
        try {
            return ResponseEntity.ok(recipieService.save(items));
        } catch (NoRecipieFoundException | NoStockAvailableException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }*/
}
