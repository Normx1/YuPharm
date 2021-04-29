package controller.DrugInfo;

import dao.BasicDao;
import dao.DrugDao;
import model.Drug;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/drug/drugInfo")
public class DrugInfoServlet extends HttpServlet {
    private BasicDao<Drug> drugDao = new DrugDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));

            if (id != 0) {
                request.setAttribute("id", id);
                getServletContext().getRequestDispatcher("/drugInfo.jsp").forward(request, response);
            } else {
//                request.setAttribute("id", id);
                getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
            }

        } catch (Exception ex) {
            getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);

        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response){

    }
}

