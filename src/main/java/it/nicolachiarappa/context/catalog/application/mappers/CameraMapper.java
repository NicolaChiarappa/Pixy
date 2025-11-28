package it.nicolachiarappa.context.catalog.application.mappers;


import it.nicolachiarappa.context.catalog.application.dtos.CameraDTO;
import it.nicolachiarappa.context.catalog.application.requests.CreateCameraRequest;
import it.nicolachiarappa.context.catalog.domain.model.Camera;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        uses = {ManufacturerMapper.class}
)
public abstract class CameraMapper {




    @Mapping(target = "marketStatus", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "actualMarketValue", ignore = true)
    @Mapping(target = "successor", ignore = true)
    @Mapping(target = "predecessor", ignore = true)
    @Mapping(target = "manufacturer", source = "manufacturerId", qualifiedByName = "manufacturerFromId")
    public abstract Camera fromCreateRequest(CreateCameraRequest request);




    @Mapping(target = "successorId", ignore = true)
    @Mapping(target = "predecessorId",ignore = true)
    public abstract CameraDTO toDTO (Camera camera);


}
