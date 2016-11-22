package ru.proshik.spring_cloud_demo.api.dto;

import org.hibernate.validator.constraints.NotBlank;
import ru.proshik.spring_cloud_demo.api.model.ContentType;

import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by proshik on 21.11.16.
 */
public class TopicIn {

    @NotBlank
    private String title;

    @NotBlank
    private String content;

    @NotNull
    private ContentType contentType;

    private Set<Long> tagIds = new HashSet<>();

    public TopicIn() {
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public ContentType getContentType() {
        return contentType;
    }

    public Set<Long> getTagIds() {
        return tagIds;
    }
}
