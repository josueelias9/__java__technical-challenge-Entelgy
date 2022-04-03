package com.entelgy.retotecnico;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class EmployeeController {

    // Aggregate root
    // tag::get-aggregate-root[]

    @GetMapping("/hola")
    String hola() {
        return "hola manooo";
    }

    @PostMapping("/hola")
    String newEmployee(@RequestBody String mi_input) {
        return mi_input;
    }

}