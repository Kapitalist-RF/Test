package app.servlet;

import app.entity.User;
import app.jdbc.statements.PreparedStatementLogin;
import app.jdbc.statements.ResultSetLogin;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginServlet extends HttpServlet {

    public LoginServlet() {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");

        Connection connection = (Connection) getServletContext().getAttribute("postgresql");

        try {
            ResultSet resultSet = PreparedStatementLogin.retrieveUserLoginForPassword(connection, name);
            User user = ResultSetLogin.retrieveUserCheckPassword(resultSet, password);
            if(user != null) {
             //   req.setAttribute("user", user);
                HttpSession session = req.getSession();
                session.setMaxInactiveInterval(1800);
                session.setAttribute("user", user);
               // req.getRequestDispatcher("/WEB-INF/view/user.jsp").forward(req, resp);
                resp.sendRedirect("/WBFinancialWeb_war_exploded/user");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
