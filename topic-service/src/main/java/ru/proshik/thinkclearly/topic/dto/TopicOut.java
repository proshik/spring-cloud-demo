package ru.proshik.thinkclearly.topic.dto;

import ru.proshik.thinkclearly.topic.model.ContentType;

import java.util.List;

/**
 * Created by proshik on 21.11.16.
 */
public class TopicOut {

    private String title;

    private String content;

    private ContentType contentType;

    private Integer rating;

    private Integer showCount;

    private List<TagOut> tags;

    public TopicOut() {
    }

    public TopicOut(String title, String content, ContentType contentType, Integer rating,
                    Integer showCount, List<TagOut> tags) {
        this.title = title;
        this.content = content;
        this.contentType = contentType;
        this.rating = rating;
        this.showCount = showCount;
        this.tags = tags;
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

    public Integer getRating() {
        return rating;
    }

    public Integer getShowCount() {
        return showCount;
    }

    public List<TagOut> getTags() {
        return tags;
    }
}
