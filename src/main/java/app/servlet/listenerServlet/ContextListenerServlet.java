package app.servlet.listenerServlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ContextListenerServlet implements ServletContextListener {

    private Connection connection = null;

    @Override
    public void contextInitialized(ServletContextEvent sce) throws NullPointerException {
        final ServletContext servletContext = sce.getServletContext();
        InitialContext cxt = null;
        DataSource ds = null;
        try {
            cxt = new InitialContext();
            Context envContext = (Context) cxt.lookup("java:/comp/env");
            if (cxt == null) {
                throw new Exception("Uh oh -- no context!");
            }
            ds = (DataSource) envContext.lookup("jdbc/postgres");
            if (ds == null) {
                throw new Exception("Data source not found!");
            }
        } catch (NamingException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            connection = ds.getConnection();
            if (connection != null) {
                servletContext.setAttribute("postgresql", connection);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
