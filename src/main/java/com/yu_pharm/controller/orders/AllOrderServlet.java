package com.yu_pharm.controller.orders;

import com.yu_pharm.dao.OrderDao;
import com.yu_pharm.model.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/admin/allOrders")
public class AllOrderServlet extends HttpServlet {

	private OrderDao<Order> order;


	@Override
	public void init() {
		order = ((OrderDao<Order>) getServletContext().getAttribute("orders"));
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int page = 1;
			int recordsPerPage = 10;
			List<Order> orderList = order.getAll();
			if (req.getParameter("page") != null)
				page = Integer.parseInt(req.getParameter("page"));
			int noOfRecords = (int) order.getAll().stream().count();
			int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
			req.setAttribute("noOfPages", noOfPages);
			req.setAttribute("currentPage", page);
			req.setAttribute("orders", orderList.stream().skip((long) (page - 1) * recordsPerPage)
					.limit(recordsPerPage).collect(Collectors.toList()));
			getServletContext().getRequestDispatcher("/admin/allOrders.jsp").forward(req, resp);
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}
}
