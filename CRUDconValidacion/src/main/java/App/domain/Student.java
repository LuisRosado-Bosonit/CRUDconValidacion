package App.domain;

import App.Utils.StringPrefixedSequenceIdGenerator;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "generador")
    @GenericGenerator(
            name = "generador",
            strategy = "App.Utils.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "EST"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d")
            })
    private String id_student;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_persona")
    private Persona persona;


    @Column
    @NotNull(message = "Es necesario especificar el número de horas semanales")
    private int num_hours_week;

    @Column
    private String coments;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_profesor")
    private Profesor profesor;

    @Column
            @NotNull(message = "Se debe especificar una rama principal para cada estudiante")
    private String Branch;

    @ManyToMany
    @JoinTable(
            name = "cursando_asignatura",
            joinColumns ={ @JoinColumn(name = "student_id")},
            inverseJoinColumns = {@JoinColumn(name = "id_asignatura")})
    private List<Estudiante_asignatura> asignaturas;

    public void addSubject(Estudiante_asignatura asignatura){
        this.asignaturas = new ArrayList<>();
        this.asignaturas.add(asignatura);
    }

}

