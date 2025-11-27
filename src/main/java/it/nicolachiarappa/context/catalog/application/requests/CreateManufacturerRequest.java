package it.nicolachiarappa.context.catalog.application.requests;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateManufacturerRequest {

    @NotNull
    private String name;



}
