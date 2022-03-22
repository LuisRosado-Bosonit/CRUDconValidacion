package App.infraestructure.controller.dto.output;

import App.domain.Persona;
import App.infraestructure.controller.dto.input.inputPersonaDTO;
import lombok.Data;

import java.util.Date;
@Data
public class outputPersonaDTO {

    private String usuario;
    private String name;
    private String surname;
    private String company_email;
    private String city;
    private boolean active;
    private Date created_date;
    private String imagen_url;
    private Date termination_date;

    public outputPersonaDTO toOutputDTO(Persona origen){
        this.usuario = origen.getUsuario();
        this.name = origen.getName();
        this.surname = origen.getSurname();
        this.company_email = origen.getSurname();
        this.city = origen.getCity();
        this.active = origen.isActive();
        this.created_date = origen.getCreated_date();
        this.imagen_url = origen.getImagen_url();
        this.termination_date = origen.getTermination_date();
        return this;
    }

    public outputPersonaDTO fromInput(inputPersonaDTO in){
        this.usuario = in.getUsuario();
        this.name = in.getName();
        this.surname = in.getSurname();
        this.company_email = in.getCompany_email();
        this.city = in.getCity();
        this.active = in.isActive();
        this.created_date = in.getCreated_date();
        this.imagen_url = in.getImagen_url();
        this.termination_date = in.getTermination_date();
        return this;
    }
}
