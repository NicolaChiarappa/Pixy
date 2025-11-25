package it.nicolachiarappa.context.catalog.application.requests;

import it.nicolachiarappa.context.catalog.domain.model.Mount;
import it.nicolachiarappa.context.catalog.domain.model.Status;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
public abstract class CreateGearRequest {


    @NotNull
    private String name;
    @NotNull
    private Set<Mount> mounts;
    @NotNull
    private Long manufacturerId;
    @NotNull
    private Date releaseDate;
    @NotNull
    private Status marketStatus;
}
