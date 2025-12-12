package it.nicolachiarappa.context.catalog.application.requests;

import it.nicolachiarappa.context.catalog.domain.models.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CreateLensRequest extends CreateGearRequest {

    @NotNull
    private FocalLength focalLength;
    @NotNull
    private Aperture aperture;

}
