package Persona.infraestructure;

import Persona.domain.Persona;
import Persona.domain.repository.PersonaServiceImpl;
import Persona.infraestructure.controller.dto.input.inputPersonaDTO;
import Persona.infraestructure.controller.dto.output.outputPersonaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public inputPersonaDTO addPerson(@RequestBody inputPersonaDTO dto) throws Exception {
        return persona.guardarPersona(dto);
    }     

    @GetMapping("persona/getAll")
    public List<Persona> showAllRegisters(){
        return persona.showAll();
    }
}
