package com.entelgy.retotecnico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RetoTecnicoApplication {

	public static void main(String[] args) {
		MiTest miTest = new MiTest();
		miTest.test_facade();
		SpringApplication.run(RetoTecnicoApplication.class, args);
	}

}
