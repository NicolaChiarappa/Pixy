package it.nicolachiarappa.context.catalog.application.mappers;

import it.nicolachiarappa.context.catalog.application.requests.CreateLensAdapterRequest;
import it.nicolachiarappa.context.catalog.domain.models.LensAdapter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper
        (
                componentModel = "spring",
                nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
        )
public abstract class LensAdapterMapper {



    @Mapping(target = "releaseDate", ignore = true)
    @Mapping(target = "name", ignore = true)
    @Mapping(target = "marketStatus", ignore = true)
    @Mapping(target = "manufacturer", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "actualMarketValue", ignore = true)
    public abstract LensAdapter fromRequest(CreateLensAdapterRequest request);




}
