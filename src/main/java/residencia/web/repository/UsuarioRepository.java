package residencia.web.repository;

import java.util.Optional;

import residencia.web.model.Usuario;

public interface UsuarioRepository extends GenericRepository<Usuario>{
	Optional<Usuario> findUsuarioByUsername(String username);
}
