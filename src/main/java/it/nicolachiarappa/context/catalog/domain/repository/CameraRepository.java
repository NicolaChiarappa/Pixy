package it.nicolachiarappa.context.catalog.domain.repository;

import it.nicolachiarappa.context.catalog.domain.model.Camera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CameraRepository extends JpaRepository<Camera, Long> {


}
