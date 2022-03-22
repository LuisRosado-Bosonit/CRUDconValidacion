package App.infraestructure.ServicesImplements;

import App.infraestructure.Services.StudentService;
import App.infraestructure.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository repositorio;
}
