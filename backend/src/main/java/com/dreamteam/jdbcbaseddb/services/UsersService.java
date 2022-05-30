package com.dreamteam.jdbcbaseddb.services;

import com.dreamteam.jdbcbaseddb.entities.Authentication;
import com.dreamteam.jdbcbaseddb.entities.User;
import com.dreamteam.jdbcbaseddb.exceptions.DuplicatedUserException;
import com.dreamteam.jdbcbaseddb.exceptions.UserNotFoundException;
import com.dreamteam.jdbcbaseddb.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
@RequiredArgsConstructor
public class UsersService {
    private final UserRepository userRepository;

    public void addUser(User user, Authentication auth) throws SQLException, ClassNotFoundException {
        if (userRepository.existsByUsername(user.getUsername(), auth)) {
            throw new DuplicatedUserException();
        }
        userRepository.save(user, auth);
    }

    public void removeUser(String username, Authentication auth) throws SQLException, ClassNotFoundException {
        if (!userRepository.existsByUsername(username, auth)) {
            throw new UserNotFoundException();
        }
    }
}
