package com.example.proiectfinal.exception;

public class NoRecipieFoundException extends RuntimeException {
    public NoRecipieFoundException() {
        super("No recipie was found !");
    }
}
