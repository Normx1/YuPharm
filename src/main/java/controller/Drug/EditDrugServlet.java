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

import static java.lang.Integer.getInteger;
import static java.lang.Integer.parseInt;


@WebServlet(urlPatterns = {"/drug/edit"})
public class EditDrugServlet extends HttpServlet {
    private BasicDao<Drug> drugDao = new DrugDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            System.out.println(id);
            Drug drug = drugDao.getById(id);
             if (drug != null) {
                request.setAttribute("drug", drug);
                request.getServletContext().getRequestDispatcher("/editDrug.jsp").forward(request, response);
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

            String drugName = request.getParameter("name");
            System.out.println(request.getParameter("name"));
            int count = Integer.parseInt(request.getParameter("count"));
            System.out.println("count: "+count);
            int cost = Integer.parseInt(request.getParameter("cost"));
            System.out.println("cost: "+ cost);
            byte recipe = Byte.parseByte(request.getParameter("recipe"));
            System.out.println("recipe: "+recipe);
            int id = getInteger(request.getParameter("id"));
            //TODO Не приходит ID с JSP:(
            System.out.println("id: "+ id);
            Drug drug = new Drug(id, drugName, cost, count, recipe);
            drugDao.updateById(drug);
            response.sendRedirect(request.getContextPath() + "/");
        } catch (Exception ex) {
//            getServletContext().getRequestDispatcher(request.getContextPath() + "/notfound.jsp").forward(request, response);
            System.out.println("not success" + "  " + ex);
        }
    }
}
