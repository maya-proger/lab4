package org.majic.models;

public class Article {
    private Long id;

    private String title, announcement;

    private String text;

    private Long author_id;

    public Article() {
    }

    public Article(Long id, String title, String announcement, String text, Long author_id) {
        this.id = id;
        this.title = title;
        this.announcement = announcement;
        this.text = text;
        this.author_id = author_id;
    }

    public Article(String title, String announcement, String text, Long author_id) {
        this.title = title;
        this.announcement = announcement;
        this.text = text;
        this.author_id = author_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(String announcement) {
        this.announcement = announcement;
    }

    public Long getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(Long author_id) {
        this.author_id = author_id;
    }

}