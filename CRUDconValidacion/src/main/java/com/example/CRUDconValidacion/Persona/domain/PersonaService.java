package com.example.CRUDconValidacion.Persona.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaService extends JpaRepository<Persona, String> {
      public Persona buscarID(int id);
      public Persona buscarUsername(String nombreUsuario);
      public List<Persona> showAll();
}
