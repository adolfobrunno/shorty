package com.shorty.application.usecases;

import com.shorty.domain.entity.Resource;

public interface CreateResource {
    Resource createFromUrl(String url);
}
