package com.yu_pharm.controller.admin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/AdminMainPage")
public class AdminMainList extends HttpServlet {
	private String message;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			getServletContext().getRequestDispatcher("/AdminMainPage.jsp").forward(request, response);

		} catch (
				Exception ex) {
			System.out.println("not success" + "  " + ex);
		}

	}
}
