package it.nicolachiarappa.context.catalog.application.services;

import it.nicolachiarappa.context.catalog.application.mappers.LensAdapterMapper;
import it.nicolachiarappa.context.catalog.application.requests.LensAdapterRequest;
import it.nicolachiarappa.context.catalog.domain.models.LensAdapter;
import it.nicolachiarappa.context.catalog.domain.repositories.LensAdapterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LensAdapterServiceImpl implements LensAdapterService {


    @Autowired
    LensAdapterRepository lensAdapterRepository;

    @Autowired
    LensAdapterMapper lensAdapterMapper;

    @Override
    public LensAdapter addLensAdapter(LensAdapterRequest request) {
        LensAdapter lensAdapter = lensAdapterMapper.fromRequest(request);
        lensAdapter = lensAdapterRepository.save(lensAdapter);
        return lensAdapter;
    }
}
