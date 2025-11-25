package it.nicolachiarappa.context.catalog.application.services;

import it.nicolachiarappa.context.catalog.application.requests.CreateCameraRequest;
import it.nicolachiarappa.context.catalog.application.requests.CreateLensRequest;
import it.nicolachiarappa.context.catalog.application.requests.GearRequest;
import it.nicolachiarappa.context.catalog.application.requests.UpgradeGearRequest;
import it.nicolachiarappa.context.catalog.domain.model.Camera;

public interface GearService {



    Camera addCamera(CreateCameraRequest request);

    void removeCamera(GearRequest request);


    void addLens(CreateLensRequest request);

    void removeLens(GearRequest request);


    void upgradeCamera(UpgradeGearRequest request);

    void upgradeLens(UpgradeGearRequest request);


    void cameraOutOfProduction(GearRequest request);

    void lensOutOfProduction(GearRequest request);

}
