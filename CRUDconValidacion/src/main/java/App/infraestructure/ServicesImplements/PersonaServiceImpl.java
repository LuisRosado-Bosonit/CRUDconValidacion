package App.infraestructure.ServicesImplements;

import App.domain.Persona;
import App.infraestructure.Services.PersonaService;
import App.infraestructure.controller.dto.input.inputPersonaDTO;
import App.infraestructure.repository.PersonaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class PersonaServiceImpl implements PersonaService {
    @Autowired
    PersonaRepository repositorio;


    public Persona findById(String ID){
       return  repositorio.findById(ID).orElseThrow();
    }

    public List<Persona> findByUsuario(String nombre){
        log.info("--------- Se ha realizado una consulta la base de datos filtrando por usuario ---------");
        return repositorio.findByUsuario(nombre);
    }

    public inputPersonaDTO guardarPersona(inputPersonaDTO dto) throws Exception {
        repositorio.save(dto.transformDTOtoPersona());
        log.warn("--------- Se ha añadido un nuevo usuario a la base de datos ---------");
        return dto;
    }

    public List<Persona> showAll(){
        log.warn("--------- Se ha realizado una consulta completa de la tabla ---------");
        return repositorio.findAll();
    }

    @Override
    public boolean auth(String nick, String pwd) {
        Persona p;
        p = new Persona();
        log.warn("--------- Se está comprobando la existencia de un usuario y contraseña de la tabla Persona ---------");
        p = repositorio.findUserAndPass(nick,pwd);
        if(p != null){
           // System.out.println("----------EL RESULTADO DE BUSCAR USUARIO Y CONTRASEÑA ES "+ p );
            return p.isAdmin();
        }
        return false;
    }
}
