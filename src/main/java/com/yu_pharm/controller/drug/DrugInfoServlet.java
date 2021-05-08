package com.yu_pharm.controller.drug;

import com.yu_pharm.dao.BasicDao;
import com.yu_pharm.dao.DrugDao;
import com.yu_pharm.model.Drug;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/drug/drugInfo")
public class DrugInfoServlet extends HttpServlet {

    private BasicDao<Drug> drugDao = new DrugDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            System.out.println(id);
            Drug drug = drugDao.getById(id);
            if (id != 0) {
                request.setAttribute("drugs", drug);
                RequestDispatcher dispatcher
                        = this.getServletContext().getRequestDispatcher("/drugInfo.jsp");
                dispatcher.forward(request, response);
             } else {
//                request.setAttribute("id", id);
                getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
        }
    }

}


