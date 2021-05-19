package com.yu_pharm.controller.recipe;


import com.yu_pharm.dao.RecipeDao;
import com.yu_pharm.dao.RecipeDaoImpl;
import com.yu_pharm.model.Recipe;
import com.yu_pharm.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;

@WebServlet("/recipe/edit")
public class EditRecipeServlet extends HttpServlet {
	RecipeDao<Recipe> recipeDao = new RecipeDaoImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int id = Integer.parseInt(request.getParameter("recId"));
			Recipe recipe = recipeDao.getById(id);

			if (recipe != null) {
				request.setAttribute("recipe", recipe);
				getServletContext().getRequestDispatcher("/admin/edit/recipeEdit.jsp").forward(request, response);
			} else {
				getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			int recId = Integer.parseInt(request.getParameter("recId"));
			int drugId = Integer.parseInt(request.getParameter("drugId"));
			int userId = Integer.parseInt(request.getParameter("userId"));
			Date expirationDate = Date.from(Instant.parse(request.getParameter("expirationDate")));
			int recipeCount = Integer.parseInt(request.getParameter("recipeCount"));
			Recipe recipe = new Recipe(recId, drugId, userId, expirationDate, recipeCount);
			recipeDao.updateById(recipe);
			response.sendRedirect(request.getContextPath() + "/adminRecipeList");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
