package App.infraestructure.controller.dto.input;

import App.domain.Estudiante_asignatura;
import App.domain.Persona;
import App.domain.Profesor;
import App.domain.Student;
import App.infraestructure.Services.PersonaService;
import App.infraestructure.Services.ProfesorService;
import App.infraestructure.controller.dto.output.outputStudentDTOfull;
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
    private String asignatura;

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

    public Student transformToStudent(Persona _persona, Profesor profesor, Estudiante_asignatura _asignatura){

        Student actual = new Student();
        actual.setBranch(this.branch);
        actual.setComents(this.comentarios);
        actual.setNum_hours_week(this.horas_semanales);
        if(_persona!=null)actual.setPersona(_persona);
        if(profesor!=null)actual.setProfesor(profesor);
        actual.addSubject(_asignatura);
        return actual;
    }

    private boolean comprobarRama(String rame){
       if(rame.equals("Front") || rame.equals("Back") || rame.equals("FullStack")) {
           return true;
       }
       return false;
    }

    public outputStudentDTOfull obtenerOutputDTO(Student estudiante){
        outputStudentDTOfull out = new outputStudentDTOfull();

        out.setId_student(estudiante.getId_student());
        out.setComents(estudiante.getComents());
        out.setBranch(estudiante.getBranch());
        out.setNum_hours_week(estudiante.getNum_hours_week());
        out.setPerson(estudiante.getPersona());
        out.setProfe(estudiante.getProfesor());
        return out;
    }


    
}
