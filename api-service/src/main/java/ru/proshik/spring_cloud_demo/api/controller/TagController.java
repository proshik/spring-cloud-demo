package ru.proshik.spring_cloud_demo.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.proshik.spring_cloud_demo.api.dto.TagIn;
import ru.proshik.spring_cloud_demo.api.dto.TagOut;
import ru.proshik.spring_cloud_demo.api.model.Tag;
import ru.proshik.spring_cloud_demo.api.repository.TagRepository;

import javax.validation.Valid;
import java.time.LocalDateTime;

/**
 * Created by proshik on 21.11.16.
 */
@RestController
@RequestMapping(value = "/v1/tag")
public class TagController {

    @Autowired
    private TagRepository tagRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody @Valid TagIn in) {
        tagRepository.saveOrUpdate(LocalDateTime.now(), in.getTitle());
    }

    @GetMapping(value = "{tagId}")
    public TagOut get(@PathVariable("tagId") Long tagId) {

        return toRestOut(tagRepository.findById(tagId));
    }

    @GetMapping
    public TagOut findByTitle(@RequestParam(value = "title", required = true) String title) {

        return toRestOut(tagRepository.findByTitle(title));
    }

    private TagOut toRestOut(Tag tag) {
        return new TagOut(tag.getId(), tag.getTitle());
    }

}
