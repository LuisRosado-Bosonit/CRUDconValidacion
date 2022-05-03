package com.example.App.Application.Persona.infraestructure.repository;

import com.example.App.Application.Persona.domain.Persona;
import com.example.App.Application.Persona.infraestructure.controller.dto.input.inputPersonaDTO;

import java.util.HashMap;
import java.util.List;

public interface PersonaService {

    public Persona findById(Integer id);

    public List<Persona> findByUsuario(String name);

    public inputPersonaDTO guardarPersona(inputPersonaDTO dto) throws Exception;

    public List<Persona> showAll();

  //  public List<Persona> getData(HashMap<String,Object> condiciones);
}
