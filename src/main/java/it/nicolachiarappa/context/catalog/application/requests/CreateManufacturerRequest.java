package it.nicolachiarappa.context.catalog.application.requests;

import it.nicolachiarappa.context.catalog.domain.models.Manufacturer;
import it.nicolachiarappa.shared.application.request.CreateRequest;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CreateManufacturerRequest extends CreateRequest<Manufacturer> {

    @NotNull
    private String name;



}
