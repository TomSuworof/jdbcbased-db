package com.dreamteam.jdbcbaseddb.repositories;

import com.dreamteam.jdbcbaseddb.entities.Authentication;
import com.dreamteam.jdbcbaseddb.entities.User;

import java.sql.SQLException;

public interface UserRepository {
    void save(User user, Authentication auth) throws SQLException, ClassNotFoundException;

    boolean existsByUsername(String username, Authentication auth) throws SQLException, ClassNotFoundException;
}
