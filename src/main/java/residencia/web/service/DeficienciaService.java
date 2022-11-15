package residencia.web.service;

import org.springframework.stereotype.Service;

import residencia.web.model.Deficiencia;
import residencia.web.repository.DeficienciaRepository;

@Service
public class DeficienciaService extends AbstractService<Deficiencia, DeficienciaRepository> {
	public DeficienciaService(DeficienciaRepository repository) {
        super(repository);
    }
	
}