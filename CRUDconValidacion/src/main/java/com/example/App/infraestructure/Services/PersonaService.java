package com.example.App.infraestructure.Services;

import com.example.App.domain.Persona;
import com.example.App.infraestructure.controller.dto.input.inputPersonaDTO;

import java.util.List;

public interface PersonaService {

    public Persona findById(String id);

    public List<Persona> findByUsuario(String name);

    public inputPersonaDTO guardarPersona(inputPersonaDTO dto) throws Exception;

    public List<Persona> showAll();
}
