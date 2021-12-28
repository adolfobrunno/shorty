package com.shorty.application.ports.out;

import com.shorty.domain.entity.Resource;

public interface SaveResourceRepository {

    Resource save(Resource resource);

}
