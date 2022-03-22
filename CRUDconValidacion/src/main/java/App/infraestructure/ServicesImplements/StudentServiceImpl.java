package App.infraestructure.ServicesImplements;

import App.domain.Student;
import App.infraestructure.Services.StudentService;
import App.infraestructure.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
@Slf4j
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository repositorio;

    @Override
    public Student findByID(String ID) {
        log.info("-----Se ha producido una búsqueda en la  tabla Student por el ID"+ID+"-----");
        return repositorio.getById(ID);
    }
}
