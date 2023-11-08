package com.honorius.crud_postgres.persona;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class ServicePersona {
    private final RepositoryPersona repositoryPersona;
    HashMap<String, Object> datos;

    @Autowired
    public ServicePersona(RepositoryPersona repositoryPersona) {
        this.repositoryPersona = repositoryPersona;
    }

    public List<Persona> getPersonaList() {
        return this.repositoryPersona.findAll();
    }

    public ResponseEntity<Object> addPersona(@RequestBody Persona persona) {
        Optional<Persona> res = repositoryPersona.findProductByNombre(persona.getNombre());
        datos = new HashMap<>();
        HashMap<String, Object> datos = new HashMap<>();
        if (res.isPresent() && persona.getId() == null) {
            datos.put("ERROR", "No se puede agregar a la persona");
            return new ResponseEntity<>(datos , HttpStatus.CONFLICT);
        }
        repositoryPersona.save(persona);
        datos.put("GUARDAR", "Persona agregada correctamente");
        return new ResponseEntity<>(datos, HttpStatus.CREATED);
    }

    public ResponseEntity<Object> updateProducto(Persona persona) {
        Optional<Persona> res = repositoryPersona.findProductByNombre(persona.getNombre());
        datos = new HashMap<>();

        if(persona.getId() != null && res.isPresent()){
            datos.put("ACTUALIZAR", "Registros actualizados correctamente");
            repositoryPersona.save(persona);
            return new ResponseEntity<>(datos, HttpStatus.CREATED);
        }
        datos.put("ERROR", "No se pudo actualizar el registro de la persona");
        return new ResponseEntity<>(datos ,HttpStatus.CONFLICT);


    }
}
