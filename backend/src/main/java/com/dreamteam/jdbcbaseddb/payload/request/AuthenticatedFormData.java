package com.dreamteam.jdbcbaseddb.payload.request;

import com.dreamteam.jdbcbaseddb.entities.Authentication;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticatedFormData {
    private MultipartFile formData;
    private Authentication authentication;
}
