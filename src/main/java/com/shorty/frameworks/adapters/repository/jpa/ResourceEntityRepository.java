package com.shorty.frameworks.adapters.repository.jpa;

import com.shorty.frameworks.adapters.repository.jpa.entities.ResourceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ResourceEntityRepository extends JpaRepository<ResourceEntity, Long> {

    Optional<ResourceEntity> findByShortened(String shortened);

}
