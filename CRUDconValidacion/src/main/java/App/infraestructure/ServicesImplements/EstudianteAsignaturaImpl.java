package App.infraestructure.ServicesImplements;

import App.infraestructure.Services.EstudianteAsignaturaService;
import App.infraestructure.repository.EstudianteAsignaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstudianteAsignaturaImpl implements EstudianteAsignaturaService {

    @Autowired
    EstudianteAsignaturaRepository repositorio;

}
