package com.example.proiectfinal.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class User {
    private int id;
    private String username;
    private String email;
    private String password;

    public User() {
        //constructor necesar pt serializare/deserializare
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
