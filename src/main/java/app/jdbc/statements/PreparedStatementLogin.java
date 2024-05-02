package app.jdbc.statements;

import app.entity.User;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class PreparedStatementLogin {

    public static ResultSet retrieveUserLoginForPassword(Connection connection, String name) throws SQLException {
        String retrieveDataSQL = "SELECT * FROM public.\"accounts\" WHERE name = ?";
        PreparedStatement retrieveDataStatement = connection.prepareStatement(retrieveDataSQL);
        retrieveDataStatement.setString(1, name);
        ResultSet resultSet = retrieveDataStatement.executeQuery();
//        while (resultSet.next()) {
//            int id = resultSet.getInt("id");
//            String names = resultSet.getString("name");
//            String passwordHash = resultSet.getString("password");
//            String password = "1234";
//            System.out.println(BCrypt.checkpw(password, passwordHash));
//            System.out.println("ID: " + id + ", Name: " + names);
//
//        }
        return resultSet;
    }
}
