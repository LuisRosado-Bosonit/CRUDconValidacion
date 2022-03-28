package App.infraestructure.Services;

import App.domain.Student;

import java.util.Optional;

public interface StudentService{
    public Student findByID(String ID);
    public Student addStudent(Student estudiante);
    public boolean findByPersonaId(String ID);
}
