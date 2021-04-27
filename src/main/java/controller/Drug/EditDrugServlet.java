package controller.Drug;

import dao.BasicDao;
import dao.DrugDao;
import model.Drug;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/drug/edit")

public class EditDrugServlet extends HttpServlet {
   private BasicDao<Drug> drugDao = new DrugDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Drug drug =  drugDao.getById(id);
            if (drug.getId() != 0) {
                request.setAttribute("drug", drug);
                getServletContext().getRequestDispatcher("/editDrug.jsp").forward(request, response);
            } else {
                request.setAttribute("id", id);
                getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
            }

        } catch (Exception ex) {
            getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);

        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String drugName = request.getParameter("name");
            int count = Integer.parseInt(request.getParameter("count"));
            int cost = Integer.parseInt(request.getParameter("cost"));
            Drug drug = new Drug(id, drugName, cost, count);
            drugDao.updateById(drug);
            response.sendRedirect(request.getContextPath() + "/");
        } catch (Exception ex) {

            getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
        }

    }
}
