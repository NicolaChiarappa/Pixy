package it.nicolachiarappa.context.catalog.application.requests;

import it.nicolachiarappa.context.catalog.domain.models.Format;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Range;


@EqualsAndHashCode(callSuper = true)
@Data
public class CreateCameraRequest extends CreateGearRequest {


    @NotNull
    @Range(min = 10, max = 200)
    private Integer megapixels;
    @NotNull
    private Format format;






}
