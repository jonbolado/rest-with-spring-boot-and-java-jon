package com.curso.erudio.rest_spring_aws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class RestSpringAwsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestSpringAwsApplication.class, args);

		/*Map<String, PasswordEncoder> encoders = new HashMap<>();
		encoders.put("pbkdf2", Pbkdf2PasswordEncoder.defaultsForSpringSecurity_v5_8());

		DelegatingPasswordEncoder delegatingPasswordEncoder = new DelegatingPasswordEncoder("pbkdf2", encoders);
		delegatingPasswordEncoder.setDefaultPasswordEncoderForMatches(Pbkdf2PasswordEncoder.defaultsForSpringSecurity_v5_8());

		String result = delegatingPasswordEncoder.encode("admin123");
		System.out.println("senha codificada: " + result);*/

	}

}
