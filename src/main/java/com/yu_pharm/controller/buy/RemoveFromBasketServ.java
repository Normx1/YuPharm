package com.yu_pharm.controller.buy;

import com.yu_pharm.dao.BasicDao;
import com.yu_pharm.dao.DrugDao;
import com.yu_pharm.dao.UserDao;
import com.yu_pharm.model.Drug;
import com.yu_pharm.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/remove/basket")

public class RemoveFromBasketServ extends HttpServlet {
	private BasicDao<Drug> drugDao = new DrugDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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

