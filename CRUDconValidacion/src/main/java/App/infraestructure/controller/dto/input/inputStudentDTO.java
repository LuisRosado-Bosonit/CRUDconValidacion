package App.infraestructure.controller.dto.input;

import App.domain.Estudiante_asignatura;
import App.domain.Persona;
import App.domain.Profesor;
import App.domain.Student;
import App.infraestructure.Services.PersonaService;
import App.infraestructure.Services.ProfesorService;
import App.infraestructure.controller.dto.output.outputStudentDTO;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Data
public class inputStudentDTO {
    @Autowired
    PersonaService servicioPersona;

    @Autowired
    ProfesorService servicioProfesor;


    private String id_persona;
    private int horas_semanales;
    private String comentarios;
    private String id_profesor;
    private String branch;

//    public Student InputStudentDTO( String _id_persona, int _horas, String _comentarios, String _id_profesor, String _branch  ){
//        Student actual = new Student();
//        actual.setPersona(servicioPersona.findById(id_persona));
//        actual.setNum_hours_week(_horas);
//        actual.setComents(_comentarios);
//        //actual.setProfesor(ser);
//        actual.setBranch(_branch);
//        return actual;
//    }

    public Student InputStudentDTO( String _id_persona, int _horas,  String _branch  ) throws Exception {
        if(_id_persona == null || _branch == null || !comprobarRama(_branch) ) throw new Exception("InputStudentDTO: Faltan parámetros necesarios para la creación de un estudiante");
        Student actual = new Student();
        actual.setPersona(servicioPersona.findById(id_persona));
        actual.setNum_hours_week(_horas);
        actual.setBranch(_branch);
        return actual;
    }

    public Student transformToStudent(){
        
        Student actual = new Student();
        actual.setBranch(this.branch);
        actual.setComents(this.comentarios);
        actual.setNum_hours_week(this.horas_semanales);
        if(id_profesor != null){
            Profesor profe = new Profesor();
               //profe = servicioProfesor.findByID(id_profesor);          //FIXME ARREGLAR CON EL NUEVO MÉTODO QUE DEVUELVA UN TIPO DE LA ENTIDAD
        }else if(id_persona != null){
            Persona person = new Persona();
            person = servicioPersona.findById(id_persona);
        }
        return actual;
    }

    private boolean comprobarRama(String rame){
       if(rame.equals("Front") || rame.equals("Back") || rame.equals("FullStack")) {
           return true;
       }
       return false;
    }

    public outputStudentDTO obtenerOutputDTO(){
        outputStudentDTO out = new outputStudentDTO();

        out.setComents(this.comentarios);
        out.setBranch(this.branch);
        out.setNum_hours_week(this.horas_semanales);
        if(this.id_persona != null)out.setId_persona(Integer.parseInt(this.id_persona));
        if(this.id_profesor != null)out.setId_profesor(Integer.parseInt(this.id_profesor));
        return out;
    }


    
}
