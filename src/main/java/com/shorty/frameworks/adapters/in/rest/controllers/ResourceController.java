package com.shorty.frameworks.adapters.in.rest.controllers;

import com.shorty.application.usecases.CreateResource;
import com.shorty.application.usecases.FindResourceByShortenedName;
import com.shorty.domain.entity.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
public class ResourceController {

    private final CreateResource createResource;
    private final FindResourceByShortenedName findByShortened;

    @PostMapping("")
    public ResponseEntity<Resource> createResource(@RequestParam("url") String url) {
        return ResponseEntity.ok(createResource.createFromUrl(url));
    }

    @GetMapping("/{shortened}")
    public ResponseEntity<Void> goTo(@PathVariable("shortened") String shortened) {
        Resource resource = findByShortened.find(shortened);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create(resource.url()));
        return new ResponseEntity<>(headers, HttpStatus.MOVED_PERMANENTLY);
    }

    @GetMapping("/report/{shortened}")
    public ResponseEntity<Resource> report(@PathVariable("shortened") String shortened) {
        Resource resource = findByShortened.find(shortened);
        return ResponseEntity.ok(resource);
    }

}
