package com.yu_pharm.controller.buy;

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
import java.util.stream.IntStream;

@WebServlet("/basket")
public class BasketServlet extends HttpServlet {
	boolean hasError = false;
	String errorString = null;

	private Drugs.Smart drugs;

	@Override
	public void init() {
		drugs = ((Drugs.Smart) getServletContext().getAttribute("drugs"));
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		CartBean bean = CartBean.get(session);
		try {


			if (bean.getIds().stream().count() == 0) {
				if (req.getSession().getAttribute("language").equals("en_EN")) {
					errorString = "You haven't added any cure!";
				} else {
					errorString = "Вы не добавили ни одного лекарства!";
				}
				req.setAttribute("errorString", errorString);
				getServletContext().getRequestDispatcher("/mainPage.jsp").forward(req, resp);
			}
			double totalCost = 0;
			List<Integer> idDrugs = bean.getIds().stream().collect(Collectors.toList());
			for (int i = 0; i < idDrugs.size(); i++) {
				totalCost = totalCost + drugs.findById(idDrugs.get(i)).cost();
			}
			session.setAttribute("cure", drugs.all().stream()
					.filter(b -> bean.getIds().contains(b.id()))
					.collect(Collectors.toList()));
			session.setAttribute("totalCost", totalCost);
			getServletContext().getRequestDispatcher("/buyAndBasket/basket.jsp").forward(req, resp);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}

