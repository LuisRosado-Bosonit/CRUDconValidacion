package com.example.App.infraestructure.repository;

import com.example.App.domain.Persona;
import com.example.App.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,String> {

    @Query("SELECT persona FROM Student WHERE persona.id_persona = :id")
    public default Persona findPersonaByID(String id) {
        return null;
    }

    //El default este no se para qué vale
}
