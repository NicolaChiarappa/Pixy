package it.nicolachiarappa.context.catalog.domain.repositories;

import it.nicolachiarappa.context.catalog.domain.models.Mount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MountRepository extends JpaRepository<Mount, Long> {
}
