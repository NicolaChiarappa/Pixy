package it.nicolachiarappa.context.catalog.application.requests;

import it.nicolachiarappa.context.catalog.domain.models.Mount;
import it.nicolachiarappa.shared.application.request.Request;
import lombok.Data;

@Data
public class MountRequest implements Request<Mount> {
    private String name;
}
