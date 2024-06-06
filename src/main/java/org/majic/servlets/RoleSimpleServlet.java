package org.majic.servlets;

import jakarta.servlet.annotation.WebServlet;
import org.majic.models.Role;
import org.majic.services.RoleService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/lab4/roles")
public class RoleSimpleServlet extends HttpServlet {

    private RoleService service = new RoleService();

    public void init(ServletConfig servletConfig) {
        try {
            super.init(servletConfig);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Role> roles = service.findAllRoles();
        req.setAttribute("roles", roles);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/showRoles.jsp");
        dispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String name = req.getParameter("name");
        Role role = new Role(name);
        service.saveRole(role);
        resp.sendRedirect("/lab4/roles");

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Role role = service.findRole(id);
        role.setName(req.getParameter("name"));
        service.updateRole(role);
        resp.sendRedirect("/lab4/roles");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        service.deleteRole(service.findRole(id));
        resp.sendRedirect("/lab4/roles");
    }
}