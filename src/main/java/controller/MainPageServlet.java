package controller;

import dao.BasicDao;
import dao.DrugDao;
import dao.UserDao;
import model.Drug;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/")
public class MainPageServlet extends HttpServlet {
    BasicDao<Drug> drugsDao = new DrugDao();
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("drugs", drugsDao.getAll() );
        getServletContext().getRequestDispatcher("/WEB-INF/mainPage.jsp").forward(request, response);
    }

}
