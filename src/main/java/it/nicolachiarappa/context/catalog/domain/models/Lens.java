package it.nicolachiarappa.context.catalog.domain.models;

import jakarta.persistence.*;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public final class Lens extends Gear implements Upgradable<Lens> {

    @Embedded
    private FocalLength focalLength;

    @Embedded
    private Aperture aperture;

    @OneToOne
    private Lens successor;

    @OneToOne
    private Lens predecessor;


    public Boolean isFixed(){
        return focalLength.getIsFixed();
    }


    @Override
    public void upgrade(Lens newLens) {
        LensUpgradePolicy policy = new LensUpgradePolicy();

        if(validateUpgrade(policy, this, newLens )){
            this.setSuccessor(newLens);
            newLens.setPredecessor(this);
        }


    }

    @Override
    public void setOutOfProduction() {

        if(this.getMarketStatus() == Status.OUT || this.getMarketStatus()== Status.DRAFT){
            throw new IllegalStateException("The gear's status must be active");
        }

        this.setMarketStatus(Status.OUT);
    }

    @Override
    public boolean validateUpgrade(UpgradePolicy<Lens> policy, Lens oldLens, Lens newLens) {
        return policy.applyPolicy(oldLens, newLens);
    }



}
