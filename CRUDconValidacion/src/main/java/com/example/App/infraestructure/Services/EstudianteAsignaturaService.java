package com.example.App.infraestructure.Services;

import com.example.App.domain.Estudiante_asignatura;
import com.example.App.infraestructure.controller.dto.input.inputEstud_AsigDTO;
import com.example.App.infraestructure.controller.dto.output.outputEstud_AsigDTO;

import java.util.List;

public interface EstudianteAsignaturaService {
    void removeByID(String id);
    outputEstud_AsigDTO findByID(String id);
    Estudiante_asignatura internFindByID(String id);

    outputEstud_AsigDTO addSubject(inputEstud_AsigDTO input);
    List<Estudiante_asignatura> asignaturasCursadas(String id);
    outputEstud_AsigDTO updateByID(String id, inputEstud_AsigDTO input);
}
