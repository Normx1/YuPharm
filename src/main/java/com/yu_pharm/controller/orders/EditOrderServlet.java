package com.yu_pharm.controller.orders;

import com.yu_pharm.dao.*;
import com.yu_pharm.model.Drug;
import com.yu_pharm.model.Order;
import com.yu_pharm.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/order/edit")
public class EditOrderServlet extends HttpServlet {
	OrderDao<Order> orderDao = new OrderDao_Imp();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int id = Integer.parseInt((req.getParameter("id")));
			System.out.println(id);
			Order order = orderDao.getByOrderId(id);

			if (order != null) {
				req.setAttribute("order", order);
				getServletContext().getRequestDispatcher("/editOrder.jsp").forward(req, resp);
			} else {
				getServletContext().getRequestDispatcher("/notfound.jsp").forward(req, resp);
			}
		} catch (Exception ex) {
//			getServletContext().getRequestDispatcher("/notfound.jsp").forward(req, resp);
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			int id = Integer.parseInt(req.getParameter("id_Order"));
			String userName = req.getParameter("user");
			BasicDao<User> user = new UserDao();
			int id_user = (user.getByName(userName)).getId();
			System.out.println(id_user);
			String drugName = req.getParameter("drug");
			/// TODO: 10.05.2021 Сделать обработку ошибки на Юзера и Лекарства, если такие не найдены.
			BasicDao<Drug> drug = new DrugDao();
			int id_drug = (drug.getByName(drugName)).getId();

			int count = Integer.parseInt(req.getParameter("count"));
			int cost = Integer.parseInt(req.getParameter("cost"));
			Order order = new Order(id, id_drug, id_user, count, cost);
			orderDao.updateById(order);
			resp.sendRedirect(req.getContextPath() + "/");
		} catch (Exception ex) {
			ex.printStackTrace();
			getServletContext().getRequestDispatcher("/notfound.jsp").forward(req, resp);
		}
	}
}
