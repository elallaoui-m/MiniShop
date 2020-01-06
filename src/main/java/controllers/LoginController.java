package controllers;


import models.Article;
import models.Client;
import models.Lignecommandes;
import services.ClientService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/Login")
public class LoginController extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pass = req.getParameter("pass");
        String user = req.getParameter("email");
        Client c ;
        if((c = checkInfo(user,pass)) != null)
        {
            HttpSession oldSession = req.getSession(false);
            if (oldSession != null) {
                oldSession.invalidate();
            }
            //generate a new session
            req.getSession(true);
            req.getSession(false).setAttribute("email", user);
            req.getSession(false).setAttribute("Myuser", c);
            List<Lignecommandes> inCart = new ArrayList<Lignecommandes>();
            req.getSession(false).setAttribute("inCart", inCart);
            req.getSession(false).setAttribute("nbrCart", inCart.size());
            System.out.println("forward home");
            req.getRequestDispatcher("/home").forward(req, resp);

        }

        else
        {
            System.out.println("Wrong Credentials");
            req.removeAttribute("pass");
            req.removeAttribute("email");
            req.setAttribute("correct", "0");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }

    }

    /**
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request, response);
    }

    private Client checkInfo(String user, String pass)
    {
        ClientService cs = new ClientService();


        Client c = new Client();
        c.setEmail( user);
        c.setMotPass(pass);
        c = cs.Authentifier(c);
        return c;
    }
}
