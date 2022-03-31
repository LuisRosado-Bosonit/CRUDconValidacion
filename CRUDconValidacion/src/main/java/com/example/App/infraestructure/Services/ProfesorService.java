package com.example.App.infraestructure.Services;

import com.example.App.domain.Profesor;
import com.example.App.infraestructure.controller.dto.input.inputProfesorDTO;
import com.example.App.infraestructure.controller.dto.output.outputProfesorDTO;

public interface ProfesorService {
    public outputProfesorDTO findByID(String id) throws Exception;
    public outputProfesorDTO addFromPersona(Profesor profesor);
    public void removeByID(String id);
    public outputProfesorDTO updateByID(String id, inputProfesorDTO dto);
    public Profesor internFindById(String id);
}
