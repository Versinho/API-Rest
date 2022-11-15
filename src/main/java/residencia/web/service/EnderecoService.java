package residencia.web.service;

import org.springframework.stereotype.Service;

import residencia.web.model.Endereco;
import residencia.web.repository.EnderecoRepository;

@Service
public class EnderecoService extends AbstractService<Endereco, EnderecoRepository> {
	public EnderecoService(EnderecoRepository repository) {
        super(repository);
    }
	
}