package residencia.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import residencia.web.dto.EnderecoDTO;
import residencia.web.model.Endereco;
import residencia.web.service.EnderecoService;

@RestController
@RequestMapping("/endereco")
public class EnderecoController extends AbstractController<Endereco, EnderecoService, EnderecoDTO> {

    public EnderecoController(EnderecoService service) {
        super(service);
    }
}