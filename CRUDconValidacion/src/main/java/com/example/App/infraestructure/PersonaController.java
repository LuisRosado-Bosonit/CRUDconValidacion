package com.example.App.infraestructure;

import com.example.App.domain.Persona;
import com.example.App.infraestructure.Services.PersonaService;
import com.example.App.infraestructure.controller.dto.input.inputPersonaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:8080/addperson", methods = {RequestMethod.GET, RequestMethod.POST})
@CrossOrigin(origins = "*", methods = {RequestMethod.GET})
//@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class PersonaController  {
    @Autowired
    PersonaService persona;   //Es una mala práctica ??

    //Esta clase es la primera de la que hice un CRUD, por eso es tan primitivo y poco sólido,
    // la he dejado intacta a posta


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
    @PostMapping("/addperson")
    public ResponseEntity<inputPersonaDTO> addPerson(@RequestBody inputPersonaDTO dto) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(persona.guardarPersona(dto));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("persona/getAll")
    public ResponseEntity<List<Persona>> showAllRegisters(){
        return ResponseEntity.status(HttpStatus.OK).body(persona.showAll());
    }
}
