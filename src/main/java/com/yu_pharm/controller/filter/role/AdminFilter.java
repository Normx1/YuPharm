package com.yu_pharm.controller.filter.role;

import com.yu_pharm.dao.BasicDao;
import com.yu_pharm.model.Role;
import com.yu_pharm.dao.UserDao;
import com.yu_pharm.model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "Admin filter", urlPatterns = {"/drug/*", "/user/*", "/admin/*"})
public class AdminFilter implements Filter {

	BasicDao<User> users = new UserDao();


	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpSession session = ((HttpServletRequest) request).getSession();
		User user = ((User) session.getAttribute("user"));
		if (user != null) {
			user = users.getByName(user.getName());
			if (user.getRoles().contains(Role.Admin)) {
				chain.doFilter(request, response);
			} else {
				throw new RuntimeException("You do not have enough access rights");
			}
		} else {
			throw new RuntimeException("User is not logged in");
		}
	}
}
