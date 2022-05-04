package App.infraestructure.repository;

import App.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, String> {
      public List<Persona> findByUsuario(String user);

      @Query(value = "SELECT p FROM Persona p WHERE p.usuario = ?1 AND p.password = ?2")
      public Persona findUserAndPass(String user, String pwd);
}
