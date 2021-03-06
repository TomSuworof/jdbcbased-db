package com.dreamteam.jdbcbaseddb.repositories;

import com.dreamteam.jdbcbaseddb.database.PostgresConnectionManager;
import com.dreamteam.jdbcbaseddb.entities.Authentication;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class DatabaseRepositoryImpl implements DatabaseRepository {
    @Override
    public List<String> findAll(Authentication auth) throws SQLException, ClassNotFoundException {
        Connection connection = PostgresConnectionManager.getInstance(auth).getConnection();
        connection.setAutoCommit(false);
        Savepoint savepoint = connection.setSavepoint();

        List<String> databases = new LinkedList<>();

        try {
            PreparedStatement statement = connection.prepareStatement("select * from get_all_databases();");
            ResultSet set = statement.executeQuery();
            connection.commit();

            while (set.next()) {
                databases.add(set.getString("dbname"));
            }

        } catch (SQLException e) {
            connection.rollback(savepoint);
            throw e;
        }

        return databases
                .stream()
                .map(name -> name.substring(5)) // remove 'jdbc_' prefix
                .collect(Collectors.toList());
    }

    @Override
    public void testConnect(String database, Authentication auth) throws SQLException, ClassNotFoundException {
        Connection connection = PostgresConnectionManager.getInstance(auth).getConnection();
        connection.isValid(1000);
    }

    @Override
    public void save(String database, Authentication auth) throws SQLException, ClassNotFoundException {
        Connection connection = PostgresConnectionManager.getInstance(auth).getConnection();
        connection.setAutoCommit(false);
        Savepoint savepoint = connection.setSavepoint();

        try {
            PreparedStatement statement = connection.prepareStatement("select * from create_database(?, ?, ?);");
            statement.setString(1, database);
            statement.setString(2, auth.getUsername());
            statement.setString(3, auth.getPassword());
            statement.execute();
            connection.commit();
        } catch (SQLException e) {
            connection.rollback(savepoint);
            throw e;
        }
    }

    @Override
    public boolean delete(String database, Authentication auth) throws SQLException, ClassNotFoundException {
        Connection connection = PostgresConnectionManager.getInstance(auth).getConnection();
        connection.setAutoCommit(false);
        Savepoint savepoint = connection.setSavepoint();

        try {
            PreparedStatement statement = connection.prepareStatement("select * from delete_database(?, ?, ?);");
            statement.setString(1, database);
            statement.setString(2, auth.getUsername());
            statement.setString(3, auth.getPassword());
            boolean result = statement.execute();
            connection.commit();
            return result;
        } catch (SQLException e) {
            connection.rollback(savepoint);
            throw e;
        }
    }
}
