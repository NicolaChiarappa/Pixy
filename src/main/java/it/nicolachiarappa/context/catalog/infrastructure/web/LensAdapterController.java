package it.nicolachiarappa.context.catalog.infrastructure.web;

import it.nicolachiarappa.context.catalog.application.requests.LensAdapterRequest;
import it.nicolachiarappa.context.catalog.application.services.LensAdapterService;
import it.nicolachiarappa.context.catalog.domain.models.LensAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/adapter")
public class LensAdapterController {

    @Autowired
    LensAdapterService service;

    @PostMapping()
    public LensAdapter createLensAdapter(@RequestBody LensAdapterRequest request){
        System.out.println(request);
        return service.addLensAdapter(request);
    }

}
