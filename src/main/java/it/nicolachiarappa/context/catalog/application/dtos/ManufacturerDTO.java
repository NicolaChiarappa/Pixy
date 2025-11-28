package it.nicolachiarappa.context.catalog.application.dtos;

import it.nicolachiarappa.context.catalog.domain.model.Manufacturer;
import it.nicolachiarappa.shared.application.dto.DTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ManufacturerDTO extends DTO<Manufacturer> {
    private String name;
}
