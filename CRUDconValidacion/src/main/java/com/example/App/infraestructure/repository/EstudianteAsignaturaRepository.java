package com.example.App.infraestructure.repository;

import com.example.App.domain.Estudiante_asignatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteAsignaturaRepository extends JpaRepository<Estudiante_asignatura, String> {

}
