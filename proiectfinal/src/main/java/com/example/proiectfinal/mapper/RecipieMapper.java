package com.example.proiectfinal.mapper;

import com.example.proiectfinal.Model.Ingredient;
import com.example.proiectfinal.Model.IngredientRecipie;
import com.example.proiectfinal.Model.Recipie;
import com.example.proiectfinal.dto.IngredientRecipieDto;
import com.example.proiectfinal.dto.RecipieDto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Setter
@Getter
@Component
public class RecipieMapper {

    @Autowired
    private IngredientRecipieMapper ingredientRecipieMapper;

    public RecipieDto recipieDto(Recipie recipie, List<IngredientRecipie> ingredientRecipies){

        RecipieDto recipieDto = new RecipieDto();
        recipieDto.setName(recipie.getName());

        List<IngredientRecipieDto> ingredientRecipieDtos = ingredientRecipies.stream()
                .map(r -> ingredientRecipieMapper.toDto(r))
                .collect(Collectors.toList());

        recipieDto.setIngredients(ingredientRecipieDtos);

        return recipieDto;
    }
}
