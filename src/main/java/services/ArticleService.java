package services;

import models.Article;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class ArticleService {


    EntityManagerFactory emf = Persistence.createEntityManagerFactory("NewPersistenceUnit");

    EntityManager em = emf.createEntityManager();

    public List<Article> getArticles()
    {
        TypedQuery<Article> q = em.createQuery("select a from Article a ",Article.class).setMaxResults(10);
        return q.getResultList();
    }

    public Article getArticleById(int id)
    {
        System.out.println(id);
        TypedQuery<Article> q = em.createQuery("select a from Article a where a.codeArticle = ?1",Article.class).setMaxResults(10);
        q.setParameter(1,id);
        return q.getSingleResult();
    }

    public List<Article> getArticles(int id)
    {

        CategorieService cs = new CategorieService();
        ArrayList<Article> list = new ArrayList<Article>(cs.getGategorieById(id).getArticlesByIdCat());
        return list.subList(0, Math.min(list.size()-1, 12));

    }





}
