package residencia.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import residencia.web.filter.TokenAuthenticationFilter;
import residencia.web.repository.UsuarioRepository;
import residencia.web.service.TokenService;
import residencia.web.service.UsuarioService;


/*
The prePostEnabled property enables Spring Security pre/post annotations.
The securedEnabled property determines if the @Secured annotation should be enabled.
The jsr250Enabled property allows us to use the @RoleAllowed annotation.
*/
@Configuration
@EnableWebSecurity
public class SecurityConfiguration{

 
    private TokenService tokenService;
    private UsuarioRepository repository;
    

    public SecurityConfiguration(TokenService tokenService, UsuarioRepository repository) {
		super();
		this.tokenService = tokenService;
		this.repository = repository;
	}

	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeRequests()
        .antMatchers(HttpMethod.POST, "/auth").permitAll()
        .antMatchers("/h2/**").permitAll()
        .anyRequest().authenticated()
        .and().headers().frameOptions().sameOrigin()
        .and().csrf().disable()
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
        .addFilterBefore(new TokenAuthenticationFilter(tokenService, repository), UsernamePasswordAuthenticationFilter.class);
		return http.build();
}

    @Bean
    public AuthenticationManager authManager(HttpSecurity http, UsuarioService usuarioService) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(usuarioService)
                .passwordEncoder(new BCryptPasswordEncoder())
                .and()
                .build();
    }

}