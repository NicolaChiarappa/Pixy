package it.nicolachiarappa.context.catalog.domain.models;

public interface Upgradable <T extends Gear> {

    void upgrade(T upgrade);

    void setOutOfProduction();

    boolean validateUpgrade(UpgradePolicy<T> policy, T oldGear, T newGear);
}

