package com.shorty.application.ports.in;

import com.shorty.domain.entity.Resource;

public interface FindResourceRepository {
    Resource findByShortened(String shortened);
}
