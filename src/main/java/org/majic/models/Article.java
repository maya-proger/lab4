package org.majic.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Articles")
public class Article {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "articles_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    private Long id;

    private String title, announcement;

    @Lob
    @Column(length = 256)
    private String text;

    @ManyToOne
    @JoinColumn(name="author_id", nullable=false)
    private User author;

    public Article() {
    }

    public Article(String title, String announcement, String text, User author) {
        this.title = title;
        this.announcement = announcement;
        this.text = text;
        this.author = author;
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

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

}
