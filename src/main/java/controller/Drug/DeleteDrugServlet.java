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

@WebServlet("/drug/delete")

public class DeleteDrugServlet extends HttpServlet {
    BasicDao<Drug> drugDao = new DrugDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            drugDao.deleteById(id);
            response.sendRedirect(request.getContextPath() + "/");
//Полный путь
        } catch (Exception ex) {
            getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);

        }
    }
}
