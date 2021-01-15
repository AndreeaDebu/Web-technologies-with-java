package com.example.proiectfinal.exception;

public class NoStockAvailableException extends RuntimeException {
    public NoStockAvailableException() {
        super("Quantity is innacceptable!");
    }
}
