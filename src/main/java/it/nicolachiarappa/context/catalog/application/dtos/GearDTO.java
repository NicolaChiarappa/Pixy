package it.nicolachiarappa.context.catalog.application.dtos;

import it.nicolachiarappa.context.catalog.domain.model.Gear;
import it.nicolachiarappa.context.catalog.domain.model.Manufacturer;
import it.nicolachiarappa.context.catalog.domain.model.Mount;
import it.nicolachiarappa.context.catalog.domain.model.Status;
import it.nicolachiarappa.shared.application.dto.DTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
public class GearDTO extends DTO<Gear> {
    private String name;
    private Manufacturer manufacturer;
    private Set<Mount> mounts;
    private Date releaseDate;
    private Double actualMarketValue;
    private Status marketStatus;
}
