package com.yu_pharm.controller.login;

import com.mysql.cj.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getSession().invalidate();
		Cookie cookie = new Cookie("user", null);
		cookie.setMaxAge(0);
		resp.addCookie(cookie);
		getServletContext().getRequestDispatcher("/").forward(req, resp);
	}
}
