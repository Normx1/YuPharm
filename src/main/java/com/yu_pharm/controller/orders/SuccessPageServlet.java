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
import java.util.stream.Collectors;

@WebServlet("/success")
public class SuccessPageServlet extends HttpServlet {

	private Drugs.Smart drugs;
	private OrderDao<Order> orders;

	@Override
	public void init() {
		drugs = ((Drugs.Smart) getServletContext().getAttribute("drugs"));
		orders = ((OrderDao<Order>) getServletContext().getAttribute("orders"));
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		CartBean bean = CartBean.get(session);
		req.setAttribute("cures", drugs.all().stream()
				.filter(b -> bean.getIds().contains(b.id()))
				.collect(Collectors.toList()));

		drugs.all().stream()
				.filter(b -> bean.getIds().contains(b.id())).forEach(s-> System.out.println(s.id()));
		getServletContext().getRequestDispatcher("/buyAndBasket/success.jsp").forward(req, resp);
	}
}
