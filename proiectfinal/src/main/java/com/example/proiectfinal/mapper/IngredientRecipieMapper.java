package com.example.proiectfinal.mapper;

import com.example.proiectfinal.Model.IngredientRecipie;
import com.example.proiectfinal.dto.IngredientRecipieDto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class IngredientRecipieMapper {

    public IngredientRecipieDto toDto(IngredientRecipie ingredientRecipie){
        IngredientRecipieDto ingredientRecipieDto = new IngredientRecipieDto();
        ingredientRecipieDto.setName(ingredientRecipie.getIngredient().getNameIngredient());
        ingredientRecipieDto.setQuantity(ingredientRecipie.getQuantity());

        return ingredientRecipieDto;
    }

}
