package com.example.App.Application.Persona.infraestructure.repository;

import com.example.App.Application.Persona.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> {
      public List<Persona> findByUsuario(String user);
}
