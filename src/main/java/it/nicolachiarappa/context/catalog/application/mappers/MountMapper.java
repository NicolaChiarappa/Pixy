package it.nicolachiarappa.context.catalog.application.mappers;

import it.nicolachiarappa.context.catalog.application.dtos.MountDto;
import it.nicolachiarappa.context.catalog.application.requests.MountRequest;
import it.nicolachiarappa.context.catalog.domain.models.Mount;
import it.nicolachiarappa.shared.application.mapper.CRUDMapper;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public abstract class MountMapper extends CRUDMapper<Mount, MountDto, MountRequest> {

}
