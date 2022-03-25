package App.infraestructure;

import App.infraestructure.Services.PersonaService;
import App.infraestructure.Services.ProfesorService;
import App.infraestructure.Services.StudentService;
import App.infraestructure.controller.dto.input.inputPersonaDTO;
import App.infraestructure.controller.dto.input.inputStudentDTO;
import App.infraestructure.controller.dto.output.outputStudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    StudentService servicio;
    @Autowired
    ProfesorService servicioProfesor;
    @Autowired
    PersonaService servicioPersona;


    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "estudiante/{ID}")
    public ResponseEntity<outputStudentDTO> getByID(@PathVariable String ID, @RequestParam(name = "type",defaultValue = "simple") String tipo) throws Exception {
        outputStudentDTO output = new outputStudentDTO();
//        if(tipo.equals("simple"))output.build(ID,true) ;             //FIXME
//        output.build(ID,false) ;
        return ResponseEntity.status(HttpStatus.OK).body(output);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "estudiante")
    public ResponseEntity<outputStudentDTO> getByID(@RequestBody inputStudentDTO dto) throws Exception {
        servicio.addStudent(dto.transformToStudent(servicioProfesor.internFindById(dto.getId_profesor()),
                servicioPersona.findById(dto.getId_persona())));
        return ResponseEntity.status(HttpStatus.CREATED).body(dto.obtenerOutputDTO());
    }




}
