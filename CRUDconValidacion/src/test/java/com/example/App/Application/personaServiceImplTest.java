package com.example.App.Application;

import com.example.App.Application.Persona.domain.Persona;
import com.example.App.Application.Persona.infraestructure.controller.dto.input.inputPersonaDTO;
import com.example.App.Application.Persona.infraestructure.controller.dto.output.outputPersonaDTO;
import com.example.App.Application.Persona.infraestructure.repository.PersonaRepository;
import com.example.App.Application.Persona.infraestructure.repository.PersonaService;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.function.ThrowingRunnable;
import org.junit.jupiter.api.*;
//import  org.junit.Test;  //TODO Por que si importo esta clase no me ejeccuta los test ?

import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.Date;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;


@SpringBootTest(classes = com.example.App.Application.CruDconValidacionApplication.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@AutoConfigureMockMvc
public class personaServiceImplTest {


    @Autowired
    PersonaRepository repositorio;

    @Autowired
    PersonaService servicio;

    Persona p;
    inputPersonaDTO dto;

@BeforeClass

private inputPersonaDTO init() throws Exception {
    p = new Persona();
    p.setIdPersona(123456);
    p.setActive(true);
    p.setCity("Martos");
    p.setName("Luis");
    p.setSurname("Rosado");
    p.setCompanyEmail("bosonit@gmail.com");
    p.setPersonaEmail("luis@gmail.com");
    Date f = new Date(01/02/2013);
    p.setCreatedDate(f);
    p.setUsuario("LuisItO");
    p.setPassword("password");
    p.setTerminationDate(f);
    p.setImagenUrl("sdf");

    dto = new inputPersonaDTO(123456,"LuisItO","password","Luisss","Rosado","bosonit@gmail.com",
            "luis@gmail.com","Martos",true,f,"dsfs",f);
    servicio.guardarPersona(dto);
    // Persona d= servicio.guardarPersona(dto);
    return dto;
}

    private void reset(){
        Date f = new Date(01/02/2013);
        dto = new inputPersonaDTO(123456,"LuisItO","password","Luisss","Rosado","bosonit@gmail.com",
                "luis@gmail.com","Martos",true,f,"dsfs",f);
    }


    @Test
    @DisplayName("Testing findById")
    public void findByIdTEST() throws Exception {
//        inputPersonaDTO pedro = init();
//        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAA"+pedro.getId_persona());
        init();
        Assertions.assertNotNull(servicio.findById(1)  );
    }

    @Test
    @DisplayName("Testing findbyUsuario")
    public void findByIdTest(){
//        try {
//            init();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
        Assertions.assertNotNull(servicio.findByUsuario("LuisItO"));
    }

    @Test
    @DisplayName("Testing comprobacion de valores nulos del nombre al transformar input a persona ")
    public void valoresPersonaNameNulosTest() throws Exception {
        Date f = new Date(01/02/2013);
        dto = new inputPersonaDTO(123456,"LuisItO","password","","Rosado","bosonit@gmail.com",
                "luis@gmail.com","Martos",true,f,"dsfs",f);
        dto.setName(null);
        try {
            assertThrows( Exception.class , (ThrowingRunnable) dto.transformDTOtoPersona()) ;
        } catch (Exception e) {
            assertEquals("No se ha especificado un nombre para la persona, o la longitud del mismo no es adecuada",e.getMessage());
        }
    }

    @Test
    @DisplayName("Testing comprobacion de longitud del nombre al transformar input a persona ")
    public void nombreCortoTest() throws Exception {
        Date f = new Date(01/02/2013);
        inputPersonaDTO dto2 = new inputPersonaDTO(123456,"LuisItO","password","isjdbfijasdfhj","Rosado","bosonit@gmail.com",
                "luis@gmail.com","Martos",true,f,"dsfs",f);
        dto = new inputPersonaDTO(123456,"LuisItO","password","","Rosado","bosonit@gmail.com",
                "luis@gmail.com","Martos",true,f,"dsfs",f);
        try {
            assertThrows( Exception.class , (ThrowingRunnable) dto.transformDTOtoPersona()) ;
        } catch (Exception e) {
            assertEquals("No se ha especificado un nombre para la persona, o la longitud del mismo no es adecuada",e.getMessage());
        }
        try {
            assertThrows( Exception.class , (ThrowingRunnable) dto2.transformDTOtoPersona()) ;
        } catch (Exception e) {
            assertEquals("No se ha especificado un nombre para la persona, o la longitud del mismo no es adecuada",e.getMessage());
        }
    }

    @Test
    @DisplayName("Testing comprobacion de valores nulos de los campos del inputPersonaDTO")
    public void valoresPersonaNulosTest() throws Exception {
        Date f = new Date(01/02/2013);
        dto = new inputPersonaDTO(123456,"LuisItO","password","fdgsdfg","Rosado","bosonit@gmail.com",
                "luis@gmail.com","Martos",true,f,"dsfs",f);
        dto.setCompany_email(null);
        try {
            assertThrows( Exception.class , (ThrowingRunnable) dto.transformDTOtoPersona()) ;
        } catch (Exception e) {
            assertEquals("Faltan parámetros por especificar",e.getMessage());
        }
    }





}
