package com.yu_pharm.controller.drug;

import com.yu_pharm.dao.BasicDao;
import com.yu_pharm.dao.DrugDao;
import com.yu_pharm.model.Drug;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/create")
public class CreateDrugServlet extends HttpServlet {
    BasicDao<Drug> drugDao = new DrugDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/Create/createDrug.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String name = request.getParameter("name");
            int cost = Integer.parseInt(request.getParameter("cost"));
            int count = Integer.parseInt(request.getParameter("count"));
            byte recipe = Byte.parseByte(request.getParameter("recipe"));
            String main_action = request.getParameter("main_action");
            String description =  request.getParameter("description");
            String application = request.getParameter("application");
            Drug drugs = new Drug(name, cost, count ,recipe,main_action, description, application);
            drugDao.create(drugs);
            response.sendRedirect(request.getContextPath() + "/adminDrugList");
        } catch (Exception ex) {
            getServletContext().getRequestDispatcher("/create").forward(request, response);
        }
    }
}
