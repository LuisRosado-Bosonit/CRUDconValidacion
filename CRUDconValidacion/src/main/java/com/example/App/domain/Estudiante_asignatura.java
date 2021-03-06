package com.example.App.domain;

import com.example.App.Utils.StringPrefixedSequenceIdGenerator;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Estudiante_asignatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "generador")
    @GenericGenerator(
            name = "generador",
            strategy = "com.example.App.Utils.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "E_A"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d")
            })
    private String id_asignatura;

    @ManyToMany(mappedBy = "asignaturas", cascade = CascadeType.ALL)
    private List<Student> estudiantes;

    @Column
    private String asignatura;

    @Column
            @NotNull(message = "Se debe especificar una fecha de inicio para las entidades del tipo Estudiante_asignatura")
    private Date initial_date;

    @Column
    private Date finish_date;
}

