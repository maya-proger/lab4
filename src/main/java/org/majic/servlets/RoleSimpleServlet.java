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
import java.util.Optional;

@WebServlet("/lab4/roles")
public class RoleSimpleServlet extends HttpServlet {

    private RoleService roleService = new RoleService();
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
        List<Role> roles = roleService.findAllRoles();
        req.setAttribute("roles", roles);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/showRoles.jsp");
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
        String name = req.getParameter("name");
        Role role = new Role(name);
        roleService.saveRole(role);
        resp.sendRedirect("/lab4/roles");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Optional<Role> roleOptional = roleService.findRole(id);
        if(roleOptional.isPresent()){
            Role role = roleOptional.get();
            role.setName(req.getParameter("name"));
            roleService.updateRole(role);
        }
        resp.sendRedirect("/lab4/roles");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        roleService.deleteRole(id);
        resp.sendRedirect("/lab4/roles");
    }
}
