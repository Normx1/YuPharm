package com.yu_pharm.controller.user;

import com.yu_pharm.dao.BasicDao;
import com.yu_pharm.dao.UserDao;
import com.yu_pharm.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/delete")
public class DeleteUserServlet extends HttpServlet {

    BasicDao<User> userBasicDao = new UserDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            //Отличие sendRedirect  и forward в том что 1 показывает url не полный а 2 полный путь, вроде так
            int id = Integer.parseInt(request.getParameter("id"));
            userBasicDao.deleteById(id);
			response.sendRedirect(request.getContextPath() + "/admin/adminUserList");
        } catch (Exception ex) {
            getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
        }
    }
}

