package it.nicolachiarappa.context.catalog.application.dtos;

import it.nicolachiarappa.context.catalog.domain.models.Gear;
import it.nicolachiarappa.context.catalog.domain.models.Manufacturer;
import it.nicolachiarappa.context.catalog.domain.models.Mount;
import it.nicolachiarappa.context.catalog.domain.models.Status;
import it.nicolachiarappa.shared.application.dto.DTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
public class GearDto extends DTO<Gear> {
    private String name;
    private Manufacturer manufacturer;
    private Set<Mount> mounts;
    private Date releaseDate;
    private Double actualMarketValue;
    private Status marketStatus;
}
