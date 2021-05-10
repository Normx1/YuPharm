package com.yu_pharm.controller.basket;

import com.yu_pharm.dao.OrderDao;
import com.yu_pharm.dao.OrderDao_Imp;
import com.yu_pharm.model.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/allOrders")
public class AllOrderServlet extends HttpServlet {
	OrderDao<Order> order = new OrderDao_Imp();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("order", order.getAll());
		getServletContext().getRequestDispatcher("/OrderPage/allOrders.jsp");
	}
}
