package App.infraestructure.ServicesImplements;

import App.domain.Student;
import App.infraestructure.Services.StudentService;
import App.infraestructure.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository repositorio;

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
}
