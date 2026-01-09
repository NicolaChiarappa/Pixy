package it.nicolachiarappa.context.catalog.application.mappers;

import it.nicolachiarappa.context.catalog.application.dtos.ManufacturerDto;
import it.nicolachiarappa.context.catalog.application.requests.ManufacturerRequest;
import it.nicolachiarappa.shared.application.mapper.CRUDMapper;
import it.nicolachiarappa.shared.application.service.Finder;
import it.nicolachiarappa.context.catalog.domain.models.Manufacturer;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public class ManufacturerMapper extends CRUDMapper<Manufacturer, ManufacturerDto, ManufacturerRequest> {


    @Autowired
    public Finder<Manufacturer,Long> manufacturerFinder;


    @Named("manufacturerFromId")
    public Manufacturer fromId(Long id){
        return manufacturerFinder.findByIdOrThrow(id);
    }


    @Override
    public Manufacturer fromRequest(ManufacturerRequest request) {
        return null;
    }

    @Override
    public Manufacturer fromRequest(ManufacturerRequest request, Manufacturer target) {
        return null;
    }

    @Override
    public ManufacturerDto toDto(Manufacturer entity) {
        return null;
    }
}
