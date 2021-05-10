package com.yu_pharm.controller.admin;

import com.yu_pharm.dao.BasicDao;
import com.yu_pharm.dao.UserDao;
import com.yu_pharm.model.User;

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
        getServletContext().getRequestDispatcher("/adminUserList.jsp").forward(request, response);
    }
}
