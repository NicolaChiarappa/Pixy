package it.nicolachiarappa.context.catalog.application.requests;

import it.nicolachiarappa.context.catalog.domain.models.Manufacturer;
import it.nicolachiarappa.shared.application.request.Request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ManufacturerRequest implements Request<Manufacturer> {

    @NotNull
    private String name;



}
