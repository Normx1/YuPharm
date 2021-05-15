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
			String userName = req.getParameter("name");
  			String drugName = req.getParameter("drug");
			BasicDao<Drug> drug = new DrugDao();
			int id_drug = (drug.getByName(drugName)).getId();
			String mail = req.getParameter("mail");
			String phone = req.getParameter("phone");
			String address = req.getParameter("address");
			int payment = Integer.parseInt(req.getParameter("payment"));
			int cost = Integer.parseInt(req.getParameter("cost"));
			Order order = new Order(id, id_drug, userName, mail, phone, address, payment , cost);
			orderDao.updateById(order);
			resp.sendRedirect(req.getContextPath() + "/");
		} catch (Exception ex) {
			ex.printStackTrace();
			getServletContext().getRequestDispatcher("/notfound.jsp").forward(req, resp);
		}
	}
}
