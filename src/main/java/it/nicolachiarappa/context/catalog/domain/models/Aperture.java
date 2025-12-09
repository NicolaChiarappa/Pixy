package it.nicolachiarappa.context.catalog.domain.models;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
public class Aperture{

    public Aperture(Integer minAperture, Integer maxAperture){
        if(minAperture>maxAperture){
            throw new IllegalArgumentException("minimum aperture cannot be greater then maximum aperture");
        }

        this.minimumAperture = minAperture;
        this.maximumAperture = maxAperture;
    }

    private Integer minimumAperture;
    private Integer maximumAperture;
}