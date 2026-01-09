package it.nicolachiarappa.context.catalog.application.dtos;

import it.nicolachiarappa.context.catalog.domain.models.LensAdapter;
import it.nicolachiarappa.context.catalog.domain.models.Mount;
import it.nicolachiarappa.shared.application.dto.DTO;
import lombok.Data;

@Data
public class LensAdapterDto extends DTO<LensAdapter> {

    private Mount source;

    private Mount target;

}
