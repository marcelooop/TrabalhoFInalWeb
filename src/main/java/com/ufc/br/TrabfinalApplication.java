package com.ufc.br;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class TrabfinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrabfinalApplication.class, args);
		System.out.println("Password: "+new BCryptPasswordEncoder().encode("123"));
	}
}

