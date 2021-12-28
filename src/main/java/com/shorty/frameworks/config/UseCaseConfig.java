package com.shorty.frameworks.config;

import com.shorty.application.ports.in.FindResourceRepository;
import com.shorty.application.ports.out.SaveResourceRepository;
import com.shorty.application.usecases.CreateResource;
import com.shorty.application.usecases.FindResourceByShortenedName;
import com.shorty.application.usecases.impl.CreateResourceImpl;
import com.shorty.application.usecases.impl.FindResourceByShortenedNameImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public CreateResource createResource(SaveResourceRepository resourceRepository) {
        return new CreateResourceImpl(resourceRepository);
    }

    @Bean
    public FindResourceByShortenedName findByShortened(FindResourceRepository findResourceRepository, SaveResourceRepository saveResourceRepository) {
        return new FindResourceByShortenedNameImpl(findResourceRepository, saveResourceRepository);
    }

}
