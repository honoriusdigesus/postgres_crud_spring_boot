package com.honorius.crud_postgres.persona;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepositoryPersona extends JpaRepository<Persona, Long> {
    Optional<Persona> findProductByNombre(String name);
}
