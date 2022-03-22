package App.infraestructure.repository;

import App.domain.Persona;
import App.infraestructure.controller.dto.input.inputPersonaDTO;

import java.util.List;

public interface PersonaService {

    public Persona findById(String id);

    public List<Persona> findByUsuario(String name);

    public inputPersonaDTO guardarPersona(inputPersonaDTO dto) throws Exception;

    public List<Persona> showAll();
}
