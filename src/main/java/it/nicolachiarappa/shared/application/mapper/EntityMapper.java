package it.nicolachiarappa.shared.application.mapper;
import it.nicolachiarappa.shared.application.request.Request;

public interface EntityMapper<EntityT, DtoT, RequestT extends Request<EntityT>> {





    EntityT fromRequest(RequestT request);

    EntityT fromRequest(RequestT request, EntityT target);


    DtoT toDto(EntityT entity);

}
