package App.infraestructure.ServicesImplements;

import App.domain.Profesor;
import App.infraestructure.Services.ProfesorService;
import App.infraestructure.controller.dto.input.inputProfesorDTO;
import App.infraestructure.controller.dto.output.outputProfesorDTO;
import App.infraestructure.repository.ProfesorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProfesorServiceImpl implements ProfesorService {
    @Autowired
    ProfesorRepository repositorio;

    @Override
    public Profesor findByID(String id) {
        System.out.println("Accediendo el método de búsqueda por ID del servicio profesor");
        return repositorio.findById(id).get();
    }

    @Override
    public outputProfesorDTO addFromPersona(Profesor profesor) {
        outputProfesorDTO out = new outputProfesorDTO();
        log.warn("----- SE HA AÑADIDO UN PROFESOR A LA BBDD -----");
        return out.fromEntity(repositorio.save(profesor));
    }


}
