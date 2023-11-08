package com.honorius.crud_postgres.persona;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ServicePersona {
    public List<Persona> getPersonaList() {
        LocalDate fn = LocalDate.of(1989,2,12);
        return List.of(new Persona("Honorius", fn));
    }
}
