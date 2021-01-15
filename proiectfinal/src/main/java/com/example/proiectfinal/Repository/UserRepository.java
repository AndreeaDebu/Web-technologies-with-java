package com.example.proiectfinal.Repository;

import com.example.proiectfinal.Model.User;
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
public class UserRepository {

    private final JdbcTemplate jdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(User user) {
        String sql = "INSERT into user VALUES(NULL, ?, ?, ?)";
        jdbcTemplate.update(sql, user.getUsername(), user.getEmail(), user.getPassword());
    }


    public Optional<User> getUserByUserame(String name) {
        String sql = "SELECT * FROM user WHERE username = ?";
        try {
            User user = jdbcTemplate.queryForObject(sql, new RowMapper<User>() {
                @Override
                public User mapRow(ResultSet resultSet, int i) throws SQLException {
                    User u = new User();
                    u.setId(resultSet.getInt("iduser"));
                    u.setUsername(resultSet.getString("username"));
                    u.setPassword(resultSet.getString("password"));
                    return u;
                }
            }, name);
            return Optional.of(user);

        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }

    }


    public Optional<User> getUserById(Integer id) {
        String sql = "SELECT * from user WHERE iduser = ?";
        try {
            User user = jdbcTemplate.queryForObject(sql, (resultSet, i) -> {
                User user1 = new User();
                user1.setId(resultSet.getInt("iduser"));
                user1.setUsername(resultSet.getString("username"));
                user1.setEmail(resultSet.getString("email"));
                user1.setPassword(resultSet.getString("password"));
                return user1;
            }, id);
            return Optional.of(user);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }
}
