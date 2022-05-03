package com.example.App.Application.Persona.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Data
public class Persona {
    @Id
    @Column(name = "idPersona", nullable = false)
    @GeneratedValue
    private int idPersona;

    @Column(name="usuario", nullable = false)
            @Size(min =6 ,max=10 , message = "La longitud del usuario debe ser de entre 6 y 10 caracteres")
    private String usuario;

    @NotNull
    private String password;

    @NotNull
    private String name;

    private String surname;

    @Email
            @NotNull
    private String companyEmail;

    @NotNull
            @Email
    private String personaEmail;

    @NotNull
    private String city;

    @NotNull
    boolean active;

    @NotNull
    private Date createdDate;

    private String imagenUrl;

    private Date terminationDate;
}
