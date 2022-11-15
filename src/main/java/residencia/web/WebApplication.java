package residencia.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import residencia.web.model.Usuario;
import residencia.web.repository.UsuarioRepository;

import javax.annotation.PostConstruct;


@SpringBootApplication
public class WebApplication {
	
	/*@Autowired
    private UsuarioRepository repository;

    @PostConstruct
    public void initUsers() {
        
        Usuario user = new Usuario("Goro", "admin", "ROLE_ADMIN");
       

        repository.save(user);

    }*/
	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
	}

}
