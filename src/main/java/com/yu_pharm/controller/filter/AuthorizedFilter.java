package com.yu_pharm.controller.filter;

import com.yu_pharm.dao.BasicDao;
import com.yu_pharm.dao.Role;
import com.yu_pharm.dao.UserDao;
import com.yu_pharm.model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Objects;

//@WebFilter({"/admin/*", "/drug/create","/user/*"})
public class AuthorizedFilter implements Filter {

	private final BasicDao<User> userBasicDao = new UserDao();

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

		if (!isUserAuthorized(httpServletRequest)) {
			throw new RuntimeException();
		}

		User user = userBasicDao.getByName((String) ((HttpServletRequest) servletRequest).getSession().getAttribute("userName"));
		if (user.getRole() == Role.admin) {
			filterChain.doFilter(servletRequest, servletResponse);
		} else {
			throw new RuntimeException("Not enough privileges");
		}
	}

	private boolean isUserAuthorized(HttpServletRequest httpServletRequest) {
		User user = (User) httpServletRequest.getSession().getAttribute("user");
		return Objects.nonNull(user);
	}
}
