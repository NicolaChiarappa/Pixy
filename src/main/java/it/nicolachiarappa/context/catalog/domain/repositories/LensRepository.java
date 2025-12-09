package it.nicolachiarappa.context.catalog.domain.repositories;

import it.nicolachiarappa.context.catalog.domain.models.Lens;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LensRepository extends JpaRepository<Lens, Long> {
}
