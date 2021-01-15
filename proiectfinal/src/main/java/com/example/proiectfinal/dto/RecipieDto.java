package com.example.proiectfinal.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;
import java.util.List;

@Setter
@Getter
public class RecipieDto {
    @Size(min = 1, max = 20)
    private String name;
    private List<IngredientRecipieDto> ingredients;
}
