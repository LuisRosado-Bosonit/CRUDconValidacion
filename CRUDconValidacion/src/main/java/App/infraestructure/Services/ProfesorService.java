package App.infraestructure.Services;

import App.domain.Profesor;
import App.infraestructure.controller.dto.input.inputProfesorDTO;
import App.infraestructure.controller.dto.output.outputProfesorDTO;
import App.infraestructure.repository.ProfesorRepository;

public interface ProfesorService {
    public Profesor findByID(String id);

    public outputProfesorDTO addFromPersona(Profesor profesor);
}
