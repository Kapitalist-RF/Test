package app.servlet;

import app.entity.User;
import app.jdbc.statements.PreparedStatementRegistration;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class RegistrationServlet extends HttpServlet {

    public RegistrationServlet() {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        req.getRequestDispatcher("/WEB-INF/view/reg.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String salt = BCrypt.gensalt();
        String hashedPassword = BCrypt.hashpw(password, salt);
        User user = new User(name, hashedPassword);
        synchronized (this) {
            Connection connection = (Connection) getServletContext().getAttribute("postgresql");
            try {
                if(PreparedStatementRegistration.insertUser(connection, user)) {
                    req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, resp);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        resp.sendRedirect("/reg");
    }
}
