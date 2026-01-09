package it.nicolachiarappa.context.catalog.application.services;

import it.nicolachiarappa.context.catalog.application.requests.LensAdapterRequest;
import it.nicolachiarappa.context.catalog.domain.models.LensAdapter;

public interface LensAdapterService {


    LensAdapter addLensAdapter(LensAdapterRequest request);
}
