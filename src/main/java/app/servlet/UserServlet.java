package app.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;

@MultipartConfig
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        req.getRequestDispatcher("/WEB-INF/view/user.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String attribute = req.getParameter("attribute");
        System.out.println(attribute);
        if(attribute.equals("processing")) {

            for (Part part : req.getParts()) {
                String contextDirectory = getServletContext().getRealPath("");
                String directoryName = contextDirectory + File.separator + part.getName();
                if(directoryName.endsWith("filesCostPrice") || directoryName.endsWith("filesFinancialFileWB")) {
                    String fileName = part.getSubmittedFileName();
                    if(fileName.isEmpty()) {
                        doGet(req, resp);
                    }
                    File uploadDir = new File(directoryName);
                    if (!uploadDir.exists()) {
                        uploadDir.mkdir();
                    }

                    File file = new File(directoryName + File.separator + fileName);
                    URL url = file.toURI().toURL();
                    req.setAttribute("url", url);
                    part.write(String.valueOf(file));

                }
            }

        }



        doGet(req,resp);

    }

}
