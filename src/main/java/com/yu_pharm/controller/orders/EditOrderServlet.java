package com.yu_pharm.controller.orders;

import com.yu_pharm.dao.OrderDao;
import com.yu_pharm.model.Order;
import com.yu_pharm.model.drug.Drugs;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/order/edit")
public class EditOrderServlet extends HttpServlet {

	private Drugs.Smart drugs;
	private OrderDao<Order> orders;


	@Override
	public void init() {
		drugs = ((Drugs.Smart) getServletContext().getAttribute("drugs"));
		orders = ((OrderDao<Order>) getServletContext().getAttribute("orders"));
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int id = Integer.parseInt((req.getParameter("id")));
			System.out.println(id);
			Order order = orders.getByOrderId(id);

			if (order != null) {
				req.setAttribute("order", order);
				getServletContext().getRequestDispatcher("/editOrder.jsp").forward(req, resp);
			} else {
				getServletContext().getRequestDispatcher("/notfound.jsp").forward(req, resp);
			}
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int id = Integer.parseInt(req.getParameter("id_order"));
			String userName = req.getParameter("user");
  			String drugName = req.getParameter("drug");
			int id_drug = drugs.findByName(drugName).id();
			String mail = req.getParameter("mail");
			String phone = req.getParameter("phone");
			String address = req.getParameter("address");
			int payment = Integer.parseInt(req.getParameter("payment"));
			int cost = Integer.parseInt(req.getParameter("cost"));
			Order order = new Order(id, id_drug, userName, mail, phone, address, payment , cost);
			orders.updateById(order);
			resp.sendRedirect(req.getContextPath() + "/allOrders");
		} catch (Exception ex) {
			ex.printStackTrace();
			getServletContext().getRequestDispatcher("/notfound.jsp").forward(req, resp);
		}
	}
}
