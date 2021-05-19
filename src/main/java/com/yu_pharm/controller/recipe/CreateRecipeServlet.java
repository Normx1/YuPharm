package com.yu_pharm.controller.recipe;


import com.yu_pharm.dao.RecipeDao;
import com.yu_pharm.dao.RecipeDaoImpl;
import com.yu_pharm.model.Recipe;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;

@WebServlet("/createRecipe")
public class CreateRecipeServlet extends HttpServlet {
	RecipeDao<Recipe> recipeDao = new RecipeDaoImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/admin/create/createRecipe.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int drugId = Integer.parseInt(request.getParameter("drugId"));
			int userId = Integer.parseInt(request.getParameter("userId"));
			Date expDate = Date.from(Instant.parse(request.getParameter("expirationDate")));
			int recipeCount = Integer.parseInt(request.getParameter("recipeCount"));
			Recipe recipe = new Recipe(drugId, userId, expDate, recipeCount);
			recipeDao.create(recipe);
			response.sendRedirect(request.getContextPath() + "/adminRecipeList");
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}
}
