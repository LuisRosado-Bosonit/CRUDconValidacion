package com.example.App.infraestructure.Services;

import com.example.App.domain.Estudiante_asignatura;
import com.example.App.domain.Student;

import java.util.List;

public interface StudentService{
    public Student findByID(String ID);
    public Student addStudent(Student estudiante);
    public boolean findByPersonaId(String ID);
    public List<Estudiante_asignatura> addAsignaturas(String id, List<String> id_asignaturas);

    boolean removeAsignaturas(String id,List<String> id_asignaturas);
}
