package residencia.web.controller;

import org.springframework.web.bind.annotation.*;

import residencia.web.dto.PessoaJuridicaDTO;
import residencia.web.model.PessoaJuridica;
import residencia.web.service.PessoaJuridicaService;


@RestController
@RequestMapping("/pessoajuridica")
public class PessoaJuridicaController extends AbstractController<PessoaJuridica, PessoaJuridicaService, PessoaJuridicaDTO> {

    public PessoaJuridicaController(PessoaJuridicaService service) {
        super(service);
    }
}