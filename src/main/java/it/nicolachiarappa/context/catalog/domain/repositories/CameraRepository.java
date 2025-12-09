package it.nicolachiarappa.context.catalog.domain.repositories;

import it.nicolachiarappa.context.catalog.domain.models.Camera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CameraRepository extends JpaRepository<Camera, Long> {


    Camera findCameraByName(String name);

    @Override
    void deleteById(Long aLong);
}
