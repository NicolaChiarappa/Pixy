package it.nicolachiarappa.context.catalog.application.mappers;

import it.nicolachiarappa.context.catalog.application.dtos.LensDto;
import it.nicolachiarappa.context.catalog.application.requests.CreateLensRequest;
import it.nicolachiarappa.context.catalog.domain.models.Lens;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
        componentModel = "spring",
        uses = {ManufacturerMapper.class}
)
public abstract class LensMapper {


    @Mapping(target = "actualMarketValue", ignore = true)
    @Mapping(target = "successor", ignore = true)
    @Mapping(target = "predecessor", ignore = true)
    @Mapping(target = "marketStatus", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "releaseDate", source = "releaseDate")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "mounts", source = "mounts")
    @Mapping(target = "manufacturer", source = "manufacturerId",qualifiedByName = "manufacturerFromId")
    @Mapping(target = "focalLength", source = "focalLength")
    @Mapping(target = "aperture", source = "aperture")
    public abstract Lens fromRequest(CreateLensRequest request);




    @Mapping(target = "successorId", ignore = true)
    @Mapping(target = "predecessorId", ignore = true)
    public abstract LensDto toDTO(Lens lens);


}
