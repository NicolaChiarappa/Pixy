package it.nicolachiarappa.context.catalog.domain.model;

public class CameraUpgradePolicy extends UpgradePolicy<Camera>{


    @Override
    public void applyCustom(Camera oldGear, Camera newGear) {
        if(oldGear.getPredecessor()!=null && oldGear.getPredecessor().equals(newGear)){
            throw new IllegalArgumentException("It is not possible to set as successor a predecessor camera");
        }
    }
}
