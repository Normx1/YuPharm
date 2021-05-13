package com.yu_pharm.controller.buy;

import com.sun.tools.javac.comp.Todo;
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

@WebServlet("/basket")
public class BasketServlet extends HttpServlet {
	private BasicDao<Drug> drugDao = new DrugDao();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		CartBean bean = CartBean.get(session);
		List<Integer> listId = bean.getIds();
		Drug cure = drugDao.getById(listId.get(0));
		// TODO: 13.05.2021 Реализовать метод вывода в корзину товаров 
 		try {
			req.setAttribute("cure", drugDao.getAll());
			getServletContext().getRequestDispatcher("/basket.jsp").forward(req, resp);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
