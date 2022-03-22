package Estudiante_asignatura.domain;

import Student.Utils.StringPrefixedSequenceIdGenerator;
import Student.domain.Student;
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
    @Column(name = "id_asignatura", nullable = false)
    private String id_asignatura;

    @Column
            @ManyToMany(mappedBy = "asignaturas")
            @JoinColumn(name = "id_student")
    private List<Student> estudiantes;

    @Column
    private String asignatura;

    @Column
            @NotNull(message = "Se debe especificar una fecha de inicio para las entidades del tipo Estudiante_asignatura")
    private Date initial_date;

    @Column
    private Date finish_date;
}

