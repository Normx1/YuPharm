package com.yu_pharm.controller.buy;

import com.yu_pharm.dao.BasicDao;
import com.yu_pharm.dao.DrugDao;
import com.yu_pharm.model.Drug;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@WebServlet("/basket")
public class BasketServlet extends HttpServlet {
	private BasicDao<Drug> drugDao = new DrugDao();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		CartBean bean = CartBean.get(session);
		int totalCost = 0;

		for (int i = 0; i < bean.length(); i++) {
			totalCost = totalCost + drugDao.getById(bean.getId(i)).getCost();
		}
		System.out.println(totalCost);
		// TODO: 15.05.2021 Баг- добавляет каждый раз стоимость т.к. она вся в сессии
		try {
			session.setAttribute("cure", drugDao.getAll().stream().filter(b -> bean.getIds()
					.contains(b.getId()))
					.collect(Collectors.toList()));
			session.setAttribute("totalCost", totalCost);


			getServletContext().getRequestDispatcher("/basket.jsp").forward(req, resp);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
