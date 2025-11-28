package it.nicolachiarappa.context.catalog.application.requests;

import it.nicolachiarappa.context.catalog.domain.model.Manufacturer;
import it.nicolachiarappa.shared.application.request.CreateRequest;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateManufacturerRequest extends CreateRequest<Manufacturer> {

    @NotNull
    private String name;



}
