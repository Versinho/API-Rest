package residencia.web.controller;

import org.springframework.web.bind.annotation.*;

import residencia.web.dto.ServidorDTO;
import residencia.web.model.Servidor;
import residencia.web.service.ServidorService;


@RestController
@RequestMapping("/servidor")
public class ServidorController extends AbstractController<Servidor, ServidorService, ServidorDTO> {

    public ServidorController(ServidorService service) {
        super(service);
    }
}