package com.yu_pharm.controller.orders;

import com.yu_pharm.dao.OrderDao;
import com.yu_pharm.model.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/allOrders")
public class AllOrderServlet extends HttpServlet {

	private OrderDao<Order> order;


	@Override
	public void init() {
		order = ((OrderDao<Order>) getServletContext().getAttribute("orders"));
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setAttribute("order", order.getAll());
			getServletContext().getRequestDispatcher("/allOrders.jsp").forward(req, resp);
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}
}
