package it.nicolachiarappa.context.catalog.domain.repository;

import it.nicolachiarappa.context.catalog.domain.model.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long> {

    boolean existsByName(String name);
}
