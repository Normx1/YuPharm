package controller.Admin;

import dao.BasicDao;
import dao.DrugDao;
import model.Drug;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/adminDrugList")
public class AdminDrugList extends HttpServlet {
    BasicDao<Drug> drugDao = new DrugDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("drugs", drugDao.getAll());
        getServletContext().getRequestDispatcher("/AdminPage/adminDrugList.jsp").forward(request, response);
    }
}
