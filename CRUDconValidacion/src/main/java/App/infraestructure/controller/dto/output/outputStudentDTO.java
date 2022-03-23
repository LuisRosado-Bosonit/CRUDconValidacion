package App.infraestructure.controller.dto.output;

import App.domain.Estudiante_asignatura;
import App.domain.Persona;
import App.domain.Student;
import App.infraestructure.Services.PersonaService;
import App.infraestructure.Services.StudentService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

@Data
public class outputStudentDTO {

    @Autowired
    PersonaService servicioPersona;

    @Autowired
    StudentService servicioStudiante;

    private String id_student;

    //private Persona persona;

    private int num_hours_week;

    private String coments;

    //private Profesor profesor;

    private String Branch;

    private List<Estudiante_asignatura> asignaturas;



    //Consulta FULL

    private int id_persona;
    private String usuario;
    private String name;
    private String surname;
    private String company_email;
    private String city;
    private boolean active;
    private Date created_date;
    private String imagen_url;
    private Date termination_date;


    public outputStudentDTO build(String ID, boolean simple) throws Exception {
        Student estudiante = new Student();
        estudiante = servicioStudiante.findByID(ID);
        if(estudiante == null)throw new Exception("No se ha encontrado ningún estudiante con ese ID");
        this.id_student = estudiante.getId_student();
        this.num_hours_week = estudiante.getNum_hours_week();
        this.coments = estudiante.getComents();
        this.Branch = estudiante.getBranch();
        if(simple)return this;

        //Si la consulta es de tipo FULL se devolverán también los siguientes campos
        Persona persona = new Persona();
        persona = estudiante.getPersona();
        this.id_persona = persona.getId_persona();
        this.usuario = persona.getUsuario();
        this.name = persona.getName();
        this.surname = persona.getSurname();
        this.company_email = persona.getCompany_email();
        this.city = persona.getCity();
        this.active = persona.isActive();
        this.created_date = persona.getCreated_date();
        this.imagen_url = persona.getImagen_url();
        this.termination_date = persona.getTermination_date();
        return this;
    }

}
