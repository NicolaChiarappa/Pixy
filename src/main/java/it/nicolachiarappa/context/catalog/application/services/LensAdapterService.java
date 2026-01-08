package it.nicolachiarappa.context.catalog.application.services;

import it.nicolachiarappa.context.catalog.application.requests.CreateLensAdapterRequest;
import it.nicolachiarappa.context.catalog.domain.models.LensAdapter;

public interface LensAdapterService {


    LensAdapter addLensAdapter(CreateLensAdapterRequest request);
}
