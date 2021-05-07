package controller.Admin;

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

@WebServlet("/adminUserList")
public class AdminUserList extends HttpServlet {
    BasicDao<User> userDao = new UserDao();
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("users", userDao.getAll());
        getServletContext().getRequestDispatcher("/AdminPage/adminUserList.jsp").forward(request, response);
    }
}