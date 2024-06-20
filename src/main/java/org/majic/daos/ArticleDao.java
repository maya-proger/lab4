package org.majic.daos;
import org.majic.models.Article;
import org.majic.services.DBService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ArticleDao {

    DBService dbService = new DBService();

    public Optional<Article> findById(int id) throws SQLException {
        String sqlQuery = String.format(
                "SELECT * FROM articles WHERE id = %d",
                id
        );
        ResultSet resultSet = dbService.makeQuery(sqlQuery);
        if(resultSet != null){
            resultSet.next();
            return Optional.of(new Article(
                    resultSet.getLong("id"),
                    resultSet.getString("title"),
                    resultSet.getString("announcement"),
                    resultSet.getString("text"),
                    resultSet.getLong("author_id")
            ));
        }
        return Optional.empty();
    }

    public void save(Article article) {
        String sqlQuery = String.format(
                "INSERT INTO public.articles VALUES (nextval('public.articles_seq'), '%s', '%s', '%s', %d)",
                article.getTitle(),
                article.getAnnouncement(),
                article.getText(),
                article.getAuthor_id()
        );
        dbService.makeQuery(sqlQuery);
    }

    public void update(Article article) {
        String sqlQuery = String.format(
                "UPDATE articles SET title = '%s', announcement = '%s', text = '%s', author_id = %d WHERE id = %d",
                article.getTitle(),
                article.getAnnouncement(),
                article.getText(),
                article.getAuthor_id(),
                article.getId()
        );
        dbService.makeQuery(sqlQuery);
    }

    public void delete(Long id) {
        String sqlQuery = String.format(
                "DELETE FROM articles WHERE id = %d",
                id
        );
        dbService.makeQuery(sqlQuery);
    }


    public List<Article> findAll() throws SQLException {
        String sqlQuery = "SELECT * FROM articles";
        ResultSet resultSet = dbService.makeQuery(sqlQuery);
        List<Article> articles = new ArrayList<>();
        if(resultSet != null){
            while(resultSet.next()){
                articles.add(
                        new Article(
                                resultSet.getLong("id"),
                                resultSet.getString("title"),
                                resultSet.getString("announcement"),
                                resultSet.getString("text"),
                                resultSet.getLong("author_id")
                        )
                );
            }
        }
        return articles;
    }
}
