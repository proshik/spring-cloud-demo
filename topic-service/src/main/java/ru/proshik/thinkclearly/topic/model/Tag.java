package ru.proshik.thinkclearly.topic.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.id.enhanced.SequenceStyleGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * Created by proshik on 20.11.16.
 */
@Entity
@Table(name = "tag")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tag_seq")
    @GenericGenerator(
            name = "tag_seq",
            strategy = "enhanced-sequence",
            parameters = @org.hibernate.annotations.Parameter(
                    name = SequenceStyleGenerator.SEQUENCE_PARAM,
                    value = "tag_seq"))
    private Long id;


    @Column(name = "created_date", updatable = false, nullable = false)
    private LocalDateTime createdDate;

    private String title;

    @ManyToMany(mappedBy = "tags")
    private Set<Topic> topics;

    public Tag() {
    }

    public Tag(LocalDateTime createdDate, String title) {
        this.createdDate = createdDate;
        this.title = title;
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

    public Set<Topic> getTopics() {
        return topics;
    }
}
