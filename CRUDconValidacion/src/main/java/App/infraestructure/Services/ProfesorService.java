package App.infraestructure.Services;

import App.domain.Profesor;
import App.infraestructure.repository.ProfesorRepository;

public interface ProfesorService {
    public Profesor findByID(String id);
}
