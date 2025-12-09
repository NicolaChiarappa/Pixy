package it.nicolachiarappa.context.catalog.domain.repositories;

import it.nicolachiarappa.context.catalog.domain.models.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long> {

    boolean existsByName(String name);
}
