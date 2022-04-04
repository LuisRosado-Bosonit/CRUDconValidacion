package Persona.infraestructure.repository;

import Persona.domain.Persona;
import Persona.infraestructure.controller.dto.input.inputPersonaDTO;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.patterns.PerObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;



@Slf4j
@Service
public class PersonaServiceImpl implements PersonaService {
    @Autowired
          PersonaRepository repositorio;

    @Autowired
        EntityManager entityManager;


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
    public List<Persona> getData(HashMap<String, Object> condiciones) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Persona> query= cb.createQuery(Persona.class);
        Root<Persona> root = query.from(Persona.class);

        List<Predicate> predicates = new ArrayList<>();
        condiciones.forEach((field,value) ->
        {
            switch (field)
            {
                case "usuario":
                    predicates.add(cb.equal(root.get(field), (String)value));
                    break;
                case "name":
                    predicates.add(cb.like(root.get(field),"%"+(String)value+"%"));
                    break;
                case "surname":
                    predicates.add(cb.like(root.get(field),"%"+(String)value+"%"));
                    break;
                case "created_date":
                    String dateCondition=(String) condiciones.get("dateCondition");
                    switch (dateCondition)
                    {
                        case "less":
                            predicates.add(cb.lessThan(root.<Date>get(field),(Date)value));
                            break;
                        default:
                            predicates.add(cb.greaterThan(root.<Date>get(field),(Date)value));
                            break;
                    }
                    break;
            }

        });
        log.info("----- Se procede a hacer una consulta parametrizada a la entidad Persona -----");
        query.select(root).where(predicates.toArray(new Predicate[predicates.size()]));
        return entityManager.createQuery(query).getResultList();
    }
}
