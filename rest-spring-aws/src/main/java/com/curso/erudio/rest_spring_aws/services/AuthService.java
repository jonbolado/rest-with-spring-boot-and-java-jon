package com.curso.erudio.rest_spring_aws.services;

import com.curso.erudio.rest_spring_aws.config.JwtTokenProvider;
import com.curso.erudio.rest_spring_aws.data.vo.v1.AccountCredentialsVO;
import com.curso.erudio.rest_spring_aws.data.vo.v1.TokenVO;
import com.curso.erudio.rest_spring_aws.model.User;
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

    public ResponseEntity<TokenVO> signin(AccountCredentialsVO accountCredentialsVO) {

        var username = accountCredentialsVO.getUsername();
        var password = accountCredentialsVO.getPassword();

        var authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        var user = (User) authentication.getPrincipal();

        /*var user = userRepository.findByUsername(username);
        user.orElseThrow(() -> new UsernameNotFoundException("Username " + username + " not found!"));*/
        /*if (user == null) {
            throw new UsernameNotFoundException("Username " + username + " not found!");
        }*/

        var tokenResponse = new TokenVO();
        //tokenResponse = tokenProvider.createAccessToken(user.get().getUsername(), user.get().getRoles());
        tokenResponse = tokenProvider.createAccessToken(user.getUsername(), user.getRoles());

        return ResponseEntity.ok(tokenResponse);

    }

}