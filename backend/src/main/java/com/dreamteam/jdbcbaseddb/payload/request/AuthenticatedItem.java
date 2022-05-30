package com.dreamteam.jdbcbaseddb.payload.request;

import com.dreamteam.jdbcbaseddb.entities.Authentication;
import com.dreamteam.jdbcbaseddb.entities.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticatedItem {
    private @Valid Item item;
    private Authentication authentication;
}
