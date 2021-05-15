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

@WebServlet("/allRecipes")
public class AllRecipesServlet extends HttpServlet {
	RecipeDao<Recipe> recipeDao = new RecipeDaoImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setAttribute("recipe", recipeDao.getAll());
			getServletContext().getRequestDispatcher("/allRecipes.jsp").forward(request, response);
		} catch (
				Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}
}
