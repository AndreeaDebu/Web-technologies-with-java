package com.example.proiectfinal.Repository;


import com.example.proiectfinal.Model.Ingredient;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

@Repository
public class IngredientRepository {
    /*private final List<Ingredient> ingredients;

    public IngredientRepository() {
        ingredients = initialIngredient();
    }

    public Optional<Ingredient> get(String name) {
        return ingredients.stream().filter(product -> product.getName().equals(name)).findFirst();
    }

    private List<Ingredient> initialIngredient() {
        return new ArrayList<>(asList(
                new Ingredient("lapte"), new Ingredient("faina"), new Ingredient("bere")
        ));
    }*/

    private final JdbcTemplate jdbcTemplate;

    public IngredientRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Ingredient ingredient) {
        String sql = "INSERT INTO ingredient VALUES (NULL, ?, ?)";
        jdbcTemplate.update(sql, ingredient.getNameIngredient(), ingredient.getCreateDate());
    }

    public Optional<Ingredient> getIngredientByName(String name) {
        String sql = "SELECT * FROM ingredient WHERE nameIngredient = ?";
        try {
            Ingredient product = jdbcTemplate.queryForObject(sql, new RowMapper<Ingredient>() {
                @Override
                public Ingredient mapRow(ResultSet resultSet, int i) throws SQLException {
                    Ingredient p = new Ingredient();
                    p.setId(resultSet.getInt("id"));
                    p.setNameIngredient(resultSet.getString("nameIngredient"));
                    return p;
                }
            }, name);
            return Optional.of(product);

        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }

    }


    public Optional<Ingredient> getAllIngredient() {
        String sql = "SELECT * FROM ingredient";
        try {
            Ingredient product = jdbcTemplate.queryForObject(sql, new RowMapper<Ingredient>() {
                @Override
                public Ingredient mapRow(ResultSet resultSet, int i) throws SQLException {
                    Ingredient p = new Ingredient();
                    p.setId(resultSet.getInt("id"));
                    p.setNameIngredient(resultSet.getString("nameIngredient"));
                    return p;
                }
            });
            return Optional.of(product);

        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }

    }

    //poti face asta pentru a scadea tin tabela anumite chestii
    /*public void decrementIngrediente(Ingredient ingredient, int quantity){
        String sql = 'UPDATE ingredient'
    }*/

}
