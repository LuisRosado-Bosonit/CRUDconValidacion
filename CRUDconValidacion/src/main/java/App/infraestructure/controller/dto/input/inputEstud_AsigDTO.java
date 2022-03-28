package App.infraestructure.controller.dto.input;

import App.domain.Estudiante_asignatura;
import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class inputEstud_AsigDTO {


    //private String id_asignatura;
    private String asignatura;
    private Date initial_date;
    private Date finish_date;

    public Estudiante_asignatura toEntity(inputEstud_AsigDTO input){
        Estudiante_asignatura sub = new Estudiante_asignatura();
        sub.setAsignatura(input.getAsignatura());
        sub.setFinish_date(input.getFinish_date());
        //sub.setId_asignatura(input.getId_asignatura());
        sub.setInitial_date(input.getInitial_date());
        return sub;
    }
}
