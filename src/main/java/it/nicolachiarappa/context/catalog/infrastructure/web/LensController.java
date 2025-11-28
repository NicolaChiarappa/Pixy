package it.nicolachiarappa.context.catalog.infrastructure.web;

import it.nicolachiarappa.context.catalog.application.dtos.LensDTO;
import it.nicolachiarappa.context.catalog.application.mappers.LensMapper;
import it.nicolachiarappa.context.catalog.application.requests.CreateLensRequest;
import it.nicolachiarappa.context.catalog.application.services.GearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/lens")
public class LensController {

    @Autowired
    GearService service;
    @Autowired
    LensMapper mapper;

    @PostMapping
    public LensDTO createLens(@RequestBody CreateLensRequest request){
        System.out.println(request);
        return mapper.toDTO(service.addLens(request));
    }
}
