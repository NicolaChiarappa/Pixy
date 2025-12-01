package it.nicolachiarappa.context.catalog.application.services;

import it.nicolachiarappa.context.catalog.application.dtos.CameraDTO;
import it.nicolachiarappa.context.catalog.application.mappers.CameraMapper;
import it.nicolachiarappa.context.catalog.application.mappers.LensMapper;
import it.nicolachiarappa.context.catalog.application.requests.CreateCameraRequest;
import it.nicolachiarappa.context.catalog.application.requests.CreateLensRequest;
import it.nicolachiarappa.context.catalog.application.requests.GearRequest;
import it.nicolachiarappa.context.catalog.application.requests.UpgradeGearRequest;
import it.nicolachiarappa.context.catalog.domain.model.*;
import it.nicolachiarappa.context.catalog.domain.repository.CameraRepository;
import it.nicolachiarappa.context.catalog.domain.repository.LensRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class GearServiceImpl implements GearService {

    @Autowired
    private CameraRepository cameraRepository;

    @Autowired
    private LensRepository lensRepository;


    @Autowired
    private CameraMapper cameraMapper;

    @Autowired
    private LensMapper lensMapper;


    @Override
    public Camera addCamera(@Valid CreateCameraRequest request) {
        Camera camera = cameraMapper.fromCreateRequest(request);
        return cameraRepository.save(camera);
    }

    @Override
    public void removeCamera(GearRequest request) {
        cameraRepository.deleteById(request.getId());
    }

    @Override
    public Camera getCameraById(Long id) {
        return cameraRepository.findById(id).orElseThrow();
    }

    @Override
    public Lens addLens(@Valid @NotNull CreateLensRequest request) {

        System.out.println(request);
        Lens lens = lensMapper.fromCreateRequest(request);
        return lensRepository.save(lens);
    }

    @Override
    public void removeLens(GearRequest request) {
        lensRepository.deleteById(request.getId());
    }

    @Override
    public Lens getLensById(Long id) {
        return lensRepository.findById(id).orElseThrow();
    }


    @Override
    @Transactional
    public List<CameraDTO> upgradeCamera(@Valid UpgradeGearRequest request) {
        Camera oldCamera = cameraRepository.getReferenceById(request.getOldId());
        Camera newCamera = cameraRepository.getReferenceById(request.getNewId());

        oldCamera.upgrade(newCamera);

        List<CameraDTO> list = new ArrayList<>();

        list.add(
                cameraMapper.toDTO(cameraRepository.save(oldCamera))
        );

        list.add(
                cameraMapper.toDTO(cameraRepository.save(newCamera))
        );

        return list;



    }


    @Override
    @Transactional
    public void upgradeLens(@Valid UpgradeGearRequest request) {
        Lens oldLens = lensRepository.getReferenceById(request.getOldId());
        Lens newLens = lensRepository.getReferenceById(request.getNewId());

        oldLens.upgrade(newLens);

        lensRepository.save(oldLens);
        lensRepository.save(newLens);
    }

    @Override
    public void cameraOutOfProduction(GearRequest request) {
        Camera camera = cameraRepository.getReferenceById(request.getId());
        camera.setOutOfProduction();
        cameraRepository.save(camera);
    }

    @Override
    public void lensOutOfProduction(GearRequest request) {
        Lens lens = lensRepository.getReferenceById(request.getId());
        lens.setOutOfProduction();
        lensRepository.save(lens);
    }





}
