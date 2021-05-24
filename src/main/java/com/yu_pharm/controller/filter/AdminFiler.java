package com.yu_pharm.controller.filter;

import com.yu_pharm.dao.Role;
import com.yu_pharm.model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

@WebFilter(urlPatterns = {"/AdminMainPage"})

public class AdminFiler implements Filter {
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
		HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

		if (!isUserAuthorized(httpServletRequest)) {
			filterChain.doFilter(servletRequest, servletResponse);
			System.out.println("Its worked!");
		} else {
			User user = (User) httpServletRequest.getSession().getAttribute("user");
			switch (user.getRole()) {
				case user:
					httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/");
					break;
				case admin:
					httpServletResponse.sendRedirect("/AdminMainPage.jsp");
					break;
				default:
					throw new EnumConstantNotPresentException(Role.class, user.getRole().name());
			}
		}
	}
	private boolean isUserAuthorized(HttpServletRequest httpServletRequest) {
		User user = (User) httpServletRequest.getSession().getAttribute("user");
		return Objects.nonNull(user);
	}

}
