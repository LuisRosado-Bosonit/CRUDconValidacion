package App.infraestructure;

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


    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "estudiante/{ID}")
    public ResponseEntity<outputStudentDTO> getByID(@PathVariable String ID, @RequestParam(name = "type",defaultValue = "simple") String tipo) throws Exception {
        outputStudentDTO output = new outputStudentDTO();
        if(tipo.equals("simple"))output.build(ID,true) ;
        output.build(ID,false) ;
        return ResponseEntity.status(HttpStatus.OK).body(output);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = "estudiante/add")
    public ResponseEntity<outputStudentDTO> getByID(@RequestBody inputStudentDTO dto) throws Exception {
        servicio.addStudent(dto.transformToStudent());
        return ResponseEntity.status(HttpStatus.OK).body(dto.obtenerOutputDTO());
    }


}
