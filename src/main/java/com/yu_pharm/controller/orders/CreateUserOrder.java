package com.yu_pharm.controller.orders;

import com.mysql.cj.util.StringUtils;
import com.yu_pharm.controller.buy.CartBean;
import com.yu_pharm.dao.OrderDao;
import com.yu_pharm.dao.OrderDao_Imp;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@WebServlet("/createUserOrder")
public class CreateUserOrder extends HttpServlet {

	private Drugs.Smart drugs;
	private OrderDao<Order> orders;

	String errorString = null;


	@Override
	public void init() {
		drugs = ((Drugs.Smart) getServletContext().getAttribute("drugs"));
		orders = ((OrderDao<Order>) getServletContext().getAttribute("orders"));
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/buyAndBasket/detailOfOrder.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		CartBean bean = CartBean.get(session);
		try {
			String name = request.getParameter("name");
			String mail = request.getParameter("mail");
			String phone = request.getParameter("phone");
			if (StringUtils.isStrictlyNumeric(phone) != true) {
				if (request.getSession().getAttribute("language").equals("en_EN")) {
					errorString = "The phone number should include only numbers!";
				} else {
					errorString = "Номер телефона должен содеражать только цифры!";
				}
				getServletContext().getRequestDispatcher(request.getContextPath() + "/buyAndBasket/detailOfOrder.jsp").forward(request, response);
				System.out.println(errorString);
			}
			String address = request.getParameter("address");
			Payment payment = Payment.valueOf(request.getParameter("payment"));
			Map<Integer, Integer> drugID = bean.getIds().stream().collect(Collectors.toMap(v -> v, v -> 1));
			double cost = 0;
			cost = bean.getIds().stream().map(i -> drugs.findById(i)).mapToDouble(drug -> drug.cost()).sum();
			Order order = new Order(drugID, name, mail, phone, address, cost, payment);
			orders.create(order);
			int idOfOrder = order.getId();
			session.setAttribute("idOfOrder", idOfOrder);
			session.setAttribute("order", order);
			if (payment == Payment.ByCardOnline) {
				response.sendRedirect(request.getContextPath() + "/payment");
			} else {
				response.sendRedirect("/success");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
