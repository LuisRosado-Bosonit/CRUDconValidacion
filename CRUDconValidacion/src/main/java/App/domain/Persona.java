package App.domain;

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
    @Column(name = "id_persona", nullable = false)
    private int id_persona;

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
