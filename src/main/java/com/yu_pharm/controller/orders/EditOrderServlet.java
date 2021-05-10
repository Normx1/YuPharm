package com.yu_pharm.controller.orders;

import com.yu_pharm.dao.OrderDao;
import com.yu_pharm.dao.OrderDao_Imp;
import com.yu_pharm.model.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/order/edit")
public class EditOrderServlet extends HttpServlet {
	OrderDao<Order> orderDao = new OrderDao_Imp();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int id = Integer.parseInt((req.getParameter("id_order")));
			Order order = orderDao.getByOrderId(id);

			if (order != null) {
				req.setAttribute("order", order);
				getServletContext().getRequestDispatcher("/editOrder.jsp").forward(req, resp);
			} else {
				getServletContext().getRequestDispatcher("/notfound.jsp").forward(req, resp);
			}
		} catch (Exception ex) {
			getServletContext().getRequestDispatcher("/notfound.jsp").forward(req, resp);
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			int id = Integer.parseInt(req.getParameter("id_order"));
			int id_user = Integer.parseInt(req.getParameter("id_user"));
			int id_drug = Integer.parseInt(req.getParameter("id_drug"));
			int count = Integer.parseInt(req.getParameter("count"));
			int cost = Integer.parseInt(req.getParameter("cost"));
			Order order = new Order(id, id_user, id_drug, count, cost);
			orderDao.updateById(order);
			resp.sendRedirect(req.getContextPath() + "/");
		} catch (Exception ex) {
			ex.printStackTrace();
			getServletContext().getRequestDispatcher("/notfound.jsp").forward(req, resp);
		}
	}
}
