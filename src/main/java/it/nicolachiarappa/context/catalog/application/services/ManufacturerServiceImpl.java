package it.nicolachiarappa.context.catalog.application.services;

import it.nicolachiarappa.context.catalog.application.mappers.ManufacturerMapper;
import it.nicolachiarappa.context.catalog.domain.repositories.ManufacturerRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Data
@AllArgsConstructor(onConstructor_ = @Autowired)
@NoArgsConstructor
public class ManufacturerServiceImpl implements ManufacturerService  {


    private ManufacturerRepository repository;
    private ManufacturerMapper mapper;






}
