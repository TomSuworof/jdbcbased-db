package com.dreamteam.jdbcbaseddb.controllers;

import com.dreamteam.jdbcbaseddb.entities.Authentication;
import com.dreamteam.jdbcbaseddb.services.DatabasesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/api/databases")
@CrossOrigin(origins = "http://localhost:8081")
@RequiredArgsConstructor
public class DatabasesController {
    private final DatabasesService databasesService;

    @PostMapping()
    public @ResponseBody ResponseEntity<List<String>> getAllDatabases(@RequestBody Authentication auth) throws SQLException, ClassNotFoundException {
        return ResponseEntity.ok().body(databasesService.getAllDatabases(auth));
    }

    @PostMapping("/switchTo")
    public @ResponseBody void switchToDatabase(@RequestParam String databaseName, @RequestBody Authentication auth) throws SQLException, ClassNotFoundException {
        databasesService.switchToDatabase(databaseName, auth);
    }

    @PostMapping("/add")
    public @ResponseBody void addDatabase(@RequestParam String databaseName, @RequestBody Authentication auth) throws SQLException, ClassNotFoundException {
        databasesService.addDatabase(databaseName, auth);
    }

    @PostMapping("/remove")
    public @ResponseBody boolean removeDatabase(@RequestParam String databaseName, @RequestBody Authentication auth) throws SQLException, ClassNotFoundException {
        return databasesService.deleteDatabase(databaseName, auth);
    }
}
