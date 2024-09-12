package com.curso.erudio.rest_spring_aws.services;

import com.curso.erudio.rest_spring_aws.config.JwtTokenProvider;
import com.curso.erudio.rest_spring_aws.data.vo.v1.AccountCredentialsVO;
import com.curso.erudio.rest_spring_aws.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity signin(AccountCredentialsVO accountCredentialsVO) {

        var username = accountCredentialsVO.getUsername();
        var password = accountCredentialsVO.getPassword();

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

        var user = userRepository.findByUsername(username);

        return ResponseEntity.ok().build();

    }

}