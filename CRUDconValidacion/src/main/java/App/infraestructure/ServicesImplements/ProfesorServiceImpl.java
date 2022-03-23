package App.infraestructure.ServicesImplements;

import App.domain.Profesor;
import App.infraestructure.Services.ProfesorService;
import App.infraestructure.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfesorServiceImpl implements ProfesorService {
    @Autowired
    ProfesorRepository repositorio;

    @Override
    public Profesor findByID(String id) {
        return repositorio.findById(id).get();
    }
}
