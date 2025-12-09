package it.nicolachiarappa.context.catalog.domain.models;

import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(
        name = "cameras",
        uniqueConstraints = @UniqueConstraint(columnNames = {"manufacturer", "name"})
)
public final class Camera extends Gear implements Upgradable<Camera> {
    @Column
    private Integer megapixels;

    @Column
    private Format format;

    @OneToOne
    private Camera successor;

    @OneToOne
    private Camera predecessor;




    @Override
    public void upgrade(Camera newCamera) {
        CameraUpgradePolicy policy = new CameraUpgradePolicy();
        if(validateUpgrade(policy, this, newCamera)){
            this.setSuccessor(newCamera);
            newCamera.setPredecessor(this);
        }
    }




    public void setOutOfProduction() {

        if(this.getMarketStatus() == Status.OUT || this.getMarketStatus()== Status.DRAFT){
            throw new UnsupportedOperationException("The gear's status must be active");
        }
        this.setMarketStatus(Status.OUT);
    }




    public boolean validateUpgrade(UpgradePolicy<Camera> policy,Camera oldCamera, Camera newCamera ) {
        return policy.applyPolicy(this, newCamera);
    }



}

