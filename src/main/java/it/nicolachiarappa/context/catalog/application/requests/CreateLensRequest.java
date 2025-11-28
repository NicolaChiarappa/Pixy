package it.nicolachiarappa.context.catalog.application.requests;

import it.nicolachiarappa.context.catalog.domain.model.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateLensRequest extends CreateGearRequest {

    @NotNull
    private Focal focal;
    @NotNull
    private Aperture aperture;

}
