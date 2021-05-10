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
			int id = Integer.parseInt(req.getParameter("id_Order"));
			System.out.println(id);
			orderDao.deleteById(id);
			resp.sendRedirect("/allOrders");
 		} catch (Exception ex) {
 			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}
}
