package org.majic.services;

import org.majic.daos.RoleDao;
import org.majic.models.Role;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RoleService {

    private RoleDao roleDao = new RoleDao();

    public RoleService() {
    }

    public Optional<Role> findRole(int id) {
        Optional<Role> role = Optional.empty();
        try{
            role = roleDao.findById(id);
        } catch(SQLException e){
            System.out.println("Exception: " + e.getMessage());
        }
        return role;
    }

    public void saveRole(Role role) {
        roleDao.save(role);
    }

    public void deleteRole(Long id) {
        roleDao.delete(id);
    }

    public void updateRole(Role role) {
        roleDao.update(role);
    }

    public List<Role> findAllRoles() {
        List<Role> roles = new ArrayList<>();
        try{
            roles = roleDao.findAll();
        } catch(SQLException e){
            System.out.println("Exception: " + e.getMessage());
        }
        return roles;
    }
}