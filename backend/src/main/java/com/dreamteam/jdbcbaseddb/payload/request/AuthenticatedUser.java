package com.dreamteam.jdbcbaseddb.payload.request;

import com.dreamteam.jdbcbaseddb.entities.Authentication;
import com.dreamteam.jdbcbaseddb.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticatedUser {
    private User user;
    private Authentication authentication;
}
