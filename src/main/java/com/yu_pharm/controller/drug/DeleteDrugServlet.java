package com.yu_pharm.controller.drug;

import com.yu_pharm.model.drug.Drugs;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/drug/delete")
public class DeleteDrugServlet extends HttpServlet {

	private final Drugs.Smart drugs = ((Drugs.Smart) getServletContext().getAttribute("drugs"));


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			int id = Integer.parseInt(request.getParameter("id"));
			drugs.findById(id).delete();
			response.sendRedirect(request.getContextPath() + "/adminDrugList");
		} catch (Exception ex) {
			getServletContext().getRequestDispatcher("notfound.jsp").forward(request, response);
		}
	}
}
