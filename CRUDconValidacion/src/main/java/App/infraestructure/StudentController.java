package App.infraestructure;

import App.infraestructure.Services.StudentService;
import App.infraestructure.controller.dto.output.outputStudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
