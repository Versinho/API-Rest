package residencia.web.service;

import org.springframework.stereotype.Service;

import residencia.web.model.PessoaJuridica;
import residencia.web.repository.PessoaJuridicaRepository;

@Service
public class PessoaJuridicaService extends AbstractService<PessoaJuridica, PessoaJuridicaRepository> {
	public PessoaJuridicaService(PessoaJuridicaRepository repository) {
        super(repository);
    }
	
}
