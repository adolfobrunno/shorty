package com.shorty.domain.entity;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Resource {

    private String url;
    private String shorted;
    private LocalDateTime createdDateTime;
    private int hitsCount;

}
