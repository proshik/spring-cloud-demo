package ru.proshik.thinkclearly.topic.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import ru.proshik.thinkclearly.topic.dto.TagIn;
import ru.proshik.thinkclearly.topic.dto.TagOut;
import ru.proshik.thinkclearly.topic.model.Tag;
import ru.proshik.thinkclearly.topic.repository.TagRepository;

import javax.validation.Valid;
import java.time.LocalDateTime;

/**
 * Created by proshik on 21.11.16.
 */
@RestController
@RequestMapping(value = "/v1/topic/tag")
public class TagController {

    @Autowired
    private TagRepository tagRepository;

    @Transactional
    @HystrixCommand
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<TagOut> add(@RequestBody @Valid TagIn in) {

        Tag tag = tagRepository.findByTitle(in.getTitle());

        if (tag == null) {
            tag = tagRepository.save(new Tag(LocalDateTime.now(), in.getTitle()));
        }

        return ResponseEntity.ok(toRestOut(tag));
    }

    @RequestMapping(method = RequestMethod.GET, value = "{tagId}")
    public ResponseEntity get(@PathVariable(value = "tagId") Long tagId) {

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