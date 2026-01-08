package it.nicolachiarappa.context.catalog.infrastructure.web;

import it.nicolachiarappa.context.catalog.application.dtos.CameraDto;
import it.nicolachiarappa.context.catalog.application.mappers.CameraMapper;
import it.nicolachiarappa.context.catalog.application.requests.CreateCameraRequest;
import it.nicolachiarappa.context.catalog.application.requests.UpgradeGearRequest;
import it.nicolachiarappa.context.catalog.application.services.GearService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/camera")
public class CameraController {

    @Autowired
    GearService service;
    @Autowired
    private CameraMapper cameraMapper;

    @PostMapping
    public CameraDto createCamera(@RequestBody CreateCameraRequest request){
        return cameraMapper.toDTO(service.addCamera(request));
    }

    @PatchMapping
    public List<?> setSuccessor(@RequestBody @Valid UpgradeGearRequest request){
        return service.upgradeCamera(request);
    }

    @GetMapping("/{id}")
    public CameraDto getCameraById(@PathVariable Long id){
        return cameraMapper.toDTO(service.getCameraById(id));
    }

}
