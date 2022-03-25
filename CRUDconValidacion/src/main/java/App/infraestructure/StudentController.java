package App.infraestructure;

import App.infraestructure.Services.PersonaService;
import App.infraestructure.Services.ProfesorService;
import App.infraestructure.Services.StudentService;
import App.infraestructure.controller.dto.input.inputStudentDTO;
import App.infraestructure.controller.dto.output.outputStudentDTOfull;
import App.infraestructure.controller.dto.output.outputStudentDTOsimple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Object> getByID(@PathVariable String ID,
                                          @RequestParam(name = "type",defaultValue = "simple") String tipo) throws Exception {
        switch (tipo) {
            case "Full": {
                outputStudentDTOfull output = new outputStudentDTOfull();
                return ResponseEntity.status(HttpStatus.OK).body(output.toDTO(servicio.findByID(ID)));
            }
            default: {
                outputStudentDTOsimple output = new outputStudentDTOsimple();
                return ResponseEntity.status(HttpStatus.OK).body(output.toDTO(servicio.findByID(ID)));
            }
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "estudiante")
    public ResponseEntity<outputStudentDTOfull> getByID(@RequestBody inputStudentDTO dto) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(dto.obtenerOutputDTO(servicio.addStudent(dto.transformToStudent(servicioProfesor.internFindById(dto.getId_profesor()),
                servicioPersona.findById(dto.getId_persona())))));
    }




}
