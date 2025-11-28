package it.nicolachiarappa.shared.application.service;
import it.nicolachiarappa.shared.domain.model.BaseEntity;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Finder <T extends BaseEntity, ID> {


    default  T findByIdOrThrow(ID id){
        return getRepository().findById(id).orElseThrow(EntityNotFoundException::new);
    }

    default  List<T> findAll(){
        return getRepository().findAll();
    }


    JpaRepository<T, ID> getRepository();



}
