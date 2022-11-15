package residencia.web.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import residencia.web.dto.AbstractDTO;

public interface IGenericController <D extends AbstractDTO>{

    List<D> findAll(Integer page);
    D create(D dto);
    ResponseEntity<D> findById(Integer id);
    ResponseEntity<D> update(Integer id, D dto);
    ResponseEntity<?> delete(Integer id);
    
}