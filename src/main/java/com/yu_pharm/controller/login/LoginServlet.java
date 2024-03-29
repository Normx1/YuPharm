package com.yu_pharm.controller.login;

import com.yu_pharm.controller.util.DBUtils;
import com.yu_pharm.model.User;
import com.yu_pharm.sql.JDBCConnector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;

@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/login/loginView.jsp").forward(request, response);
	}

	// Когда пользователь вводит userName & password, и нажимает Submit.
	// Этот метод будет выполнен.
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String mail = request.getParameter("mail");
		String password = request.getParameter("password");
		String rememberMeStr = request.getParameter("rememberMe");
		boolean remember = "Y".equals(rememberMeStr);


		User user = null;
		boolean hasError = false;
		String errorString = null;

		if (name == null || password == null || mail == null || name.length() == 0 || mail.length() == 0 || password.length() == 0) {
			hasError = true;
			if (request.getSession().getAttribute("language").equals("en_EN")) {
				errorString = "Required username and password!";
			} else {
				errorString = "Заполните поля Имя и Пароль!";
			}

		} else {
			try (Connection conn = JDBCConnector.getConnection()) {
				// Найти user в DB.
				user = DBUtils.findUser(conn, name, mail, password);
				if (user == null) {
					hasError = true;
					if (request.getSession().getAttribute("language").equals("en_EN")) {
						errorString = "User Name or password invalid";
					} else {
						errorString = "Неправильное значение поля Имя или Пароль!";
					}
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
				hasError = true;
				errorString = ex.getMessage();
			}

		}
		// В случае, если есть ошибка,
		// forward (перенаправить) к /WEB-INF/views/login.jsp
		if (hasError) {
			user = new User();
			user.setName(name);
			user.setPassword(password);

			// Сохранить информацию в request attribute перед forward.
			request.setAttribute("errorString", errorString);

			// Forward (перенаправить) к странице /WEB-INF/views/login.jsp
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/login/loginView.jsp");

			dispatcher.forward(request, response);
		}
		// В случае, если нет ошибки.
		// Сохранить информацию пользователя в Session.
		// И перенаправить к странице userInfo.
		else {
			HttpSession session = request.getSession();
			session.setAttribute("mail", user.getMail());
			session.setAttribute("user", user);
			// Если пользователь выбирает функцию "Remember me".
			if (remember) {
				Cookie cookie = new Cookie("user", user.getName());
				cookie.setMaxAge(24 * 60 * 60);
				response.addCookie(cookie);
			}
			// Наоборот, удалить Cookie
			else {
				Cookie cookieUserName = new Cookie("user", null);
				cookieUserName.setMaxAge(0);
				response.addCookie(cookieUserName);
			}
			response.sendRedirect(request.getContextPath() + "/userInfo");
		}
	}

}
