package Profesor.domain;

import Persona.domain.Persona;
import Student.Utils.StringPrefixedSequenceIdGenerator;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ausencias_seq")
    @GenericGenerator(
            name = "ausencias_seq",
            strategy = "src/main/java/Student/Utils/StringPrefixedSequenceIdGenerator.java",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value =
                            "AUS"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value =
                            "%08d")
            } )
    @Column(name = "id_profesor", nullable = false)
    private String id_profesor;

    @Column
            @OneToOne
            @JoinColumn(name = "id_persona")
    private Persona persona;

    @Column
    private String coments;

    @Column
            @NotNull(message = "Es necesario agregar una materia impartida a cada profesor")
    private String branch;
}
