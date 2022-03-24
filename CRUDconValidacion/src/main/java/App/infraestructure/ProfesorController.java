package App.infraestructure;

import App.domain.Persona;
import App.infraestructure.Services.PersonaService;
import App.infraestructure.Services.ProfesorService;
import App.infraestructure.controller.dto.input.inputProfesorDTO;
import App.infraestructure.controller.dto.output.outputProfesorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProfesorController {
    @Autowired
    ProfesorService servicioProfesor;

    @Autowired
    PersonaService servicioPersona;


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("profesor")
    public ResponseEntity<outputProfesorDTO> add(@RequestBody inputProfesorDTO input) throws Exception {
           return ResponseEntity.status(HttpStatus.CREATED).body(servicioProfesor.addFromPersona(input.toEntity(input, servicioPersona.findById(input.getId_persona()))));
    }

    @ResponseStatus(HttpStatus.FOUND)
    @GetMapping("profesor")
    public ResponseEntity<outputProfesorDTO> getById(@RequestParam String ID) throws Exception {
        return ResponseEntity.status(HttpStatus.FOUND).body(servicioProfesor.findByID(ID));
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping("profesor")
    public ResponseEntity<String> deleteById(@RequestParam String id){
        servicioProfesor.removeByID(id);
        return ResponseEntity.status(HttpStatus.FOUND).body("Se ha removido correctamente");
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping("profesor")
    public ResponseEntity<outputProfesorDTO> updateById(@RequestParam String id,
                                                        @RequestBody inputProfesorDTO input){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(servicioProfesor.updateByID(id,input));
    }



}
