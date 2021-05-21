package com.yu_pharm.controller.orders;

import com.yu_pharm.controller.buy.CartBean;
import com.yu_pharm.dao.OrderDao;
import com.yu_pharm.model.Order;
import com.yu_pharm.model.Payment;
import com.yu_pharm.model.drug.Drugs;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@WebServlet("/createOrder")
public class CreateOrderServlet extends HttpServlet {

	private Drugs.Smart drugs;
	private OrderDao<Order> orders;


	@Override
	public void init() {
		drugs = ((Drugs.Smart) getServletContext().getAttribute("drugs"));
		orders = ((OrderDao<Order>) getServletContext().getAttribute("orders"));
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/admin/create/createOrder.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		CartBean bean = CartBean.get(session);
		try {
			String userName = request.getParameter("user");
			String mail = request.getParameter("mail");
			String phone = request.getParameter("phone");
			String address = request.getParameter("address");
			Payment payment = Payment.valueOf(request.getParameter("payment"));
			int cost = Integer.parseInt(request.getParameter("cost"));

			Order order = new Order(new HashMap<>(), userName, mail, phone, address, cost, payment);
			for (Integer id : bean.getIds()) {
				order.addDrug(id, 1);
			}

			orders.create(order);
			response.sendRedirect(request.getContextPath() + "/allOrders");
		} catch (Exception ex) {
			ex.printStackTrace();
			getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
		}
	}
}
