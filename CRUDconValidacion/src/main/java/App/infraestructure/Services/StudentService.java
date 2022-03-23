package App.infraestructure.Services;

import App.domain.Student;

public interface StudentService{
    public Student findByID(String ID);
    public void addStudent(Student estudiante);
}
