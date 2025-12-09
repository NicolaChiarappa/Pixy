package it.nicolachiarappa.context.catalog.application.mappers;

import it.nicolachiarappa.context.catalog.application.dtos.ManufacturerDTO;
import it.nicolachiarappa.context.catalog.application.requests.CreateManufacturerRequest;
import it.nicolachiarappa.shared.application.service.Finder;
import it.nicolachiarappa.context.catalog.domain.models.Manufacturer;
import it.nicolachiarappa.shared.application.mapper.EntityMapper;
import it.nicolachiarappa.shared.application.request.Request;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public abstract class ManufacturerMapper implements EntityMapper<Manufacturer, ManufacturerDTO> {


    @Autowired
    public Finder<Manufacturer,Long> manufacturerFinder;


    @Named("manufacturerFromId")
    public Manufacturer fromId(Long id){
        return manufacturerFinder.findByIdOrThrow(id);
    }


    @Mapping(target = "id", ignore = true)
    public abstract Manufacturer fromCreateRequest(CreateManufacturerRequest request);


    public abstract ManufacturerDTO toDto(Manufacturer manufacturer);

    @Override
    public Manufacturer toEntity(Request<Manufacturer> request) {
        return toEntityStrategy(request);
    }

    @Override
    public ManufacturerDTO toDTO(Manufacturer entity) {
        return this.toDto(entity);
    }


    private Manufacturer toEntityStrategy(Request<Manufacturer> request){
        return switch (request){
            case CreateManufacturerRequest creationRequest-> this.fromCreateRequest(creationRequest);
            default -> throw new IllegalStateException("Unexpected value: " + request);
        };
    }


}
