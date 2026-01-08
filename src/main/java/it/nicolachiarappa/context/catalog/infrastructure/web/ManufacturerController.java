package it.nicolachiarappa.context.catalog.infrastructure.web;

import it.nicolachiarappa.context.catalog.application.dtos.ManufacturerDto;
import it.nicolachiarappa.context.catalog.application.mappers.ManufacturerMapper;
import it.nicolachiarappa.context.catalog.application.requests.CreateManufacturerRequest;
import it.nicolachiarappa.context.catalog.application.services.ManufacturerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/manufacturer")
public class ManufacturerController {

    @Autowired
    ManufacturerMapper mapper;

    @Autowired
    ManufacturerService service;

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ManufacturerDto createManufacturer(@RequestBody @Valid CreateManufacturerRequest request){
        return  service.create(request);
    }

    @GetMapping
    public ManufacturerDto getManufacturerById(Long id){
        return mapper.toDto(service.findByIdOrThrow(id));
    }





}
