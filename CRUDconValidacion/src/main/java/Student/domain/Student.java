package Student.domain;

import Estudiante_asignatura.domain.Estudiante_asignatura;
import Persona.domain.Persona;
import Profesor.domain.Profesor;
import Student.Utils.StringPrefixedSequenceIdGenerator;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@EqualsAndHashCode
@Data
public class Student {
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
    @Column(name = "id_student", nullable = false)
    private String id_student;

    @Column
            @OneToOne
            @JoinColumn(name = "id_persona")
    private Persona persona;


    @Column
    @NotNull(message = "Es necesario especificar el número de horas semanales")
    private int num_hours_week;

    @Column
    private String coments;

    @Column
            @ManyToOne
            @JoinColumn(name = "id_profesor")
    private Profesor profesor;

    @Column
            @NotNull(message = "Se debe especificar una rama principal para cada estudiante")
    private String Branch;

    @ManyToMany
    @JoinTable(
            name = "cursando_asignatura",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "id_asignatura"))
    private List<Estudiante_asignatura> asignaturas;

}
