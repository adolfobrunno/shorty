package com.shorty.frameworks.adapters.repository.out;

import com.shorty.application.ports.out.SaveResourceRepository;
import com.shorty.domain.entity.Resource;
import com.shorty.frameworks.adapters.repository.jpa.entities.ResourceEntity;
import com.shorty.frameworks.adapters.repository.jpa.ResourceEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class SaveResourceRepositoryImpl implements SaveResourceRepository {

    private final ResourceEntityRepository repository;

    @Override
    public Resource save(Resource resource) {
        ResourceEntity entity = new ResourceEntity();
        Optional<ResourceEntity> find = repository.findByShortened(resource.shortened());
        find.ifPresent(resourceEntity -> entity.setId(resourceEntity.getId()));
        entity.setHitsCount(resource.hitsCount());
        entity.setShortened(resource.shortened());
        entity.setUrl(resource.url());
        entity.setCreatedDateTime(resource.createdDateTime());
        repository.save(entity);
        return resource;
    }
}
