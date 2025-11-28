package it.nicolachiarappa.context.catalog.application.services;

import it.nicolachiarappa.context.catalog.application.dtos.ManufacturerDTO;
import it.nicolachiarappa.context.catalog.domain.model.Manufacturer;
import it.nicolachiarappa.shared.application.service.Finder;
import it.nicolachiarappa.shared.application.service.CRUDService;

public interface ManufacturerService extends CRUDService<Manufacturer, ManufacturerDTO>, Finder<Manufacturer, Long> {



}
