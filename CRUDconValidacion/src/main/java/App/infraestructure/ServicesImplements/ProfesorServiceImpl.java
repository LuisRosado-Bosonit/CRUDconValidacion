package App.infraestructure.ServicesImplements;

import App.domain.Profesor;
import App.infraestructure.Services.ProfesorService;
import App.infraestructure.controller.dto.input.inputProfesorDTO;
import App.infraestructure.controller.dto.output.outputProfesorDTO;
import App.infraestructure.repository.ProfesorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class ProfesorServiceImpl implements ProfesorService {
    @Autowired
    ProfesorRepository repositorio;

    @Override
    public outputProfesorDTO findByID(String id) throws Exception {
        if(id == null )throw new Exception("Profesor::findByID: Se ha introducido un ID vacío");
        System.out.println("----- Accediendo el método de búsqueda por ID del servicio profesor -----");
        outputProfesorDTO out = new outputProfesorDTO();
        Optional<Profesor> aux = repositorio.findById(id);
        if(!aux.isPresent()){
            log.error("----- La consulta del profesor con ID: "+id+" no ha devuelto ningún resultado -----");
            throw new Exception("La consulta no ha devuelto ningún resultado");
        }
        return out.fromEntity(repositorio.findById(id).get()) ;
    }
      
    @Override
    public outputProfesorDTO addFromPersona(Profesor profesor) {
        outputProfesorDTO out = new outputProfesorDTO();
        log.warn("----- SE HA AÑADIDO UN PROFESOR A LA BBDD -----");
        return out.fromEntity(repositorio.save(profesor));
    }

    @Override
    public void removeByID(String id) {
        outputProfesorDTO out = new outputProfesorDTO();
        log.warn("----- SE VA A ELIMINAR AL OBJETO PROFESOR CUYO ID ES: "+id);
        repositorio.deleteById(id);
    }

    @Override
    public outputProfesorDTO updateByID(String id, inputProfesorDTO dto) {
        Profesor anterior = repositorio.findById(id).orElseThrow();
        outputProfesorDTO out = new outputProfesorDTO();
        if(dto.getComents() != null) anterior.setComents(dto.getComents());
        if(dto.getBranch() != null) anterior.setBranch(dto.getBranch());
        log.warn("----- SE HA MODIFICADO AL PROFESOR CON ID: "+ id+" -----");
        repositorio.save(anterior);
        return out.fromEntity(anterior);
    }


}
