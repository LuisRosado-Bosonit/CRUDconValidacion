package App.infraestructure.controller.dto.output;

import App.domain.Estudiante_asignatura;
import App.infraestructure.Services.EstudianteAsignaturaService;
import lombok.Data;

import java.util.Date;

@Data
public class outputEstud_AsigDTO {
    private String id_asignatura;
    private String asignatura;
    private Date initial_date;
    private Date finish_date;

    public outputEstud_AsigDTO fromAsignatura(Estudiante_asignatura asig){
        id_asignatura =   asig.getId_asignatura();
        asignatura = asig.getAsignatura();
        initial_date = asig.getInitial_date();
        finish_date = asig.getFinish_date();
        return this;
    }
}
