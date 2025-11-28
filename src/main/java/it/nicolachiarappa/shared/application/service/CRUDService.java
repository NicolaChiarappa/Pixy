package it.nicolachiarappa.shared.application.service;

import it.nicolachiarappa.shared.domain.model.BaseEntity;
import it.nicolachiarappa.shared.application.dto.DTO;
import it.nicolachiarappa.shared.application.mapper.EntityMapper;
import it.nicolachiarappa.shared.application.request.CreateRequest;
import it.nicolachiarappa.shared.application.request.UpdateRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CRUDService<
                            Ent extends BaseEntity,
                            Dto extends DTO<Ent>
                            >
{


    default Dto create(CreateRequest<Ent> request){
        Ent element = getMapper().toEntity(request);
        System.out.println("element"+element);
        return getMapper().toDTO(getRepository().save(element));
    }

    default DTO<Ent> read(Long id){
        return getMapper().toDTO(getRepository().findById(id).orElseThrow());
    }

    DTO<Ent> update(UpdateRequest<Ent> request);

    DTO<Ent> delete(Long id);

    EntityMapper<Ent, Dto> getMapper();

    JpaRepository<Ent, Long> getRepository();


}
