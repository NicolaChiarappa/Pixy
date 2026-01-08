package it.nicolachiarappa.context.catalog.infrastructure.web;

import it.nicolachiarappa.context.catalog.application.dtos.LensDto;
import it.nicolachiarappa.context.catalog.application.mappers.LensMapper;
import it.nicolachiarappa.context.catalog.application.requests.CreateLensRequest;
import it.nicolachiarappa.context.catalog.application.services.GearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/lens")
public class LensController {

    @Autowired
    GearService service;
    @Autowired
    LensMapper mapper;

    @PostMapping
    public LensDto createLens(@RequestBody CreateLensRequest request){
        System.out.println(request);
        return mapper.toDTO(service.addLens(request));
    }

    @GetMapping("/{id}")
    public LensDto getLensById(@PathVariable Long id){
        return mapper.toDTO(service.getLensById(id));
    }
}
