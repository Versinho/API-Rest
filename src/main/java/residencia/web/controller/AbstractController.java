package residencia.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import residencia.web.dto.AbstractDTO;
import residencia.web.model.AbstractEntity;
import residencia.web.service.AbstractService;

import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractController<E extends AbstractEntity, S extends AbstractService, D extends AbstractDTO<E>> implements IGenericController<D>{

    protected final S service;

    public AbstractController(S service) {
        this.service = service;
    }


    @Override
    @GetMapping
    public List<D> findAll(@RequestParam(defaultValue= "0", required=false) Integer page) {
    	List<E> list = (List<E>) service.listAll(page);
        return list.stream().map( record -> (D) record.convertToDto())
                .collect(Collectors.toList());
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public D create(@RequestBody D dto) {
    	E entity = (E)dto.convertToEntity();
        return (D) ((E)service.create(entity)).convertToDto();
        
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<D> findById(@PathVariable Integer id) {
    	return ResponseEntity.ok().body((D)((E)service.findById(id)).convertToDto());
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<D> update(@PathVariable Integer id, @RequestBody D dto) {
        /*if(!Objects.equals(id, e.getId())){
            return ResponseEntity.badRequest().build();
        }*/
        E entity = dto.convertToEntity();
        entity.setId(id);

        return (ResponseEntity<D>) service.update(id, entity)
                .map( record ->ResponseEntity.ok().body( ((E) record).convertToDto() ))
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        E e = (E) service.findById(id);
        service.delete(id);
        return ResponseEntity.status(202).build();
    }
}