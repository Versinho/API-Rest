package residencia.web.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.support.PagedListHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.persistence.EntityNotFoundException;
import residencia.web.model.AbstractEntity;
import residencia.web.repository.GenericRepository;

public abstract class AbstractService<E extends AbstractEntity, R extends GenericRepository<E>> implements IGenericService<E>{

    protected final R repository;

    public AbstractService(R repository) {
        this.repository = repository;
    }

    @Override
    public List<E> listAll(Integer page) {
    	int size = 5;
    	PagedListHolder elements = new PagedListHolder(repository.findAll()/*.stream().filter(e -> !e.getDeleted()).collect(Collectors.toList())*/);
        elements.setPage(page);
        elements.setPageSize(size);
        return (List<E>) elements.getPageList();
        //return repository.findAll();
    }

    @Override
    public E create(E e) {
        return repository.save(e);
    }

    @Override
    public E findById(Integer id) {
        Optional<E> entity = repository.findById(id);
        if (entity.isPresent() /*&& !entity.get().getDeleted()*/) return entity.get();
        //else if (entity.get().getDeleted()) throw new EntityNotFoundException("Entity with id " + id + " has been deleted.");
        else throw new EntityNotFoundException("Entity with id " + id + " not found.");
    }

    @Override
    public Optional<E> update(Integer id, E e) {
    	return repository
                .findById(id)
                .map(record -> {
                    repository.saveAndFlush(e);
                    return record;
                });
    }

    @Override
    public void delete(Integer id) {
    	E entity = repository.findById(id).get();
    	entity.setDeleted(true);
    	repository.saveAndFlush(entity);
    	
    }
}