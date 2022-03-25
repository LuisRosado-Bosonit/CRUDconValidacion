package App.infraestructure.controller.dto.output;

import App.domain.Estudiante_asignatura;
import App.domain.Persona;
import App.domain.Profesor;
import App.domain.Student;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class outputStudentDTOsimple {

    private String id_student;
    private int num_hours_week;
    private String coments;
    private String Branch;

    public outputStudentDTOsimple toDTO(Student estudiante){
        id_student = estudiante.getId_student();
        num_hours_week = estudiante.getNum_hours_week();
        coments = estudiante.getComents();
        Branch = estudiante.getBranch();
        return this;
    }
}
