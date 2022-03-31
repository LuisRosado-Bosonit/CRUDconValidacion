package com.example.App.infraestructure.controller.dto.output;

import com.example.App.domain.Persona;
import com.example.App.domain.Profesor;
import com.example.App.domain.Student;
import lombok.Data;

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
