package com.dreamteam.jdbcbaseddb.controllers;

import com.dreamteam.jdbcbaseddb.entities.Authentication;
import com.dreamteam.jdbcbaseddb.payload.request.AuthenticatedUser;
import com.dreamteam.jdbcbaseddb.services.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@Controller
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:8081")
@RequiredArgsConstructor
public class UsersController {
    private final UsersService usersService;

    @PostMapping("/add")
    public @ResponseBody void addUser(@RequestBody AuthenticatedUser user) throws SQLException, ClassNotFoundException {
        usersService.addUser(user.getUser(), user.getAuthentication());
    }

    @PostMapping("/remove")
    public @ResponseBody void removeUser(@RequestParam String username, @RequestBody Authentication auth) throws SQLException, ClassNotFoundException {
        usersService.removeUser(username, auth);
    }
}
