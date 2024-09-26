package com.curso.erudio.rest_spring_aws.controllers;

import com.curso.erudio.rest_spring_aws.data.vo.v1.AccountCredentialsVO;
import com.curso.erudio.rest_spring_aws.services.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Authentication endpoint")
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @Operation(summary = "Authenticates a user and returns a token")
    @PostMapping(value = "/signin")
    public ResponseEntity signin(@RequestBody AccountCredentialsVO data) {

        if (checkIfParamsIsNull(data))
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid client request!");

        var token = authService.signin(data);
        if (token == null)
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid");

        return token;
    }

    private boolean checkIfParamsIsNull(AccountCredentialsVO data) {
        return (data == null || data.getUsername() == null
                || data.getUsername().isBlank() || data.getPassword() == null || data.getPassword().isBlank());
    }

}