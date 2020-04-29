package com.restaurantsProject.project.jwt;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class JWTModel {
    private String username;

    private String password;

}
