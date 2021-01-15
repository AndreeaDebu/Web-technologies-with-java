package com.example.proiectfinal.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;

@Getter
@Setter
public class IngredientRecipieDto {
    @Size(min = 1, max = 20)
    private String name;
    private int quantity;
}
