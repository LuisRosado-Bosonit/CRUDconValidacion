package App.infraestructure;

import App.domain.Persona;
import App.infraestructure.Services.PersonaService;
import App.infraestructure.controller.dto.input.inputPersonaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonaController  {
    @Autowired
    PersonaService persona;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("persona/{ID}")
    public ResponseEntity<Persona> buscarPorID(@PathVariable String ID){
        //if(persona.findById(ID) == null) return CustomizeNotFoundException(ChangeSetPersister.NotFoundException() );
        if(persona.findById(ID) == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(persona.findById(ID));
        return ResponseEntity.status(HttpStatus.OK).body(persona.findById(ID));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("persona/getByUser")
    public ResponseEntity<List<Persona>> buscarPorName(@RequestParam String name){
        return ResponseEntity.status(HttpStatus.OK).body(persona.findByUsuario(name));
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("persona")
    public ResponseEntity<inputPersonaDTO> addPerson(@RequestBody inputPersonaDTO dto) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(persona.guardarPersona(dto));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("persona/getAll")
    public ResponseEntity<List<Persona>> showAllRegisters(){
        return ResponseEntity.status(HttpStatus.OK).body(persona.showAll());
    }
}
