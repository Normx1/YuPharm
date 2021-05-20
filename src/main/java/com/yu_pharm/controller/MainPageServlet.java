package com.yu_pharm.controller;

import com.yu_pharm.dao.BasicDao;
import com.yu_pharm.dao.UserDao;
import com.yu_pharm.model.User;
import com.yu_pharm.model.drug.Drug;
import com.yu_pharm.model.drug.Drugs;
import com.yu_pharm.model.drug.SqlDrugs;
import com.yu_pharm.sql.JDBCConnector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/")
public class MainPageServlet extends HttpServlet {
	private final ConnectionSource connection = new ConnectionSource();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int page = 1;
		int recordsPerPage = 2;
		if (request.getParameter("page") != null)
			page = Integer.parseInt(request.getParameter("page"));
		try {
			Drugs.Smart drugs = new Drugs.Smart(new SqlDrugs(connection));
 			int noOfRecords = (int) drugs.all().stream().count();

			int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
			request.setAttribute("employeeList", drugs);
			request.setAttribute("noOfPages", noOfPages);
			request.setAttribute("currentPage", page);
			request.setAttribute("drug", drugs);
			getServletContext().getRequestDispatcher("/mainPage.jsp").forward(request, response);

		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
}
