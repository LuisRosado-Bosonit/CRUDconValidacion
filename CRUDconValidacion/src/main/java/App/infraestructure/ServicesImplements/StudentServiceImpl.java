package App.infraestructure.ServicesImplements;

import App.domain.Estudiante_asignatura;
import App.domain.Student;
import App.infraestructure.Services.EstudianteAsignaturaService;
import App.infraestructure.Services.StudentService;
import App.infraestructure.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository repositorio;
    @Autowired
    EstudianteAsignaturaService servicioAsignaturas;

    @Override
    public Student findByID(String ID) {
        log.info("-----Se ha producido una búsqueda en la  tabla Student por el ID"+ID+"-----");
        return repositorio.getById(ID);
    }

    @Override
    public Student addStudent(Student estudiante) {
        log.info("----- Se ha producido una inserción en la BBDD de la entidad Student -----");
        return repositorio.save(estudiante);
    }

    @Override
    public boolean findByPersonaId(String ID) {
        return repositorio.findPersonaByID(ID) != null;
    }

    @Override
    public List<Estudiante_asignatura> addAsignaturas(String id,List<String> id_asignaturas) {
        Student estudiante = repositorio.getById(id);
        id_asignaturas.forEach(s -> {estudiante.addSubject(servicioAsignaturas.internFindByID(s));});
        return repositorio.save(estudiante).getAsignaturas();
    }

    @Override
    public boolean removeAsignaturas(String id,List<String> id_asignaturas) {
        Student estudiante = repositorio.getById(id);
        List<Estudiante_asignatura> lista = estudiante.getAsignaturas();
        id_asignaturas.forEach(s -> {try{
            lista.remove(servicioAsignaturas.internFindByID(s));
        } catch (Exception e) {
            log.error("----- Se ha intentado eliminar una asignatura que no pertenecía a un estudiante -----");
            e.printStackTrace();
        }});
        return true;
    }
}
