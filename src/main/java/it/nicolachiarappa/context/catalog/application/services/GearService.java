package it.nicolachiarappa.context.catalog.application.services;

import it.nicolachiarappa.context.catalog.application.dtos.CameraDto;
import it.nicolachiarappa.context.catalog.application.requests.CreateCameraRequest;
import it.nicolachiarappa.context.catalog.application.requests.CreateLensRequest;
import it.nicolachiarappa.context.catalog.application.requests.GearRequest;
import it.nicolachiarappa.context.catalog.application.requests.UpgradeGearRequest;
import it.nicolachiarappa.context.catalog.domain.models.Camera;
import it.nicolachiarappa.context.catalog.domain.models.Lens;

import java.util.List;

public interface GearService {



    Camera addCamera(CreateCameraRequest request);

    void removeCamera(GearRequest request);

    Camera getCameraById(Long id);



    Lens addLens(CreateLensRequest request);

    void removeLens(GearRequest request);

    Lens getLensById(Long id);

    List<CameraDto> upgradeCamera(UpgradeGearRequest request);

    void upgradeLens(UpgradeGearRequest request);


    void cameraOutOfProduction(GearRequest request);

    void lensOutOfProduction(GearRequest request);

}
