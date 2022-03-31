package com.example.App.infraestructure.repository;

import com.example.App.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, String> {
      public List<Persona> findByUsuario(String user);
}
