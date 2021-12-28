package com.shorty.application.usecases.impl;

import com.shorty.application.ports.in.FindResourceRepository;
import com.shorty.application.ports.out.SaveResourceRepository;
import com.shorty.application.usecases.FindResourceByShortenedName;
import com.shorty.domain.entity.Resource;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FindResourceByShortenedNameImpl implements FindResourceByShortenedName {

    private final FindResourceRepository findResourceRepository;
    private final SaveResourceRepository saveResourceRepository;

    @Override
    public Resource find(String shortened) {
        Resource resource = findResourceRepository.findByShortened(shortened);
        Resource updated = Resource.aResource(resource, 1);
        saveResourceRepository.save(updated);
        return updated;
    }
}
