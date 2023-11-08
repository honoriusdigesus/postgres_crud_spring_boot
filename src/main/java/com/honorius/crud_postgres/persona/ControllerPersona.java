package com.honorius.crud_postgres.persona;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
