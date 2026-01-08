package it.nicolachiarappa.context.catalog.application.services;

import it.nicolachiarappa.context.catalog.application.dtos.ManufacturerDto;
import it.nicolachiarappa.context.catalog.application.mappers.ManufacturerMapper;
import it.nicolachiarappa.context.catalog.domain.models.Manufacturer;
import it.nicolachiarappa.context.catalog.domain.repositories.ManufacturerRepository;
import it.nicolachiarappa.shared.application.mapper.EntityMapper;
import it.nicolachiarappa.shared.application.dto.DTO;
import it.nicolachiarappa.shared.application.request.UpdateRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@Data
@AllArgsConstructor(onConstructor_ = @Autowired)
@NoArgsConstructor
public class ManufacturerServiceImpl implements ManufacturerService  {


    ManufacturerRepository repository;
    ManufacturerMapper mapper;




    @Override
    public DTO<Manufacturer> update(UpdateRequest<Manufacturer> request) {
        return null;
    }

    @Override
    public DTO<Manufacturer> delete(Long id) {
        return null;
    }



    @Override
    public EntityMapper<Manufacturer, ManufacturerDto> getMapper(){
        return this.mapper;
    }

    @Override
    public JpaRepository<Manufacturer, Long> getRepository(){
        return this.repository;
    }




}
