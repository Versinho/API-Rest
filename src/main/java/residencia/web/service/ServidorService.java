package residencia.web.service;

import org.springframework.stereotype.Service;

import residencia.web.model.Servidor;
import residencia.web.repository.ServidorRepository;

@Service
public class ServidorService extends AbstractService<Servidor, ServidorRepository> {
	public ServidorService(ServidorRepository repository) {
        super(repository);
    }
	
}
