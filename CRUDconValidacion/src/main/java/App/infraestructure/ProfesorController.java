package App.infraestructure;

import App.domain.Persona;
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


    @ResponseStatus(HttpStatus.OK)
    @PostMapping("profesor")
    public ResponseEntity<outputProfesorDTO> add(@RequestBody inputProfesorDTO input){
           return ResponseEntity.status(HttpStatus.OK).body(servicioProfesor.addFromPersona(input.toEntity(input)));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("profesor")
    public ResponseEntity<outputProfesorDTO> getById(@RequestParam String ID) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(servicioProfesor.findByID(ID));
    }

}
