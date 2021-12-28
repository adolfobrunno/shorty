package com.shorty.application.usecases.impl;

import com.shorty.application.ports.out.SaveResourceRepository;
import com.shorty.application.usecases.CreateResource;
import com.shorty.domain.entity.Resource;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateResourceImpl implements CreateResource {

    private final SaveResourceRepository resourceRepository;

    @Override
    public Resource createFromUrl(String url) {
        Resource resource = Resource.aResource(url);
        return resourceRepository.save(resource);
    }
}
