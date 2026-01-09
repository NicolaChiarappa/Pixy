package it.nicolachiarappa.context.catalog.infrastructure.web;

import it.nicolachiarappa.context.catalog.application.dtos.MountDto;
import it.nicolachiarappa.context.catalog.application.mappers.MountMapper;
import it.nicolachiarappa.context.catalog.application.requests.MountRequest;
import it.nicolachiarappa.context.catalog.application.services.MountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/mount")
public class MountController {

    @Autowired
    MountService service;


    @PostMapping()
    public MountDto createMount(@RequestBody MountRequest request){
        return service.create(request);
    }




}
