package App.infraestructure.ServicesImplements;

import App.domain.Estudiante_asignatura;
import App.domain.Profesor;
import App.infraestructure.Services.EstudianteAsignaturaService;
import App.infraestructure.controller.dto.input.inputEstud_AsigDTO;
import App.infraestructure.controller.dto.output.outputEstud_AsigDTO;
import App.infraestructure.controller.dto.output.outputProfesorDTO;
import App.infraestructure.repository.EstudianteAsignaturaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EstudianteAsignaturaImpl implements EstudianteAsignaturaService {

    @Autowired
    EstudianteAsignaturaRepository repositorio;

    @Override
    public void removeByID(String id) {
        log.warn("----- Se ha eliminado un elemento de la tabla de asignaturas -----");
        repositorio.deleteById(id);
    }

    @Override
    public outputEstud_AsigDTO findByID(String id) {
        outputEstud_AsigDTO out = new outputEstud_AsigDTO();
        return out.fromAsignatura(repositorio.getById(id));
    }

    @Override
    public Estudiante_asignatura internFindByID(String id) {
        return repositorio.getById(id);
    }

    @Override
    public outputEstud_AsigDTO addSubject(inputEstud_AsigDTO input) {
        log.info("----- Se ha añadido un elemento de la tabla de asignaturas -----");
        outputEstud_AsigDTO out = new outputEstud_AsigDTO();
        return out.fromAsignatura(repositorio.save(input.toEntity(input)));
    }

    @Override
    public outputEstud_AsigDTO updateByID(String id, inputEstud_AsigDTO input) {
        Estudiante_asignatura anterior = repositorio.findById(id).orElseThrow();
        outputEstud_AsigDTO out = new outputEstud_AsigDTO();
        if(input.getInitial_date() != null)anterior.setInitial_date(input.getInitial_date());
        if(input.getAsignatura() != null)anterior.setAsignatura(input.getAsignatura());
        if(input.getFinish_date() != null)anterior.setFinish_date(input.getFinish_date());
        log.warn("----- SE HA MODIFICADO LA ASIGNATURA CON ID: "+ id+" -----");
        repositorio.save(anterior);
        return out.fromAsignatura(anterior);
    }
}
