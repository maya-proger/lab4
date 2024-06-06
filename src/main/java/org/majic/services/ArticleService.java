package org.majic.services;

import org.majic.daos.ArticleDao;
import org.majic.models.Article;

import java.util.List;

public class ArticleService {

    private ArticleDao articleDao = new ArticleDao();

    public ArticleService() {
    }

    public Article findArticle(int id) {
        return articleDao.findById(id);
    }

    public void saveArticle(Article article) {
        articleDao.save(article);
    }

    public void deleteArticle(Article article) {
        articleDao.delete(article);
    }

    public void updateArticle(Article article) {
        articleDao.update(article);
    }

    public List<Article> findAllArticles() {
        return articleDao.findAll();
    }
}