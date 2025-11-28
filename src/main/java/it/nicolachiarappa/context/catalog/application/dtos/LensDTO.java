package it.nicolachiarappa.context.catalog.application.dtos;

import it.nicolachiarappa.context.catalog.domain.model.Aperture;
import it.nicolachiarappa.context.catalog.domain.model.Focal;
import lombok.Data;

@Data
public class LensDTO  extends GearDTO{

    private Focal focal;
    private Aperture aperture;
    private Long successorId;
    private Long predecessorId;


}
