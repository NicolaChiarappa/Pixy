package it.nicolachiarappa.context.catalog.application.requests;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class GearRequest {
    @NotNull
    private Long id;
}
