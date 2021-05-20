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
import java.util.List;

@WebServlet("/PaginationUser")
public class AdminUserListPagination extends HttpServlet {
	BasicDao<User> userDao = new UserDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
 		int page = 1;
		int recordsPerPage = 2;
		if (request.getParameter("page") != null)
			page = Integer.parseInt(request.getParameter("page"));
		List<User> list = userDao.getAllPagination((page - 1) * recordsPerPage,
				recordsPerPage);
		int noOfRecords = (int) userDao.getAll().stream().count();
		int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
		request.setAttribute("employeeList", list);
		request.setAttribute("noOfPages", noOfPages);
		request.setAttribute("currentPage", page);
		request.setAttribute("users", list);
		getServletContext().getRequestDispatcher("/admin/PaginationUser.jsp").forward(request, response);
	}
}
