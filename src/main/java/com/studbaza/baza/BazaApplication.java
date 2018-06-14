package com.studbaza.baza;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class BazaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BazaApplication.class, args);
	}

}
