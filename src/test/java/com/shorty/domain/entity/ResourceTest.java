package com.shorty.domain.entity;

import com.shorty.domain.exceptions.IsNotAUrlException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ResourceTest {

    @Test
    void aResource() {

        String url = "https://www.google.com";
        Resource resource = Resource.aResource(url);

        assertThat(resource.url()).isEqualTo(url);
        assertThat(resource.hitsCount()).isZero();
        assertThat(resource.shortened()).hasSize(8);
        assertThat(resource.createdDateTime()).isNotNull();
    }

    @Test
    void malformatedUrl(){

        String url = "somemalformatedurl.com";

        assertThatThrownBy(() -> Resource.aResource(url))
                .isInstanceOf(IsNotAUrlException.class)
                .hasMessage(url);

    }
}