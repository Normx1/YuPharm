package com.yu_pharm.controller.drug;

import com.yu_pharm.model.drug.Drug;
import com.yu_pharm.model.drug.Drugs;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/drug/info")
public class DrugInfoServlet extends HttpServlet {

	private Drugs.Smart drugs;


	@Override
	public void init() {
		drugs = ((Drugs.Smart) getServletContext().getAttribute("drugs"));
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			Drug.Smart drug = drugs.findById(id);
			request.setAttribute("drug", drug);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/drugInfo.jsp");
			dispatcher.forward(request, response);
		} catch (Exception ex) {
			getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
			throw ex;
		}
	}
}


