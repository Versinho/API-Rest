package residencia.web.filter;

import residencia.web.model.Usuario;
import residencia.web.repository.UsuarioRepository;
import residencia.web.service.TokenService;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Optional;


public class TokenAuthenticationFilter extends OncePerRequestFilter {

	private final TokenService tokenService;
    private final UsuarioRepository repository;
    
    public TokenAuthenticationFilter(TokenService tokenService, UsuarioRepository repository){
    	super();
    	this.tokenService = tokenService;
    	this.repository = repository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String tokenFromHeader = getTokenFromHeader(request);
        boolean tokenValid = tokenService.isTokenValid(tokenFromHeader);
        if(tokenValid) {
            this.authenticate(tokenFromHeader);
        }

        filterChain.doFilter(request, response);
    }

    private void authenticate(String tokenFromHeader) {
        String username = tokenService.getTokenUsername(tokenFromHeader);

        Optional<Usuario> optionalUser = repository.findUsuarioByUsername(username);

        if(optionalUser.isPresent()) {
            Usuario usuario = optionalUser.get();

            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(usuario, null, Collections.singletonList(new SimpleGrantedAuthority(usuario.getRole())));
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        }
    }

    private String getTokenFromHeader(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if(token == null || !token.startsWith("Bearer ")) {
            return null;
        }

        return token.substring("Bearer ".length());
    }
}