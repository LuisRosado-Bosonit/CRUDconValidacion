package App.infraestructure.controller.dto.output;

import App.domain.Estudiante_asignatura;
import App.domain.Persona;
import App.domain.Profesor;
import App.domain.Student;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class outputStudentDTOfull {



    private String id_student;
    private int num_hours_week;
    private String coments;
    private String Branch;
   // private List<Estudiante_asignatura> asignaturas;          //FIXME
    private Persona person;
    private Profesor profe;

    public outputStudentDTOfull toDTO(Student estudiante){
        this.setId_student(estudiante.getId_student());
        this.setNum_hours_week(estudiante.getNum_hours_week());
        this.setComents(estudiante.getComents());
        this.setBranch(estudiante.getBranch());
        this.setProfe(estudiante.getProfesor());
        this.setPerson(estudiante.getPersona());
        return this;
    }



}
