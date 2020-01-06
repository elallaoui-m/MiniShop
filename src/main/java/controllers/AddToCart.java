package controllers;

import models.Article;
import models.Lignecommandes;
import services.ArticleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/AddToCart")
public class AddToCart extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        int code_article = Integer.parseInt(req.getParameter("code"));
        int qte = req.getParameter("quantity") == null ? 1 : Integer.parseInt(req.getParameter("quantity"));
        req.removeAttribute("quantity");


        ArticleService as = new ArticleService();
        Article article = as.getArticleById(code_article);

        HttpSession session = req.getSession(false);
        List<Lignecommandes> ligne = (List<Lignecommandes>) session.getAttribute("inCart");

        for (Lignecommandes l:ligne
             ) {
            if (l.getArticleByCodeArticle().getCodeArticle() == code_article)
            {
                l.setQte(l.getQte()+1);
                session.setAttribute("inCart",ligne);
                session.setAttribute("nbrCart",ligne.size());
                getServletContext().getRequestDispatcher("/home").forward(req,resp);
                return;
            }
        }

        Lignecommandes lignecom = new Lignecommandes();
        lignecom.setArticleByCodeArticle(article);
        lignecom.setQte(qte);
        ligne.add(lignecom);
        session.setAttribute("inCart",ligne);
        req.setAttribute("nbrCart",ligne.size());
        getServletContext().getRequestDispatcher("/home").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
