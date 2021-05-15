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

@WebServlet ("/deleteRecipe")
public class DeleteRecipeServlet extends HttpServlet {
	RecipeDao<Recipe> recipeDao = new RecipeDaoImpl();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			//Отличие sendRedirect  и forward в том что 1 показывает url не полный а 2 полный путь, вроде так
			int id = Integer.parseInt(request.getParameter("recId"));
			recipeDao.deleteById(id);
			response.sendRedirect(request.getContextPath() + "/adminRecipeList");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
