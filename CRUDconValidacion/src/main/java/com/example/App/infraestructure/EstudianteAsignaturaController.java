package com.example.App.infraestructure;

import com.example.App.infraestructure.Services.EstudianteAsignaturaService;
import com.example.App.infraestructure.controller.dto.input.inputEstud_AsigDTO;
import com.example.App.infraestructure.controller.dto.output.outputEstud_AsigDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EstudianteAsignaturaController {

    @Autowired
    EstudianteAsignaturaService servicioAsignatura;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("asignatura")
    public ResponseEntity<outputEstud_AsigDTO> add(@RequestBody inputEstud_AsigDTO input) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(servicioAsignatura.addSubject(input));
    }

    @ResponseStatus(HttpStatus.FOUND)
    @GetMapping("asignatura")
    public ResponseEntity<outputEstud_AsigDTO> getById(@RequestParam String ID) throws Exception {
        return ResponseEntity.status(HttpStatus.FOUND).body(servicioAsignatura.findByID(ID));
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping("asignatura")
    public ResponseEntity<String> deleteById(@RequestParam String id){
        servicioAsignatura.removeByID(id);
        return ResponseEntity.status(HttpStatus.FOUND).body("Se ha removido correctamente");
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping("asignatura")
    public ResponseEntity<outputEstud_AsigDTO> updateById(@RequestParam String id,
                                                        @RequestBody inputEstud_AsigDTO input){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(servicioAsignatura.updateByID(id,input));
    }

    @ResponseStatus(HttpStatus.FOUND)
    @GetMapping("asignatura/StudentId")
    public ResponseEntity<String> getSubjectsByStudentId(@RequestParam String ID) throws Exception {
        return ResponseEntity.status(HttpStatus.FOUND).body("");
    }

}
