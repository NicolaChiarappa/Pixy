package it.nicolachiarappa.context.catalog.infrastructure.web;

import it.nicolachiarappa.context.catalog.application.dtos.ManufacturerDTO;
import it.nicolachiarappa.context.catalog.application.mappers.ManufacturerMapper;
import it.nicolachiarappa.context.catalog.application.requests.CreateManufacturerRequest;
import it.nicolachiarappa.context.catalog.application.services.ManufacturerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/manufacturer")
public class ManufacturerController {

    @Autowired
    ManufacturerMapper mapper;

    @Autowired
    ManufacturerService service;

    @PostMapping
    public ManufacturerDTO createManufacturer(@RequestBody @Valid CreateManufacturerRequest request){
        return mapper.toDTO(service.addManufacturer(request));
    }

    @GetMapping
    public List<ManufacturerDTO> getAll(){
        return service.findAll().stream()
                .map(mapper::toDTO)
                .toList();
    }





}
