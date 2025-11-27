package it.nicolachiarappa.context.catalog.application.mappers;

import it.nicolachiarappa.context.catalog.application.dtos.ManufacturerDTO;
import it.nicolachiarappa.context.catalog.application.requests.CreateManufacturerRequest;
import it.nicolachiarappa.shared.Finder;
import it.nicolachiarappa.context.catalog.domain.model.Manufacturer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public abstract class ManufacturerMapper {


    @Autowired
    Finder<Manufacturer> manufacturerFinder;


    @Named("manufacturerFromId")
    public Manufacturer fromId(Long id){
        return manufacturerFinder.findByIdOrThrow(id);
    }


    @Mapping(target = "id", ignore = true)
    public abstract Manufacturer fromCreateRequest(CreateManufacturerRequest request);



    public abstract ManufacturerDTO toDTO(Manufacturer manufacturer);
}
