package residencia.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import residencia.web.dto.LoginDTO;
import residencia.web.dto.TokenDTO;
import residencia.web.service.TokenService;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private AuthenticationManager authenticationManager;
    private TokenService tokenService;
    
    AuthenticationController(AuthenticationManager authenticationManager, TokenService tokenService){
    	this.authenticationManager = authenticationManager;
    	this.tokenService = tokenService;
    }


    @PostMapping
    public ResponseEntity<TokenDTO> auth(@RequestBody @Validated LoginDTO loginDTO){

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(loginDTO.getUsername(), loginDTO.getPassword());

        try{
            Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
            String token = tokenService.generateToken(authentication);
            return ResponseEntity.ok(new TokenDTO("Bearer", token));

        } catch (Exception e){
            throw new UsernameNotFoundException("Username not found") ;
        }
    }

}