package ru.proshik.thinkclearly.topic.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import ru.proshik.thinkclearly.topic.dto.TagOut;
import ru.proshik.thinkclearly.topic.dto.TopicIn;
import ru.proshik.thinkclearly.topic.dto.TopicOut;
import ru.proshik.thinkclearly.topic.model.Topic;
import ru.proshik.thinkclearly.topic.repository.TagRepository;
import ru.proshik.thinkclearly.topic.repository.TopicRepository;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by proshik on 21.11.16.
 */
@RestController
@RequestMapping(value = "/v1/topic")
public class TopicController {

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private TopicRepository topicRepository;

    @HystrixCommand
    @RequestMapping(method = RequestMethod.POST)
    public TopicOut add(@RequestBody @Valid TopicIn in) {

        return toRestOut(topicRepository.save(new Topic(
                LocalDateTime.now(),
                in.getTitle(),
                in.getContent(),
                in.getContentType(),
                in.getTagIds().isEmpty()
                        ? Collections.emptySet()
                        : tagRepository.findByIdIn(in.getTagIds()))));
    }

    @HystrixCommand
    @RequestMapping(method = RequestMethod.GET, value = "{topicId}")
    public ResponseEntity get(@PathVariable("topicId") Long topicId) {

        Topic topic = topicRepository.findOne(topicId);

        if (topic != null) {
            return ResponseEntity.ok(toRestOut(topicRepository.findOne(topicId)));
        }

        return ResponseEntity.badRequest().build();
    }

    @HystrixCommand
    @RequestMapping(method = RequestMethod.GET)
    public List<TopicOut> get(@AuthenticationPrincipal Authentication authentication,
                              @PageableDefault Pageable pageable) {

        return toRestOut(topicRepository.findAll(pageable));
    }

    @HystrixCommand
    @RequestMapping(value = "/{topicId}/rating", method = RequestMethod.PATCH)
    public ResponseEntity changeRating(@PathVariable("topicId") Long topicId) {

        Topic topic = topicRepository.findOne(topicId);

        if (topic != null) {
            return ResponseEntity.ok(toRestOut(topicRepository.incrementRating(topicId)));
        }

        return ResponseEntity.badRequest().build();
    }

    private TopicOut toRestOut(Topic topic) {

        return new TopicOut(
                topic.getTitle(),
                topic.getContent(),
                topic.getContentType(),
                topic.getRating(),
                topic.getShowCount(),
                topic.getTags().stream()
                        .map(tag -> new TagOut(tag.getId(), tag.getTitle()))
                        .collect(Collectors.toList()));
    }

    private List<TopicOut> toRestOut(Page<Topic> topics) {
        return topics.getContent().stream()
                .map(this::toRestOut)
                .collect(Collectors.toList());
    }

}
