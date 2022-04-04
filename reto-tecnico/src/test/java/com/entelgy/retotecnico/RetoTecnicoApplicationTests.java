package com.entelgy.retotecnico;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RetoTecnicoApplicationTests {


	@Autowired
	private RetoService retoService;
	
	//@Test
	void contextLoads() {
	}

	@Test
	void aplaaaa(){
		int a = retoService.mi_funcion();
		assertEquals(a, 3);

	}

}
