package ru.proshik.thinkclearly.topic.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.id.enhanced.SequenceStyleGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

/**
 * Created by proshik on 20.11.16.
 */
@Entity
@Table(name = "topic")
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "topic_seq")
    @GenericGenerator(
            name = "topic_seq",
            strategy = "enhanced-sequence",
            parameters = @org.hibernate.annotations.Parameter(
                    name = SequenceStyleGenerator.SEQUENCE_PARAM,
                    value = "topic_seq"))
    private Long id;

    @Column(name = "created_date", nullable = false, updatable = false)
    private LocalDateTime createdDate;

    @Column(name = "title", nullable = false, updatable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "content_type", updatable = false)
    private ContentType contentType;

    @Column(name = "rating")
    private Integer rating = 0;

    @Column(name = "show_count")
    private Integer showCount = 0;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "topic_tag",
            joinColumns = @JoinColumn(name = "topic_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private Set<Tag> tags;

    public Topic() {
    }

    public Topic(LocalDateTime createdDate, String title, String content, ContentType contentType, Set<Tag> tags) {
        this.createdDate = createdDate;
        this.title = title;
        this.content = content;
        this.contentType = contentType;
        this.tags = tags;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
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

    public Set<Tag> getTags() {
        return tags;
    }
}
