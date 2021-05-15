package com.yu_pharm.controller.orders;

import com.yu_pharm.controller.buy.CartBean;
import com.yu_pharm.dao.*;
import com.yu_pharm.model.Drug;
import com.yu_pharm.model.Order;
import com.yu_pharm.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/createUserOrder")
public class CreateUserOrder extends HttpServlet {
	List<Drug> drugList = new ArrayList<>();
	OrderDao<Order> orderDao = new OrderDao_Imp();
	BasicDao<Drug> drugDao = new DrugDao();
	BasicDao<User> userDao = new UserDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/detailOfOrder.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		HttpSession session = request.getSession();
		CartBean bean = CartBean.get(session);

		try {
			String name = request.getParameter("name");
			String mail = request.getParameter("mail");
			String phone =   request.getParameter("phone");
			String address = request.getParameter("address");
			int payment = Integer.parseInt(request.getParameter("payment"));
			drugDao.getAll().stream().filter(b -> bean.getIds()
					.contains(b.getId()))
					.collect(Collectors.toList());
			int cost = (int) session.getAttribute("totalCost");
			Order order = new Order<BasicDao<Drug>, String>(drugDao, cost, name, address, phone, payment);

			if (payment == 0) {
				session.setAttribute("order",order);
				response.sendRedirect(request.getContextPath() + "/paymentCard");
			} else {
				orderDao.create(order);
				response.sendRedirect(request.getContextPath() + "/");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
