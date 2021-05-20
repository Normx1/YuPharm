package com.yu_pharm.controller;

import com.yu_pharm.dao.BasicDao;
import com.yu_pharm.dao.UserDao;
import com.yu_pharm.model.User;
import com.yu_pharm.model.drug.Drug;
import com.yu_pharm.model.drug.Drugs;
import com.yu_pharm.model.drug.SqlDrugs;
import com.yu_pharm.sql.JDBCConnector;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/")
public class MainPageServlet extends HttpServlet {
	private Drugs.Smart drugs;


	@Override
	public void init() throws ServletException {
		drugs = ((Drugs.Smart) getServletContext().getAttribute("drugs"));
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Drug.Smart> drug = drugs.all();
		int page = 1;
		int recordsPerPage = 2;
		if (request.getParameter("page") != null)
			page = Integer.parseInt(request.getParameter("page"));
		int noOfRecords = (int) drug.stream().count();
		int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
		List<Drug.Smart> drug1 = drug.stream().skip((page - 1) * recordsPerPage)
				.limit(recordsPerPage).collect(Collectors.toList());
		request.getServletContext().setAttribute("noOfPages", noOfPages);
		request.getServletContext().setAttribute("currentPage", page);
		request.getServletContext().setAttribute("drug", drug1);

		getServletContext().
				getRequestDispatcher("/mainPage.jsp").

				forward(request, response);
	}
}

