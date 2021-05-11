package com.yu_pharm.controller.buy;

import com.yu_pharm.dao.BasicDao;
import com.yu_pharm.dao.DrugDao;
import com.yu_pharm.dao.OrderDao;
import com.yu_pharm.dao.OrderDao_Imp;
import com.yu_pharm.model.Drug;
import com.yu_pharm.model.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/basket")
public class BasketServlet extends HttpServlet {
	BasicDao<Drug> drug = new DrugDao();
	List<Drug> listOfDrugs = new ArrayList<>();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		CartBean bean = CartBean.get(session);
		for (Integer integer : bean.getIds()) {
			listOfDrugs.add(drug.getById(integer));
		}
		req.setAttribute("drugs", listOfDrugs);
		getServletContext().getRequestDispatcher("/basket.jsp").forward(req, resp);
	}
}
