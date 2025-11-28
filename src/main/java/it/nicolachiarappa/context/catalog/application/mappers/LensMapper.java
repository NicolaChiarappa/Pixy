package it.nicolachiarappa.context.catalog.application.mappers;

import it.nicolachiarappa.context.catalog.application.dtos.LensDTO;
import it.nicolachiarappa.context.catalog.application.requests.CreateLensRequest;
import it.nicolachiarappa.context.catalog.domain.model.Lens;
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
    @Mapping(target = "focal", source = "focal")
    @Mapping(target = "aperture", source = "aperture")
    public abstract Lens fromCreateRequest(CreateLensRequest request);




    @Mapping(target = "successorId", ignore = true)
    @Mapping(target = "predecessorId", ignore = true)
    public abstract LensDTO toDTO(Lens lens);


}
