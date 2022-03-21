package Persona.infraestructure.repository;

import Persona.domain.Persona;
import Persona.infraestructure.controller.dto.input.inputPersonaDTO;

import java.util.List;

public interface PersonaService {

    public Persona findById(String id);

    public List<Persona> findByUsuario(String name);

    public inputPersonaDTO guardarPersona(inputPersonaDTO dto) throws Exception;

    public List<Persona> showAll();
}
