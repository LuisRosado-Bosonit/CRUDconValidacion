package Persona.infraestructure;

import Persona.domain.Persona;
import Persona.domain.repository.PersonaRepository;
import Persona.domain.repository.PersonaServiceImpl;
import Persona.infraestructure.controller.dto.PersonaDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class PersonaController  {
    @Autowired
    PersonaServiceImpl persona;

    @GetMapping("persona/{ID}")
    public Persona buscarPorID(@PathVariable String ID){
        return persona.findById(ID);
    }

    @GetMapping("persona/getByUser")
    public List<Persona> buscarPorName(@RequestParam String name){
        return persona.findByUsuario(name);
    }

    @PostMapping("persona")
    public Persona addPerson(@RequestBody PersonaDTO dto) throws Exception {
        Persona actual = dto.transformDTOtoPersona();
        persona.guardarPersona(actual);
        return actual;
    }     

    @GetMapping("persona/getAll")
    public List<Persona> showAllRegisters(){
        return persona.showAll();
    }
}
