package App.infraestructure.controller.dto.output;

import App.domain.Estudiante_asignatura;
import App.domain.Persona;
import App.domain.Profesor;
import App.domain.Student;
import App.infraestructure.Services.PersonaService;
import App.infraestructure.Services.StudentService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class outputStudentDTOsimple {

    @Autowired
    PersonaService servicioPersona;

    @Autowired
    StudentService servicioStudiante;

    private String id_student;

    //private Persona persona;

    private int num_hours_week;

    private String coments;

    //private Profesor profesor;

    private String Branch;

    private List<Estudiante_asignatura> asignaturas;


    public outputStudentDTOsimple outputStudentDTOsimple(String ID) throws Exception {
        Student estudiante = new Student();
        estudiante = servicioStudiante.findByID(ID);
        if(estudiante == null)throw new Exception("No se ha encontrado ningún estudiante con ese ID");
        this.id_student = estudiante.getId_student();
        this.num_hours_week = estudiante.getNum_hours_week();
        this.coments = estudiante.getComents();
        this.Branch = estudiante.getBranch();
        return this;
    }

}
