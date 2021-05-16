package com.yu_pharm.controller.buy;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/remove/basket")

public class RemoveFromBasketServ extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		CartBean bean = CartBean.get(session);
		int id = Integer.parseInt(request.getParameter("id"));
		try {
			bean.removeItem(id);
			response.sendRedirect(request.getContextPath() + "/basket");
		} catch (Exception ex) {
			getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
		}
	}
}

