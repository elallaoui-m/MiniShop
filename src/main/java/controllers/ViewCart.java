package controllers;

import models.Lignecommandes;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/ViewCart")
public class ViewCart extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        HttpSession session = req.getSession(false);
        List<Lignecommandes> ligne = (List<Lignecommandes>) session.getAttribute("inCart");
        double total = 0.0;

        for (Lignecommandes l:ligne
        ) {

            total += l.getQte()* l.getArticleByCodeArticle().getPrix();
        }

        req.setAttribute("total",total);
        getServletContext().getRequestDispatcher("/cart.jsp").forward(req,resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
