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
import java.util.List;

@WebServlet("/drugBuy")
public class AddToBasketServlet extends HttpServlet {
	BasicDao<Drug> drugDao = new DrugDao();
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			CartBean bean = CartBean.get(session);
			for (String value : request.getParameterValues("drug_id"))
				if (!value.trim().isEmpty())
					bean.addItem(Integer.parseInt(value.trim()));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		response.sendRedirect(request.getContextPath()+"/");

	}
@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendError(HttpServletResponse.SC_BAD_REQUEST, "GET requests are not supported");
	}
}
