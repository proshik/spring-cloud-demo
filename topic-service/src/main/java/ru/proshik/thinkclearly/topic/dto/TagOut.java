package ru.proshik.thinkclearly.topic.dto;

/**
 * Created by proshik on 21.11.16.
 */
public class TagOut {

    private Long id;

    private String title;

    public TagOut() {
    }

    public TagOut(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public Long getId() {
        return id;
    }
}
