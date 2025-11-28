package it.nicolachiarappa.context.catalog.domain.repository;

import it.nicolachiarappa.context.catalog.domain.model.Lens;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LensRepository extends JpaRepository<Lens, Long> {
}
