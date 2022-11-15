package residencia.web.service;

import org.springframework.stereotype.Service;

import residencia.web.model.PessoaFisica;
import residencia.web.repository.PessoaFisicaRepository;

@Service
public class PessoaFisicaService extends AbstractService<PessoaFisica, PessoaFisicaRepository> {
	public PessoaFisicaService(PessoaFisicaRepository repository) {
        super(repository);
    }
	
}
