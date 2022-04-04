package com.entelgy.retotecnico;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class EmployeeController {

    // Aggregate root
    // tag::get-aggregate-root[]

    @Value("${mi.direccion}")
    private String direccion;

    @GetMapping("/hola")
    String hola() {
 
        ConsumirURL consum = new ConsumirURL();
        JSONObject hola = consum.facade(direccion);
        System.out.println(hola.toString(4));
        return "hola manooo";
   }

    @PostMapping("/hola")
    String newEmployee(@RequestBody String mi_input) {
        return mi_input;
    }

}