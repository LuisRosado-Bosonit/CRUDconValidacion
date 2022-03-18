package com.example.CRUDconValidacion.Persona.infraestructure.controller;

import com.example.CRUDconValidacion.Persona.domain.Persona;
import com.example.CRUDconValidacion.Persona.domain.PersonaService;
import com.example.CRUDconValidacion.Persona.infraestructure.controller.dto.PersonaDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class PersonaController  {
    @Autowired
    PersonaService persona;

    private Logger log = LoggerFactory.getLogger(PersonaController.class);


    @GetMapping("persona/getByID")
    public Persona  buscarPorID(@RequestParam String ID){

        Optional<Persona> resultado = persona.findById(ID);
        if(resultado.isEmpty())
            log.info("--------- Una consulta por ID no ha devuelto ningún resultado ---------");
        return resultado.get();
    }

    @GetMapping("persona/getByUser")
    public List<Persona> buscarPorName(@RequestParam String name){
        log.info("--------- Se ha realizado una consulta la base de datos filtrando por usuario ---------");
        List<Persona> lista = new ArrayList<Persona>();
        lista.addAll(persona.findByUsuario(name));
        return lista;
    }

    @PutMapping("persona/add")
    public Persona addPerson(@RequestBody PersonaDTO dto) throws Exception {
        Persona actual = dto.transformDTOtoPersona();
        persona.save(actual);
        log.warn("--------- Se ha añadido un nuevo usuario a la base de datos ---------");
        return actual;
    }     

    @GetMapping("persona/getAll")
    public List<Persona> showAllRegisters(){
        log.warn("--------- Se ha realizado una consulta completa de la tabla ---------");
        return persona.findAll();
    }
}
