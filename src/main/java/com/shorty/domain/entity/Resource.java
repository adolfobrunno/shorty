package com.shorty.domain.entity;

import com.shorty.domain.exceptions.IsNotAUrlException;
import org.apache.commons.lang3.RandomStringUtils;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;

public record Resource(String url, String shortened, LocalDateTime createdDateTime,
                       int hitsCount) {

    public static Resource aResource(String url) {
        try {
            URL aux = new URL(url);
            String shorted = RandomStringUtils.randomAlphabetic(8);
            return new Resource(aux.toString(), shorted, LocalDateTime.now(), 0);
        } catch (MalformedURLException e) {
            throw new IsNotAUrlException(url);
        }
    }

    public static Resource aResource(Resource r, int increment) {
        return new Resource(r.url, r.shortened, r.createdDateTime, r.hitsCount + increment);
    }

}
