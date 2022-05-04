package App.infraestructure;

import App.domain.Persona;
import App.infraestructure.Services.PersonaService;
import App.infraestructure.controller.dto.input.inputPersonaDTO;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class PersonaController  {
    @Autowired
    PersonaService persona;   //Es una mala práctica ??

    //Esta clase es la primera de la que hice un CRUD, por eso es tan primitivo y poco sólido,
    // la he dejado intacta a posta


    @ResponseStatus(HttpStatus.OK)
    @GetMapping("persona/{ID}")
    public ResponseEntity<Persona> buscarPorID(@PathVariable String ID){
        //if(persona.findById(ID) == null) return CustomizeNotFoundException(ChangeSetPersister.NotFoundException() );
        if(persona.findById(ID) == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(persona.findById(ID));
        return ResponseEntity.status(HttpStatus.OK).body(persona.findById(ID));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("persona/getByUser")
    public ResponseEntity<List<Persona>> buscarPorName(@RequestParam String name){
        return ResponseEntity.status(HttpStatus.OK).body(persona.findByUsuario(name));
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("persona/add")
    public ResponseEntity<inputPersonaDTO> addPerson(@RequestBody inputPersonaDTO dto) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(persona.guardarPersona(dto));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("persona/getAll")
    public ResponseEntity<List<Persona>> showAllRegisters(){
        return ResponseEntity.status(HttpStatus.OK).body(persona.showAll());
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/user")
    public ResponseEntity<String> login(@RequestParam("user") String username, @RequestParam("password") String pwd) {
        String rol = "USER";
        if (persona.auth(username, pwd)) rol = "ADMIN" ;
        System.out.println("El rol definido es "+rol);
        return ResponseEntity.status(HttpStatus.OK).body(getJWTToken(username, "ROLE_"+rol));

    }

    private String getJWTToken(String username, String rol) {
        String secretKey = "mySecretKeymySecretKeymySecretKeymySecretKeymySecretKeymySecretKey";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList(rol);

        String token = Jwts
                .builder()
                .setId("softtekJWT")
                .setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();

        return token;
    }
}
