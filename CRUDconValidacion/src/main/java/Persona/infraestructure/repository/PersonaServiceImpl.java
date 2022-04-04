package Persona.infraestructure.repository;

import Persona.domain.Persona;
import Persona.infraestructure.controller.dto.input.inputPersonaDTO;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class PersonaServiceImpl implements PersonaService {
    @Autowired
          PersonaRepository repositorio;

    public record personaDTO(int id_persona,
             String usuario,
             String password,
             String name,
             String surname,
             String company_email,
             String persona_email,
             String city,
             boolean active,
             Date created_date,
             String imagen_url,
             Date termination_date){
        private Persona toPersona(){
            Persona actual = new Persona();
            actual.setName(name);
                // Esto sería todo igual
            return actual;
        }
    };

    public Persona findById(String ID){
       return  repositorio.findById(ID).orElseThrow();
    }

    public List<Persona> findByUsuario(String nombre){
        log.info("--------- Se ha realizado una consulta la base de datos filtrando por usuario ---------");
        return repositorio.findByUsuario(nombre);
    }

    public personaDTO guardarPersona(personaDTO dto) throws Exception {
        repositorio.save(dto.toPersona());
        log.warn("--------- Se ha añadido un nuevo usuario a la base de datos ---------");
        return dto;
    }

    public List<Persona> showAll(){
        log.warn("--------- Se ha realizado una consulta completa de la tabla ---------");
        return repositorio.findAll();
    }
}
