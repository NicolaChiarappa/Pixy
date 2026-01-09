package it.nicolachiarappa.shared.application.mapper;

import it.nicolachiarappa.shared.application.request.Request;
import org.mapstruct.MappingTarget;


public abstract class CRUDMapper <E, D, R extends Request<E>> implements EntityMapper<E, D, R> {


    @Override
    public abstract E fromRequest(R request);

    @Override
    public abstract E fromRequest(R request, @MappingTarget E target);

    @Override
    public abstract D toDto(E entity);
}
