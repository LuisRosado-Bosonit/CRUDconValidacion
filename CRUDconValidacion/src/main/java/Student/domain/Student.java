package Student.domain;

import Student.Utils.StringPrefixedSequenceIdGenerator;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

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
            //@OneToOne(mappedBy = "")
    String id_persona;

}
