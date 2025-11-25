package it.nicolachiarappa.context.catalog.domain.model;

public abstract class UpgradePolicy<T extends Gear> {

    public static UpgradePolicy<? extends Gear>  getPolicy(Gear gear){
        return switch (gear){
            case Camera ignored-> new CameraUpgradePolicy();
            case Lens ignored->new LensUpgradePolicy();
            default -> throw new IllegalStateException("Unexpected value: " + gear);
        };
    }

    public abstract void applyCustom(T oldGear, T newGear);

    public boolean applyPolicy(T oldGear, T newGear){
        applyCustom(oldGear, newGear);

        if(oldGear.getMarketStatus()==Status.ACTIVE){
            throw new UnsupportedOperationException("It is not possible to set a successor for this gear if its current market status is active");
        }
        if(newGear.getReleaseDate().before(oldGear.getReleaseDate())){
            throw new IllegalArgumentException("The successor's release date cannot be earlier than the actual gear's release date");
        }
        if(!newGear.getManufacturer().equals(oldGear.getManufacturer())){
            throw new IllegalArgumentException("The new gear manufacturer is not the same of the actual gear");
        }

        return true;
    }
}
