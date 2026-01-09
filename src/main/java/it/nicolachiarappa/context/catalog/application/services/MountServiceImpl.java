package it.nicolachiarappa.context.catalog.application.services;

import it.nicolachiarappa.context.catalog.application.dtos.MountDto;
import it.nicolachiarappa.context.catalog.application.requests.MountRequest;
import it.nicolachiarappa.context.catalog.domain.models.Mount;
import it.nicolachiarappa.context.catalog.domain.repositories.MountRepository;
import it.nicolachiarappa.shared.application.mapper.EntityMapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class MountServiceImpl implements MountService{
    @Autowired
    private EntityMapper<Mount, MountDto, MountRequest> mapper;

    @Autowired
    private MountRepository repository;





}
