package App.infraestructure.Services;

import App.domain.Estudiante_asignatura;
import App.domain.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService{
    public Student findByID(String ID);
    public Student addStudent(Student estudiante);
    public boolean findByPersonaId(String ID);
    public List<Estudiante_asignatura> addAsignaturas(String id,List<String> id_asignaturas);
}
