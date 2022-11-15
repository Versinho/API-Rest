package residencia.web.repository;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import residencia.web.model.AbstractEntity;

public interface GenericRepository<E extends AbstractEntity> extends JpaRepository<E, Integer> {
}