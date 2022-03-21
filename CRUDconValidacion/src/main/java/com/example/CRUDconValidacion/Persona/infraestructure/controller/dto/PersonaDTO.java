package com.example.CRUDconValidacion.Persona.infraestructure.controller.dto;

import com.example.CRUDconValidacion.Persona.domain.Persona;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

@Slf4j
@Data
@AllArgsConstructor
public class PersonaDTO {
    //private Logger log =  LoggerFactory.getLogger(PersonaDTO.class);
    private int id_persona;
    private String usuario;
    private String password;
    private String name;
    private String surname;
    private String company_email;
    private String persona_email;
    private String city;
    private boolean active;
    private Date created_date;
    private String imagen_url;
    private Date termination_date;


    public Persona transformDTOtoPersona () throws Exception {
        Persona mariano = new Persona();
        System.out.println(this);
        if(this.name == null || 10 < this.name.length() || this.name.length() < 6) {
            log.error("--------- No se ha introducido un nombre de usuario, o el mismo no tiene la longitud adecuada ---------");
            throw new Exception("No se ha especificado un nombre para la persona, o la longitud del mismo no es adecuada");
        }
        mariano.setName(this.name);
        if(algunoNulo(this))throw new Exception("Faltan parámetros por especificar");
        mariano.setUsuario(this.usuario);
        mariano.setPassword(this.password);
        mariano.setCompany_email(this.company_email);
        mariano.setPersona_email(this.persona_email);
        mariano.setCity(this.city);
        mariano.setActive(this.active);
        mariano.setCreated_date(this.created_date);

        return mariano;
    }

    private boolean algunoNulo(PersonaDTO dto){
        if(dto.getPassword() == null ||
                dto.getName() == null ||
                dto.getCompany_email() == null ||
                dto.getPersona_email() == null ||
                dto.getCity() == null ||
                !dto.isActive() ||
                dto.created_date == null
        ) {
            log.error("--------- Faltan parámetros en la creación del usuario ---------");
            return true;
        }
        log.info("--------- Los parámetros del usuario "+dto.getUsuario()+" son correctos "+"---------");
        return false;
    }
}
