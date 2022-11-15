package residencia.web.controller;

import org.springframework.web.bind.annotation.*;

import residencia.web.dto.PessoaFisicaDTO;
import residencia.web.model.PessoaFisica;
import residencia.web.service.PessoaFisicaService;


@RestController
@RequestMapping("/pessoafisica")
public class PessoaFisicaController extends AbstractController<PessoaFisica, PessoaFisicaService, PessoaFisicaDTO> {

    public PessoaFisicaController(PessoaFisicaService service) {
        super(service);
    }
}