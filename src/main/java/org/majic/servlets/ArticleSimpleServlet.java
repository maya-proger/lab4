package org.majic.servlets;

import jakarta.servlet.annotation.WebServlet;
import org.majic.models.Article;
import org.majic.models.User;
import org.majic.services.ArticleService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.majic.services.UserService;

import java.io.IOException;
import java.util.List;

@WebServlet("/lab4/articles")
public class ArticleSimpleServlet extends HttpServlet {

    private ArticleService articleService = new ArticleService();
    private UserService userService = new UserService();


    public void init(ServletConfig servletConfig) {
        try {
            super.init(servletConfig);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Article> articles = articleService.findAllArticles();
        req.setAttribute("articles", articles);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/showArticles.jsp");
        dispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String title = req.getParameter("title");
        String announcement = req.getParameter("announcement");
        String text = req.getParameter("text");
        int author_id = Integer.parseInt(req.getParameter("author_id"));
        User author = userService.findUser(author_id);
        Article article = new Article(title, announcement, text, author);
        articleService.saveArticle(article);
        resp.sendRedirect("/lab4/articles");

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Article article = articleService.findArticle(id);
        article.setTitle(req.getParameter("title"));
        article.setAnnouncement(req.getParameter("announcement"));
        article.setText(req.getParameter("text"));
        User author = userService.findUser(Integer.parseInt(req.getParameter("author_id")));
        article.setAuthor(author);
        articleService.updateArticle(article);
        resp.sendRedirect("/lab4/articles");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        articleService.deleteArticle(articleService.findArticle(id));
        resp.sendRedirect("/lab4/articles");
    }
}