package App.infraestructure.Services;

import App.infraestructure.controller.dto.input.inputEstud_AsigDTO;
import App.infraestructure.controller.dto.output.outputEstud_AsigDTO;

public interface EstudianteAsignaturaService {
    void removeByID(String id);
    outputEstud_AsigDTO findByID(String id);

    outputEstud_AsigDTO addSubject(inputEstud_AsigDTO input);

    outputEstud_AsigDTO updateByID(String id, inputEstud_AsigDTO input);
}
