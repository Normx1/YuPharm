package com.yu_pharm.controller.user;

import com.yu_pharm.dao.BasicDao;
import com.yu_pharm.model.Role;
import com.yu_pharm.dao.UserDao;
import com.yu_pharm.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@WebServlet("/user/create")
public class CreateUserServlet extends HttpServlet {
	BasicDao<User> userDao = new UserDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/login/registration.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String name = request.getParameter("name");
			String mail = request.getParameter("mail");
			String password = request.getParameter("password");
			Set<Role> roles = Set.of(Role.User);
			User users = new User(name, mail,password, roles);
			userDao.create(users);
			response.sendRedirect(request.getContextPath() + "/adminUserList");
		} catch (
				Exception ex) {
			ex.printStackTrace();
			getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
		}
	}
}
