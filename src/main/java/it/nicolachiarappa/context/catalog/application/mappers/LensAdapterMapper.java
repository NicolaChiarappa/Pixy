package it.nicolachiarappa.context.catalog.application.mappers;

import it.nicolachiarappa.context.catalog.application.dtos.LensAdapterDto;
import it.nicolachiarappa.context.catalog.application.requests.LensAdapterRequest;
import it.nicolachiarappa.context.catalog.domain.models.LensAdapter;
import it.nicolachiarappa.context.catalog.domain.models.Mount;
import it.nicolachiarappa.shared.application.mapper.CRUDMapper;
import it.nicolachiarappa.shared.application.service.Finder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper
        (
                componentModel = "spring",
                nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
        )
public abstract class LensAdapterMapper extends CRUDMapper<LensAdapter, LensAdapterDto, LensAdapterRequest> {

    @Autowired
    Finder<Mount, Long> mountFinder;


    @Mapping(target = "source", expression = "java(mountFinder.findByIdOrThrow(request.getSourceId()))")
    @Mapping(target = "target", expression = "java(mountFinder.findByIdOrThrow(request.getTargetId()))")
    @Mapping(target = "releaseDate", ignore = true)
    @Mapping(target = "name", ignore = true)
    @Mapping(target = "mounts", ignore = true)
    @Mapping(target = "marketStatus", ignore = true)
    @Mapping(target = "manufacturer", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "actualMarketValue", ignore = true)
    @Override
    public abstract LensAdapter fromRequest(LensAdapterRequest request);
}
