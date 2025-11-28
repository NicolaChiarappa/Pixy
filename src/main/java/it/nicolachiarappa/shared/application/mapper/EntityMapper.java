package it.nicolachiarappa.shared.application.mapper;
import it.nicolachiarappa.shared.application.request.Request;

public interface EntityMapper<T , Dto > {


    T toEntity(Request<T> request);

    Dto toDTO(T entity);

}
