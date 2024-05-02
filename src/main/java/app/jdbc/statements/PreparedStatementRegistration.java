package app.jdbc.statements;

import app.entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class PreparedStatementRegistration {

    public static boolean insertUser(Connection connection, User user) throws SQLException {
        String insertUserSQL = "INSERT INTO public.\"accounts\"(name, password) VALUES (?, ?)";
        PreparedStatement insertUserStatement = connection.prepareStatement(insertUserSQL);
        insertUserStatement.setString(1, user.getName());
        insertUserStatement.setString(2, user.getPassword());
        insertUserStatement.executeUpdate();
        return true;
    }

}
