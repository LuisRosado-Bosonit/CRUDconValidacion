package com.example.App.Application;


import com.example.App.Application.Persona.domain.Persona;
import com.example.App.Application.Persona.infraestructure.PersonaController;
import com.example.App.Application.Persona.infraestructure.repository.PersonaRepository;
import org.aspectj.weaver.patterns.PerObject;
import org.junit.BeforeClass;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = com.example.App.Application.CruDconValidacionApplication.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@AutoConfigureMockMvc
public class controllerTest {

    @Autowired
    private MockMvc mocazo;

    @MockBean
    private PersonaRepository repositorio;

    @InjectMocks
            private PersonaController controlador;

    Persona p;
    @BeforeAll
    @BeforeEach
    private void init(){
        p = new Persona();
        p.setIdPersona(1);
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
        repositorio.save(p);
        when(repositorio.findById(1)).thenReturn(Optional.of(p));
        List<Persona> people = new ArrayList<>();
        people.add(p);
        when(repositorio.findByUsuario("LuisItO"))
                .thenReturn(people);
    }

    @Test
    @DisplayName("Testing el get del controlador")
    public void FIND_PERSONA_ID() throws Exception {
        mocazo.perform(get("/persona/1"))
                .andExpect(jsonPath("$.name",is("Luis")));
    }


    @Test
    public void GetByUserTEST() throws Exception {
        mocazo.perform(get("/persona/getByUser").
                    param("name","LuisItO"))
                .andExpect(status()
                        .isOk());
    }


    @Test
    public void showAllRegistersTEST() throws Exception {
        List<Persona> pe = new ArrayList<>();
        when(repositorio.findAll()).thenReturn(pe);
        mocazo.perform(get("/persona/getAll"))
                .andExpect(status()
                        .isOk());
    }

}
