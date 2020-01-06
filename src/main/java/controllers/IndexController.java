package controllers;

import models.Article;
import models.Categorie;
import services.ArticleService;
import services.CategorieService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/", "/home"})
public class IndexController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("Myuser") == null)
            getServletContext().getRequestDispatcher("/Login.jsp").forward(req,resp);
        else
        {

            ArticleService as = new ArticleService();
            List<Article> la;
            if (req.getParameter("f") != null)
            {
                la = as.getArticles(Integer.parseInt(req.getParameter("f")));
            }
            else
                la = as.getArticles();


            CategorieService cs = new CategorieService();
            List<Categorie> lc = cs.getCategories();

            req.setAttribute("articles",la);
            req.setAttribute("categories",lc);
            getServletContext().getRequestDispatcher("/shop.jsp").forward(req,resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
