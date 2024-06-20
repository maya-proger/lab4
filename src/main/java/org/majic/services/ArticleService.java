package org.majic.services;

import org.majic.daos.ArticleDao;
import org.majic.models.Article;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ArticleService {

    private ArticleDao articleDao = new ArticleDao();

    public ArticleService() {
    }

    public Optional<Article> findArticle(int id) {
        Optional<Article> article = Optional.empty();
        try{
            article = articleDao.findById(id);
        } catch(SQLException e){
            System.out.println("Exception: " + e.getMessage());
        }
        return article;
    }

    public void saveArticle(Article article) {
        articleDao.save(article);
    }

    public void deleteArticle(Long id) {
        articleDao.delete(id);
    }

    public void updateArticle(Article article) {
        articleDao.update(article);
    }

    public List<Article> findAllArticles() {
        List<Article> articles = new ArrayList<>();
        try{
            articles = articleDao.findAll();
        } catch(SQLException e){
            System.out.println("Exception: " + e.getMessage());
        }
        return articles;
    }
}