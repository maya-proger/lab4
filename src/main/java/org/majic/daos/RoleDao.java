package org.majic.daos;
import org.majic.models.Role;
import org.majic.services.DBService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RoleDao {

    DBService dbService = new DBService();

    public Optional<Role> findById(int id) throws SQLException {
        String sqlQuery = String.format(
                "SELECT * FROM roles WHERE id = %d",
                id
        );
        ResultSet resultSet = dbService.makeQuery(sqlQuery);
        if(resultSet != null){
            resultSet.next();
            return Optional.of(new Role(
                    resultSet.getLong("id"),
                    resultSet.getString("name")
            ));
        }
        return Optional.empty();
    }

    public void save(Role role) {
        String sqlQuery = String.format(
                "INSERT INTO roles VALUES (nextval('roles_seq'), '%s')",
                role.getName()
        );
        dbService.makeQuery(sqlQuery);
    }

    public void update(Role role) {
        String sqlQuery = String.format(
                "UPDATE roles SET name = '%s' WHERE id = %d",
                role.getName(),
                role.getId()
        );
        dbService.makeQuery(sqlQuery);
    }

    public void delete(Long id) {
        String sqlQuery = String.format(
                "DELETE FROM roles WHERE id = %d",
                id
        );
        dbService.makeQuery(sqlQuery);
    }


    public List<Role> findAll() throws SQLException {
        String sqlQuery = "SELECT * FROM roles";
        ResultSet resultSet = dbService.makeQuery(sqlQuery);
        List<Role> roles = new ArrayList<>();
        if(resultSet != null){
            while(resultSet.next()){
                roles.add(
                        new Role(
                                resultSet.getLong("id"),
                                resultSet.getString("name")
                        )
                );
            }
        }
        return roles;
    }
}
