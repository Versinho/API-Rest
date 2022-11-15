package residencia.web.dto;
import org.springframework.hateoas.RepresentationModel;

import residencia.web.model.AbstractEntity;


public abstract class AbstractDTO<E extends AbstractEntity> extends RepresentationModel<AbstractDTO<E>> {
    public abstract E convertToEntity();
    
}
