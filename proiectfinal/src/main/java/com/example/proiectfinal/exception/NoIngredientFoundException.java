package com.example.proiectfinal.exception;

public class NoIngredientFoundException extends RuntimeException {
    public NoIngredientFoundException() {
        super("No ingredient was found !");
    }
}
