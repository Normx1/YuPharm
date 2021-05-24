package com.yu_pharm.controller.admin;

import com.yu_pharm.dao.Role;
import com.yu_pharm.dao.UserDao;
import com.yu_pharm.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.HttpMethodConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/admin/AdminMainPage")

//@ServletSecurity(httpMethodConstraints = {
//		@HttpMethodConstraint(value = "GET", rolesAllowed = ""),
//		@HttpMethodConstraint(value = "POST", rolesAllowed = "MANAGER")
//})
public class AdminMainList extends HttpServlet {
	private String message;
	private User user;
	private UserDao userDao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		HttpSession session = request.getSession();
//		message = (String) session.getAttribute("userName");
//
//		userDao.getByName(message).getRole();
//		if (user != null && user.getRole() == Role.admin) {
//			try {
				getServletContext().getRequestDispatcher("/admin/AdminMainPage.jsp").forward(request, response);
//
//			} catch (
//					Exception ex) {
//				System.out.println("not success" + "  " + ex);
//			}
//		} else {
//			try {
//				getServletContext().getRequestDispatcher("/").forward(request, response);

//			} catch (
//					Exception ex) {
//				System.out.println("not success" + "  " + ex);
//			}
//		}
	}
}
