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

@WebServlet("/order/delete")
public class DeleteOrderServlet extends HttpServlet {
	OrderDao<Order> orderDao = new OrderDao_Imp();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int id = Integer.parseInt(req.getParameter("id_order"));
			orderDao.deleteById(id);
			resp.sendRedirect("/allOrders");
			// TODO: 10.05.2021 Добавить путь ?
		} catch (Exception ex) {
			getServletContext().getRequestDispatcher("notfound.jsp").forward(req, resp);
			System.out.println("not success" + "  " + ex);
		}
	}
}
