package App.infraestructure.controller.dto.input;

import App.domain.Profesor;
import lombok.Data;

@Data
public class inputProfesorDTO {

    private String id_profesor;
    private String id_persona;
    private String coments;
    private String branch;

    public Profesor toEntity(inputProfesorDTO dto){
        Profesor manolo = new Profesor();
        manolo.setBranch(dto.getBranch());
        manolo.setComents(dto.getComents());
        return manolo;
    }
}
