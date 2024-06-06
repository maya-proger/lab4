package org.majic.daos;
import org.majic.models.Article;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.majic.utils.HibernateSessionFactoryUtil;
import java.util.List;

public class ArticleDao {

    public Article findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Article.class, id);
    }

    public void save(Article article) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(article);
        tx1.commit();
        session.close();
    }

    public void update(Article article) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(article);
        tx1.commit();
        session.close();
    }

    public void delete(Article article) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(article);
        tx1.commit();
        session.close();
    }


    public List<Article> findAll() {
        List<Article> articles = (List<Article>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Article").list();
        return articles;
    }
}
