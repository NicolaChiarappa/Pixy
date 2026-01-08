package it.nicolachiarappa.context.catalog.application.dtos;

import it.nicolachiarappa.context.catalog.domain.models.Aperture;
import it.nicolachiarappa.context.catalog.domain.models.FocalLength;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class LensDto extends GearDto {

    private FocalLength focalLength;
    private Aperture aperture;
    private Long successorId;
    private Long predecessorId;


}
