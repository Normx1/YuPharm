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

@WebServlet("/createOrder")
public class CreateOrderServlet extends HttpServlet {
	OrderDao<Order> orderDao = new OrderDao_Imp();
	BasicDao<Drug> drugDao = new DrugDao();
	BasicDao<User> userDao = new UserDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/createOrder.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String drugName = request.getParameter("drug");
			int id_drug = (drugDao.getByName(drugName)).getId();
			String userName = request.getParameter("user");
			int id_user = (userDao.getByName(userName)).getId();
			int count = Integer.parseInt(request.getParameter("count"));
			int cost = Integer.parseInt(request.getParameter("cost"));

			Order order = new Order(id_drug,id_user,count,cost);
 			orderDao.create(order);
			response.sendRedirect(request.getContextPath() + "/allOrders");
		} catch (Exception ex) {
			ex.printStackTrace();
			getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);		}
	}
}