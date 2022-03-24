package App.infraestructure.controller.dto.input;

import App.domain.Persona;
import App.domain.Profesor;
import App.infraestructure.Services.PersonaService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public class inputProfesorDTO {

    private String id_profesor;
    private String id_persona;
    private String coments;
    private String branch;

    @Autowired
    PersonaService servicioPersona;

    public Profesor toEntity(inputProfesorDTO dto, Persona p){
        Profesor manolo = new Profesor();
        manolo.setBranch(dto.getBranch());
        manolo.setComents(dto.getComents());
        manolo.setPersona(p);
        return manolo;
    }
}
