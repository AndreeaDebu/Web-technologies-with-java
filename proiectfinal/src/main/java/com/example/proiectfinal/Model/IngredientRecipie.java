package com.example.proiectfinal.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IngredientRecipie {

        private int id;
        private Recipie recipie;
        private Ingredient ingredient;
        private int quantity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Recipie getRecipie() {
        return recipie;
    }

    public void setRecipie(Recipie recipie) {
        this.recipie = recipie;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
