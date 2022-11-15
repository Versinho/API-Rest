package residencia.web.service;

import java.util.Collections;
import java.util.Optional;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import residencia.web.model.Usuario;
import residencia.web.repository.UsuarioRepository;

@Service
public class UsuarioService implements UserDetailsService {

    
    protected final UsuarioRepository repository;
    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> optional = repository.findUsuarioByUsername(username);

        if(optional.isPresent()) {
            return new org.springframework.security.core.userdetails.User(optional.get().getUsername(), encoder().encode(optional.get().getPassword()), Collections.singletonList(new SimpleGrantedAuthority(optional.get().getRole())));
        }

        throw new UsernameNotFoundException("User not found");
    }

    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}