package it.nicolachiarappa.context.catalog.application.requests;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpgradeGearRequest {

    @NotNull
    private Long oldId;
    @NotNull
    private Long newId;
}
