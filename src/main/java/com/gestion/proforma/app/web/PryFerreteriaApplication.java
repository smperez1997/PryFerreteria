package com.gestion.proforma.app.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;




@SpringBootApplication
public class PryFerreteriaApplication implements CommandLineRunner {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(PryFerreteriaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String password = "shirley12345";
		for(int i=0; i<3; i++) {
			String encrypt = passwordEncoder.encode(password);
			System.out.println(encrypt);
		}	
	}
	
	

}
