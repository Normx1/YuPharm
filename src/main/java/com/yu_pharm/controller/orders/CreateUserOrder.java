package com.yu_pharm.controller.orders;

import com.yu_pharm.controller.buy.CartBean;
import com.yu_pharm.dao.OrderDao;
import com.yu_pharm.model.Order;
import com.yu_pharm.model.drug.Drugs;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/createUserOrder")
public class CreateUserOrder extends HttpServlet {

	private Drugs.Smart drugs;
	private OrderDao<Order> orders;


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
			String address = request.getParameter("address");
			int payment = Integer.parseInt(request.getParameter("payment"));
			if (payment == 0) {
				response.sendRedirect(request.getContextPath() + "/payment");
			} else {
				List<Integer> ids = drugs.all().stream()
						.filter(b -> bean.getIds().contains(b.id()))
						.map(drug -> drug.id())
						.collect(Collectors.toList());
				int cost = (int) session.getAttribute("totalCost");

				for (int i = 0; i < ids.size(); i++) {
					Order order = new Order(ids.get(i), name, mail, phone, address, payment, cost);
					orders.create(order);
					response.sendRedirect("/");
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
