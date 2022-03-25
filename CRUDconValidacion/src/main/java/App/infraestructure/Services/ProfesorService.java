package App.infraestructure.Services;

import App.domain.Profesor;
import App.infraestructure.controller.dto.input.inputProfesorDTO;
import App.infraestructure.controller.dto.output.outputProfesorDTO;
import App.infraestructure.repository.ProfesorRepository;
import org.springframework.stereotype.Service;

public interface ProfesorService {
    public outputProfesorDTO findByID(String id) throws Exception;
    public outputProfesorDTO addFromPersona(Profesor profesor);
    public void removeByID(String id);
    public outputProfesorDTO updateByID(String id, inputProfesorDTO dto);
    public Profesor internFindById(String id);
}
