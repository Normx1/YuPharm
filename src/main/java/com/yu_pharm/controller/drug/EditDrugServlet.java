package com.yu_pharm.controller.drug;

import com.yu_pharm.model.drug.Drug;
import com.yu_pharm.model.drug.Drugs;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/drug/edit")
public class EditDrugServlet extends HttpServlet {

	private Drugs.Smart drugs;


	@Override
	public void init() {
		drugs = ((Drugs.Smart) getServletContext().getAttribute("drugs"));
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Drug.Smart drug = drugs.findById(id);
		request.getSession().setAttribute("drug", drug);
		request.getServletContext().getRequestDispatcher("/admin/edit/editDrug.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Drug.Smart drug = drugs.findById(Integer.parseInt(request.getParameter("id")));
		drug.name(request.getParameter("name"));
		drug.cost(Double.parseDouble(request.getParameter("cost")));
		drug.count(Double.parseDouble(request.getParameter("count")));
		drug.recipe(Byte.parseByte(request.getParameter("recipe")));
		//drug.mainAction(request.getParameter("main_action"));
		//drug.description(request.getParameter("description"));
		//drug.application(request.getParameter("application"));
		response.sendRedirect(request.getContextPath() + "/adminDrugList");
	}
}
