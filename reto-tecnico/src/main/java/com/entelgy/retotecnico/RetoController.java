package com.entelgy.retotecnico;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class RetoController {

    // Aggregate root
    // tag::get-aggregate-root[]

    @Value("${mi.direccion}")
    private String direccion;

    @GetMapping("/reto")
    String reto_get() {
        return "se aplico get exitosamente";
   }

    @PostMapping("/reto")
    String reto_post(@RequestBody String requestString) {
        RetoService consum = new RetoService();
        return consum.hola1(direccion,requestString);
    }

}