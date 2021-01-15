package com.example.proiectfinal.Repository;

import com.example.proiectfinal.Model.IngredientRecipie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class IngredientRecipieRepository {
    private final JdbcTemplate jdbcTemplate;

    public IngredientRecipieRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(IngredientRecipie ingredient, int orderId) {
        String sql = "INSERT INTO ingredientrecipie VALUES(NULL, ?, ?, ?)";

        jdbcTemplate.update(sql,
                ingredient.getIngredient().getId(),
                orderId,
                ingredient.getQuantity());
    }
}
