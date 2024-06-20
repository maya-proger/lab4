package org.majic.servlets;

import jakarta.servlet.annotation.WebServlet;
import org.majic.models.User;
import org.majic.services.UserService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet("/lab4/users")
public class UserSimpleServlet extends HttpServlet {

    private UserService userService = new UserService();
    //private UserService userService = new UserService();


    public void init(ServletConfig servletConfig) {
        try {
            super.init(servletConfig);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = userService.findAllUsers();
        req.setAttribute("users", users);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/showUsers.jsp");
        dispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String method = req.getParameter("_method");
        if(method == null) method = "post";
        switch (method){
            case("delete"):
                this.doDelete(req, resp);
                return;
            case("put"):
                this.doPut(req, resp);
                return;
        }
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        User user = new User(username, email, password);
        userService.saveUser(user);
        resp.sendRedirect("/lab4/users");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Optional<User> userOptional = userService.findUser(id);
        if(userOptional.isPresent()){
            User user = userOptional.get();
            user.setUsername(req.getParameter("username"));
            user.setEmail(req.getParameter("email"));
            user.setPassword_hash(req.getParameter("password"));
            userService.updateUser(user);
        }
        resp.sendRedirect("/lab4/users");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        userService.deleteUser(id);
        resp.sendRedirect("/lab4/users");
    }
}
