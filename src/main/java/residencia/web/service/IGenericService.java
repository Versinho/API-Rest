package residencia.web.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import residencia.web.model.AbstractEntity;

public interface IGenericService<E extends AbstractEntity> {
	
	List<E> listAll(Integer page);
    E create(E e);
    E findById(Integer id);
    Optional<E> update(Integer id, E e);
    void delete(Integer id);
}