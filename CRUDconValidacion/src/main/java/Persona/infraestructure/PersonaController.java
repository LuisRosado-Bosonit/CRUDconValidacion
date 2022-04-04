package Persona.infraestructure;

import Persona.domain.Persona;
import Persona.infraestructure.repository.PersonaService;
import Persona.infraestructure.repository.PersonaServiceImpl;
import Persona.infraestructure.controller.dto.input.inputPersonaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
public class PersonaController  {
    @Autowired
    PersonaService persona;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("persona/{ID}")
    public ResponseEntity<Persona> buscarPorID(@PathVariable String ID){
        if(persona.findById(ID) == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(persona.findById(ID));
        return ResponseEntity.status(HttpStatus.OK).body(persona.findById(ID));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("persona/getByUser")
    public ResponseEntity<List<Persona>> buscarPorName(@RequestParam String name){
        return ResponseEntity.status(HttpStatus.OK).body(persona.findByUsuario(name));
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("persona")
    public ResponseEntity<inputPersonaDTO> addPerson(@RequestBody inputPersonaDTO dto) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(persona.guardarPersona(dto));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("persona/getAll")
    public ResponseEntity<List<Persona>> showAllRegisters(){
        return ResponseEntity.status(HttpStatus.OK).body(persona.showAll());
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping("persona/getData")     //TODO ¿¿En este tipo de consultas tiene sentido usar imputs dto para obtener los datos y luego transformarlos al hashmap para la consulta??
    public ResponseEntity<List<Persona>> getData(@RequestParam(required = false, name = "usuario") String usuario,
                                                 @RequestParam(required = false, name = "name") String name,
                                                 @RequestParam(required = false, name = "surname") String surname,
                                                 @RequestParam(required = false, name = "created_date") @DateTimeFormat(pattern = "dd-MM-yyyy") Date created_date,
                                                 @RequestParam(required = false, name = "condicion") String dateCondition,
                                                 @RequestParam(required = false, name = "order") String orderBy,
                                                 @RequestParam(required = false, name = "tamPagina", defaultValue = "10") int tamPagina,
                                                 @RequestParam(required = true, name = "numPagina", defaultValue = "0") int numPagina) {
        HashMap<String, Object> data=new HashMap<>();

        if (usuario!=null)
            data.put("usuario",usuario);
        if (name!=null)
            data.put("name",name);
        if (surname!=null)
            data.put("address",surname);
        if (created_date!=null){
            data.put("created_date",created_date);
            data.put("dateCondition",dateCondition) ;
        }
        if (orderBy != null)
            data.put("orderBy",orderBy);

        data.put("tamPagina",tamPagina);
        data.put("numPagina",numPagina);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(persona.getData(data));
    }
}
