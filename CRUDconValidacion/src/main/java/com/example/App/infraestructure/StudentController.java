package com.example.App.infraestructure;

import com.example.App.domain.Estudiante_asignatura;
import com.example.App.domain.Persona;
import com.example.App.domain.Profesor;
import com.example.App.infraestructure.Services.EstudianteAsignaturaService;
import com.example.App.infraestructure.Services.PersonaService;
import com.example.App.infraestructure.Services.ProfesorService;
import com.example.App.infraestructure.Services.StudentService;
import com.example.App.infraestructure.controller.dto.input.inputStudentDTO;
import com.example.App.infraestructure.controller.dto.output.outputStudentDTOfull;
import com.example.App.infraestructure.controller.dto.output.outputStudentDTOsimple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService servicio;
    @Autowired
    ProfesorService servicioProfesor;
    @Autowired
    PersonaService servicioPersona;
    @Autowired
    EstudianteAsignaturaService servicioAsignatura;


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
        Persona persona = new Persona();
        Profesor profesor = new Profesor();
        Estudiante_asignatura asignatura = new Estudiante_asignatura();
        if(dto.getId_persona()!=null) {persona = servicioPersona.findById(dto.getId_persona());}
        if(dto.getId_profesor()!=null){profesor = servicioProfesor.internFindById(dto.getId_profesor());}
        if(dto.getAsignatura()!=null){asignatura = servicioAsignatura.internFindByID(dto.getAsignatura());}
        return ResponseEntity.status(HttpStatus.CREATED).body(dto.obtenerOutputDTO(servicio.addStudent(dto.transformToStudent(persona,profesor,asignatura))));
    }

    @ResponseStatus(HttpStatus.FOUND)
    @PostMapping(value = "estudiante/addSubject")
    public ResponseEntity<List<Estudiante_asignatura>> getByID(@PathVariable String ID,
                                          @PathVariable List<String> id_asignaturas) throws Exception {
        return ResponseEntity.status(HttpStatus.FOUND).body(servicio.addAsignaturas(ID, id_asignaturas));
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping(value = "estudiante/removeSujects")
    public ResponseEntity<String> eliminarAsignaturas(@PathVariable List<String> id_asignaturas,
                                                      @PathVariable String id){
        servicio.removeAsignaturas(id,id_asignaturas);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Todo bien");
    }





}
