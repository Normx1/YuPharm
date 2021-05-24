package com.yu_pharm.controller.orders;

import com.mysql.cj.util.StringUtils;
import com.yu_pharm.controller.buy.CartBean;
import com.yu_pharm.dao.OrderDao;
import com.yu_pharm.dao.OrderDao_Imp;
import com.yu_pharm.model.Order;
import com.yu_pharm.model.Payment;
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

@WebServlet("/UserOrders")
public class UserOrders extends HttpServlet {

	private OrderDao<Order> order;
	String errorString = null;


	@Override

	public void init() {
		order = ((OrderDao<Order>) getServletContext().getAttribute("orders"));
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		try {
			int page = 1;
			int recordsPerPage = 5;
			List<Order> orderList = (List<Order>) order.getByUserMail((String) session.getAttribute("mail"));
			if (req.getParameter("page") != null)
				page = Integer.parseInt(req.getParameter("page"));
				int noOfRecords = (int) ((List<Order>) order.getByUserMail((String) session.getAttribute("mail"))).stream().count();
				if (noOfRecords == 0){
 					errorString = "You have no orders yet!";
					req.setAttribute("errorString", errorString);
					getServletContext().getRequestDispatcher(req.getContextPath()+"/userInfo").forward(req, resp);
				}
				int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
				req.setAttribute("noOfPages", noOfPages);
				req.setAttribute("currentPage", page);
				req.setAttribute("orderList", orderList.stream().skip((long) (page - 1) * recordsPerPage)
						.limit(recordsPerPage).collect(Collectors.toList()));
				getServletContext().getRequestDispatcher("/login/UserOrders.jsp").forward(req, resp);

		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}
}
