package app.jdbc.statements;

import app.entity.User;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultSetLogin {

    public static User retrieveUserCheckPassword(ResultSet resultSet, String password) throws SQLException {
        User user = null;
        while (resultSet.next()) {
            String passwordHash = resultSet.getString("password");
            if(BCrypt.checkpw(password, passwordHash)) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                user = new User(id, name, "Dima");
                break;
            }
        }
        return user;
    }

}
