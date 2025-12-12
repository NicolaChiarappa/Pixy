package it.nicolachiarappa.context.catalog.domain.repositories;

import it.nicolachiarappa.context.catalog.domain.models.LensAdapter;
import it.nicolachiarappa.context.catalog.domain.models.Mount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LensAdapterRepository extends JpaRepository<LensAdapter,Long> {

    List<LensAdapter> findLensAdapterBySourceAndTarget(Mount source, Mount target);
}
