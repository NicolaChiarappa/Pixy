package it.nicolachiarappa.shared.application.service;

import it.nicolachiarappa.shared.application.dto.DTO;
import it.nicolachiarappa.shared.application.mapper.EntityMapper;
import it.nicolachiarappa.shared.application.request.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CRUDService<
                            Ent,
                            Dto extends DTO<Ent>,
                            Req extends Request<Ent>
                            >
{


    default Dto create(Req request){
        Ent element = getMapper().fromRequest(request);
        return getMapper().toDto(getRepository().save(element));
    }

    default Dto read(Long id){
        return getMapper().toDto(getRepository().findById(id).orElseThrow());
    }

    default Dto update(Long id, Req request){
        Ent target = getRepository().findById(id).orElseThrow();
        Ent updated = getMapper().fromRequest(request, target);
        Ent saved = getRepository().save(updated);
        return getMapper().toDto(saved);
    }

    default Dto delete(Long id){
        throw new UnsupportedOperationException();
    }

    EntityMapper<Ent, Dto, Req> getMapper();

    JpaRepository<Ent, Long> getRepository();


}
