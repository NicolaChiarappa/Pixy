package it.nicolachiarappa.context.catalog.infrastructure.web;

import it.nicolachiarappa.context.catalog.application.dtos.CameraDTO;
import it.nicolachiarappa.context.catalog.application.mappers.CameraMapper;
import it.nicolachiarappa.context.catalog.application.requests.CreateCameraRequest;
import it.nicolachiarappa.context.catalog.application.services.GearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/camera")
public class CameraController {

    @Autowired
    GearService service;
    @Autowired
    private CameraMapper cameraMapper;

    @PostMapping
    public CameraDTO createCamera(@RequestBody CreateCameraRequest request){
        return cameraMapper.toDTO(service.addCamera(request));
    }

}
