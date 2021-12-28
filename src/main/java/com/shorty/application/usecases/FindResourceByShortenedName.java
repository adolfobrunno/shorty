package com.shorty.application.usecases;

import com.shorty.domain.entity.Resource;

public interface FindResourceByShortenedName {

    Resource find(String shortened);

}
