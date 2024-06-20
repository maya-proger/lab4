package org.majic.daos;
import org.majic.models.User;
import org.majic.services.DBService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDao {

    DBService dbService = new DBService();

    public Optional<User> findById(int id) throws SQLException {
        String sqlQuery = String.format(
                "SELECT * FROM users WHERE id = %d",
                id
        );
        ResultSet resultSet = dbService.makeQuery(sqlQuery);
        if(resultSet != null){
            resultSet.next();
            return Optional.of(new User(
                    resultSet.getLong("id"),
                    resultSet.getString("username"),
                    resultSet.getString("email"),
                    resultSet.getString("password_hash")
            ));
        }
        return Optional.empty();
    }

    public void save(User user) {
        String sqlQuery = String.format(
                "INSERT INTO public.users VALUES (nextval('public.users_seq'), '%s', '%s', '%s')",
                user.getUsername(),
                user.getEmail(),
                user.getPassword_hash()
        );
        dbService.makeQuery(sqlQuery);
    }

    public void update(User user) {
        String sqlQuery = String.format(
                "UPDATE users SET username = '%s', email = '%s', password_hash = '%s' WHERE id = %d",
                user.getUsername(),
                user.getEmail(),
                user.getPassword_hash(),
                user.getId()
        );
        dbService.makeQuery(sqlQuery);
    }

    public void delete(Long id) {
        String sqlQuery = String.format(
                "DELETE FROM users WHERE id = %d",
                id
        );
        dbService.makeQuery(sqlQuery);
    }


    public List<User> findAll() throws SQLException {
        String sqlQuery = "SELECT * FROM users";
        ResultSet resultSet = dbService.makeQuery(sqlQuery);
        List<User> users = new ArrayList<>();
        if(resultSet != null){
            while(resultSet.next()){
                users.add(
                        new User(
                                resultSet.getLong("id"),
                                resultSet.getString("username"),
                                resultSet.getString("email"),
                                resultSet.getString("password_hash")
                        )
                );
            }
        }
        return users;
    }
}
