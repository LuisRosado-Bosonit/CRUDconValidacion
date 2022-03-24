package App.domain;

import App.Utils.StringPrefixedSequenceIdGenerator;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Optional;

@Entity
@Data
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "generador")
    @GenericGenerator(
            name = "generador",
            strategy = "App.Utils.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "PER"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d")
            })
    private String id_persona;

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
    private String company_email;

    @NotNull
            @Email
    private String persona_email;

    @NotNull
    private String city;

    @NotNull
    boolean active;

    @NotNull
    private Date created_date;

    private String imagen_url;

    private Date termination_date;
}
