package com.example.proiectfinal.Repository;


import com.example.proiectfinal.Model.Ingredient;
import com.example.proiectfinal.Model.Recipie;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

@Repository
public class RecipieRepository {

    private final JdbcTemplate jdbcTemplate;

    public RecipieRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public long save(Recipie recipie) {

        KeyHolder keyHolder = new GeneratedKeyHolder();
        String insertSql = "INSERT INTO recipie VALUES(NULL, ?, ?)";

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(insertSql, new String[]{"id"});
            ps.setString(1, recipie.getName());
            ps.setString(2, recipie.getCreateDate());
            return ps;
        }, keyHolder);

        return (long) keyHolder.getKey().longValue();
        //jdbcTemplate.update(insertSql, recipie.getName(), recipie.getCreateDate());
    }

    public Optional<Recipie> getRecipieByName(String name) {
        String sql = "SELECT * FROM recipie WHERE namerecipie = ?";
        try {
            Recipie recipie = jdbcTemplate.queryForObject(sql, new RowMapper<Recipie>() {
                @Override
                public Recipie mapRow(ResultSet resultSet, int i) throws SQLException {
                    Recipie r = new Recipie();
                    r.setId(resultSet.getInt("idrecipie"));
                    r.setName(resultSet.getString("namerecipie"));
                    r.setCreateDate(resultSet.getString("createdate"));
                    return r;
                }
            }, name);
            return Optional.of(recipie);

        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }

    }

    //optional pt ca exista posibilitatea sa existe sau sa nu existe
   /* public Optional<Recipie> getAllRecipie() {
        String sql = "SELECT * FROM recipie";
        try {
            Recipie product = jdbcTemplate.queryForObject(sql, new RowMapper<Recipie>() {
                @Override
                public Recipie mapRow(ResultSet resultSet, int i) throws SQLException {
                    Recipie r = new Recipie();
                    r.setId(resultSet.getInt("id"));
                    r.setName(resultSet.getString("name"));
                    r.setCreateDate(resultSet.getDate("createDate"));
                    return r;
                }
            });
            return Optional.of(product);

        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }

    }*/

}
