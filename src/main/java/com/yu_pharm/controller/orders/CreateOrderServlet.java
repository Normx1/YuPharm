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

//		try {
//			HttpSession session = request.getSession();
//			CartBean bean = CartBean.get(session);
//			String drugName = request.getParameter("drug");
//			String id_drug = bean.getIds().stream().sorted().toString();
//			// TODO: 15.05.2021
//			String userName = request.getParameter("user");
//			String mail = request.getParameter("mail");
//			String phone = request.getParameter("phone");
//			String address = request.getParameter("address");
//			int payment = Integer.parseInt(request.getParameter("payment"));
//			int cost = Integer.parseInt(request.getParameter("cost"));
//
//			Order order = new Order(id_drug, userName, mail, phone, address, payment, cost);
//			orderDao.create(order);
//			response.sendRedirect(request.getContextPath() + "/allOrders");
		getServletContext().getRequestDispatcher("/createOrder.jsp").forward(request, response);


//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			String drugName = request.getParameter("drug");
			int drug = drugs.findByName(drugName).id();
			String userName = request.getParameter("user");
			String mail = request.getParameter("mail");
			String phone = request.getParameter("phone");
			String address = request.getParameter("address");
			int payment = Integer.parseInt(request.getParameter("payment"));
			int cost = Integer.parseInt(request.getParameter("cost"));

			Order<Integer, String> order = new Order<>(drug, userName, mail, phone, address, payment, cost);
			orders.create(order);
			response.sendRedirect(request.getContextPath() + "/allOrders");
		} catch (Exception ex) {
			ex.printStackTrace();
			getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
		}
	}
}
