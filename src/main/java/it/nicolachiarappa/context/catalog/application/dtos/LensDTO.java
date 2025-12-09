package it.nicolachiarappa.context.catalog.application.dtos;

import it.nicolachiarappa.context.catalog.domain.models.Aperture;
import it.nicolachiarappa.context.catalog.domain.models.Focal;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class LensDTO  extends GearDTO{

    private Focal focal;
    private Aperture aperture;
    private Long successorId;
    private Long predecessorId;


}
