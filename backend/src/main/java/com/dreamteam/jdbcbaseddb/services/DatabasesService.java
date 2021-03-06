package com.dreamteam.jdbcbaseddb.services;

import com.dreamteam.jdbcbaseddb.entities.Authentication;
import com.dreamteam.jdbcbaseddb.repositories.DatabaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DatabasesService {
    private final DatabaseRepository databaseRepository;

    public List<String> getAllDatabases(Authentication auth) throws SQLException, ClassNotFoundException {
        return databaseRepository.findAll(auth);
    }

    public void switchToDatabase(String database, Authentication auth) throws SQLException, ClassNotFoundException {
        databaseRepository.testConnect(database, auth);
    }

    public void addDatabase(String database, Authentication auth) throws SQLException, ClassNotFoundException {
        databaseRepository.save(database, auth);
    }

    public boolean deleteDatabase(String database, Authentication auth) throws SQLException, ClassNotFoundException {
        return databaseRepository.delete(database, auth);
    }
}
