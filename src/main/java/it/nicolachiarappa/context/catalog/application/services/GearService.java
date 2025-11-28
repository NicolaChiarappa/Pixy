package it.nicolachiarappa.context.catalog.application.services;

import it.nicolachiarappa.context.catalog.application.dtos.CameraDTO;
import it.nicolachiarappa.context.catalog.application.requests.CreateCameraRequest;
import it.nicolachiarappa.context.catalog.application.requests.CreateLensRequest;
import it.nicolachiarappa.context.catalog.application.requests.GearRequest;
import it.nicolachiarappa.context.catalog.application.requests.UpgradeGearRequest;
import it.nicolachiarappa.context.catalog.domain.model.Camera;

import java.util.List;

public interface GearService {



    Camera addCamera(CreateCameraRequest request);

    void removeCamera(GearRequest request);


    void addLens(CreateLensRequest request);

    void removeLens(GearRequest request);


    List<CameraDTO> upgradeCamera(UpgradeGearRequest request);

    void upgradeLens(UpgradeGearRequest request);


    void cameraOutOfProduction(GearRequest request);

    void lensOutOfProduction(GearRequest request);

}
