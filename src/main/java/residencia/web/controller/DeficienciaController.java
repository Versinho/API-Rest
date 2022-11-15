package residencia.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import residencia.web.dto.DeficienciaDTO;
import residencia.web.model.Deficiencia;
import residencia.web.service.DeficienciaService;

@RestController
@RequestMapping("/deficiencia")
public class DeficienciaController extends AbstractController<Deficiencia, DeficienciaService, DeficienciaDTO> {

    public DeficienciaController(DeficienciaService service) {
        super(service);
    }
}