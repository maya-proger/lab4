package org.majic;

import org.majic.models.Article;
import org.majic.services.ArticleService;

import java.sql.SQLException;
import java.util.Optional;

public class Main {
    public static void main(String[] args) throws SQLException {
        ArticleService articleService = new ArticleService();
        Article article = new Article(
                "check from code",
                "check from code",
                "check from code",
                4L
        );
        articleService.saveArticle(article);
    }
}