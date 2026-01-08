package it.nicolachiarappa.context.catalog.application.dtos;

import it.nicolachiarappa.context.catalog.domain.models.Manufacturer;
import it.nicolachiarappa.shared.application.dto.DTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ManufacturerDto extends DTO<Manufacturer> {
    private String name;
}
