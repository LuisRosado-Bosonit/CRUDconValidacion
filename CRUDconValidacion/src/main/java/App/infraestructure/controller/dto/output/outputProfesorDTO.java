package App.infraestructure.controller.dto.output;

import App.domain.Persona;
import App.domain.Profesor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

@Data
@Slf4j
public class outputProfesorDTO {

    private String id_profesor;
    private String coments;
    private String branch;
    private Persona identidad;

    public outputProfesorDTO fromEntity(Profesor profe){
        log.info("----- Se está transformando al profesor "+profe.getId_profesor() + " a formato output para su devolución-----");
        id_profesor = profe.getId_profesor();
        coments = profe.getComents();
        branch = profe.getBranch();
        identidad = profe.getPersona();
        return this;
    }

}
