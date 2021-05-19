package com.yu_pharm.controller.buy;

import com.yu_pharm.model.drug.Drugs;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.stream.Collectors;

@WebServlet("/basket")
public class BasketServlet extends HttpServlet {

	private Drugs.Smart drugs;


	@Override
	public void init() {
		drugs = ((Drugs.Smart) getServletContext().getAttribute("drugs"));
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		CartBean bean = CartBean.get(session);
		double totalCost = 0;

		for (int i = 0; i < bean.length(); i++) {
			totalCost = totalCost + drugs.findById(bean.getId(i)).cost();
		}

		session.setAttribute("cure", drugs.all().stream()
				.filter(b -> bean.getIds().contains(b.id()))
				.collect(Collectors.toList()));
		session.setAttribute("totalCost", totalCost);

		getServletContext().getRequestDispatcher("/buy&basket/basket.jsp").forward(req, resp);
	}
}
