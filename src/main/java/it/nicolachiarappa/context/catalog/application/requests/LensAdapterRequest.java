package it.nicolachiarappa.context.catalog.application.requests;

import it.nicolachiarappa.context.catalog.domain.models.LensAdapter;
import it.nicolachiarappa.shared.application.request.Request;
import lombok.Data;

@Data
public class LensAdapterRequest implements Request<LensAdapter> {

    private Long sourceId;

    private Long targetId;

}
