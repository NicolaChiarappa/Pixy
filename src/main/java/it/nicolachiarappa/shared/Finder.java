package it.nicolachiarappa.shared;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Finder <T extends BaseEntity> {


    default  T findByIdOrThrow(Long id){
        return getRepo().findById(id).orElseThrow(EntityNotFoundException::new);
    }

    default  List<T> findAll(){
        return getRepo().findAll();
    }


    JpaRepository<T, Long> getRepo();



}
