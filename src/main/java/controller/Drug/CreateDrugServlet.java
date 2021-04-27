package controller.Drug;

import dao.BasicDao;
import dao.DrugDao;
import model.Drug;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/drug/create")
public class CreateDrugServlet extends HttpServlet {
    BasicDao<Drug> drugDao = new DrugDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/createDrug.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String name = request.getParameter("name");
            int cost = Integer.parseInt(request.getParameter("cost"));
            int count = Integer.parseInt(request.getParameter("count"));
            Drug drugs = new Drug(name, cost, count);
            drugDao.create(drugs);
            response.sendRedirect(request.getContextPath() + "/createDrug.jsp");
        } catch (Exception ex) {
            getServletContext().getRequestDispatcher("/create").forward(request, response);
        }
    }
}
