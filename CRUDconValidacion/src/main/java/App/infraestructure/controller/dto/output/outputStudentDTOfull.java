package App.infraestructure.controller.dto.output;

import App.infraestructure.Services.PersonaService;
import App.infraestructure.Services.StudentService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public class outputStudentDTOfull {

    @Autowired
    PersonaService servicioPersona;

    @Autowired
    StudentService servicioStudiante;


    public outputStudentDTOfull fromID(String ID){
        
        return this;
    }
}
