package com.honorius.crud_postgres.persona;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/personas")
public class ControllerPersona {
    private final ServicePersona servicePersona;

    @Autowired
    public ControllerPersona(ServicePersona servicePersona) {
        this.servicePersona = servicePersona;
    }
    @GetMapping
    public List<Persona> getPersonaList() {
        return servicePersona.getPersonaList();
    }

    @PostMapping
    public ResponseEntity<Object> addPersona(@RequestBody Persona persona) {
        return servicePersona.addPersona(persona);
    }

    @PutMapping
    public ResponseEntity<Object> updatePersona(@RequestBody Persona persona) {
        return servicePersona.updateProducto(persona);
    }
}
