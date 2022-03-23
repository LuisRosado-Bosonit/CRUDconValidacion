package App.infraestructure.controller.dto.input;

import App.domain.Student;
import App.infraestructure.Services.PersonaService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public class InputStudentDTO {
    @Autowired
    PersonaService servicioPersona;

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

    private boolean comprobarRama(String rame){
       if(rame.equals("Front") || rame.equals("Back") || rame.equals("FullStack")) {
           return true;
       }
       return false;
    }


    
}