package it.nicolachiarappa.context.catalog.application.services;

import it.nicolachiarappa.context.catalog.application.dtos.MountDto;
import it.nicolachiarappa.context.catalog.application.requests.MountRequest;
import it.nicolachiarappa.context.catalog.domain.models.Mount;
import it.nicolachiarappa.shared.application.service.CRUDService;
import it.nicolachiarappa.shared.application.service.Finder;

public interface MountService extends CRUDService<Mount, MountDto, MountRequest>, Finder<Mount, Long> {
}
