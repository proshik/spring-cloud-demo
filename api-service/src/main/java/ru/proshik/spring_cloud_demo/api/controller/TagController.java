package ru.proshik.spring_cloud_demo.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
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

    @Transactional
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<TagOut> add(@RequestBody @Valid TagIn in) {

        Tag tag = tagRepository.findByTitle(in.getTitle());

        if (tag == null) {
            tag = tagRepository.save(new Tag(LocalDateTime.now(), in.getTitle()));
        }

        return ResponseEntity.ok(toRestOut(tag));
    }

    @GetMapping(value = "{tagId}")
    public ResponseEntity get(@PathVariable("tagId") Long tagId) {

        Tag tag = tagRepository.findById(tagId);

        if (tag != null) {
            return ResponseEntity.ok(toRestOut(tag));
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    @ResponseStatus
    public ResponseEntity findByTitle(@RequestParam(value = "title", required = true) String title) {

        Tag tag = tagRepository.findByTitle(title);

        if (tag != null) {
            return ResponseEntity.ok(toRestOut(tag));
        }
        return ResponseEntity.ok().build();
    }

    private TagOut toRestOut(Tag tag) {
        return new TagOut(tag.getId(), tag.getTitle());
    }

}