package it.nicolachiarappa.context.catalog.application.dtos;

import it.nicolachiarappa.context.catalog.domain.models.Mount;
import it.nicolachiarappa.shared.application.dto.DTO;

public class MountDto extends DTO<Mount> {

    private String name;

    private String slug;

}
