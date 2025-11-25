package it.nicolachiarappa.context.catalog.application.dtos;

import it.nicolachiarappa.context.catalog.domain.model.Manufacturer;
import it.nicolachiarappa.context.catalog.domain.model.Mount;
import it.nicolachiarappa.context.catalog.domain.model.Status;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
public class GearDTO {
    private String name;
    private Manufacturer manufacturer;
    private Set<Mount> mounts;
    private Date releaseDate;
    private Double actualMarketValue;
    private Status marketStatus;
}
