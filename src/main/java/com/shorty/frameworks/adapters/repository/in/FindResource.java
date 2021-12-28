package com.shorty.frameworks.adapters.repository.in;

import com.shorty.application.ports.in.FindResourceRepository;
import com.shorty.domain.entity.Resource;
import com.shorty.frameworks.adapters.repository.jpa.ResourceEntityRepository;
import com.shorty.frameworks.adapters.repository.jpa.entities.ResourceEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class FindResource implements FindResourceRepository {

    private final ResourceEntityRepository repository;

    @Override
    public Resource findByShortened(String shortened) {
        ResourceEntity entity = repository.findByShortened(shortened).orElseThrow();
        return new Resource(entity.getUrl(), entity.getShortened(), entity.getCreatedDateTime(), entity.getHitsCount());
    }
}
