package com.yu_pharm.controller.admin;

import com.yu_pharm.model.User;
import com.yu_pharm.model.drug.Drug;
import com.yu_pharm.model.drug.Drugs;
import com.yu_pharm.model.drug.SimpleDrugs;
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
import java.util.stream.Collectors;

@WebServlet("/adminDrugList")

public class AdminDrugList extends HttpServlet {
	private Drugs.Smart drugs;


	@Override
	public void init() throws ServletException {
		drugs = ((Drugs.Smart) getServletContext().getAttribute("drugs"));
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Drug.Smart> drug = drugs.all();
		drug.stream().forEach(s -> System.out.println(s.id()));
		int page = 1;
		int recordsPerPage = 2;
		if (request.getParameter("page") != null)
			page = Integer.parseInt(request.getParameter("page"));
		int noOfRecords = (int) drug.stream().count();
		int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
		List<Drug.Smart> Drug = drug.stream().skip((page - 1) * recordsPerPage)
				.limit(recordsPerPage).collect(Collectors.toList());
		request.setAttribute("noOfPages", noOfPages);
		request.setAttribute("currentPage", page);
		request.setAttribute("drug",Drug);
		getServletContext().getRequestDispatcher("/admin/adminDrugList.jsp").forward(request, response);
	}
}

