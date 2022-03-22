package App.infraestructure;

import App.infraestructure.Services.StudentService;
import App.infraestructure.controller.dto.output.outputStudentDTOsimple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @Autowired
    StudentService servicio;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "estudiante/{ID}/")
    public ResponseEntity<outputStudentDTOsimple> getByID(@PathVariable String ID) throws Exception {
        outputStudentDTOsimple output = new outputStudentDTOsimple(ID);
        return ResponseEntity.status(HttpStatus.OK).body(output);
    }
}
