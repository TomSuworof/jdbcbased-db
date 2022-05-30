package com.dreamteam.jdbcbaseddb.database;

import java.sql.Connection;

public interface ConnectionManager extends AutoCloseable {

    Connection getConnection();
}
