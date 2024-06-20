package org.majic.models;

import java.util.ArrayList;
import java.util.List;

public class User {
    private Long id;

    private String username;

    private String email;

    private String password_hash;

    private List<Article> articles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword_hash() {
        return password_hash;
    }

    public void setPassword_hash(String password_hash) {
        this.password_hash = password_hash;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public void addArticle(Article article){
        this.articles.add(article);
    }

    public User() {
    }

    public User(String username, String email, String password_hash) {
        this.username = username;
        this.email = email;
        this.password_hash = password_hash;
        this.articles = new ArrayList<>();
    }

    public User(Long id, String username, String email, String password_hash) {
        this.username = username;
        this.email = email;
        this.password_hash = password_hash;
        this.id = id;
    }
}