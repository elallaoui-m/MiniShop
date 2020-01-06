package services;

import models.Article;
import models.Categorie;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class CategorieService {


    EntityManagerFactory emf = Persistence.createEntityManagerFactory("NewPersistenceUnit");

    EntityManager em = emf.createEntityManager();


    public List<Categorie> getCategories()
    {
        TypedQuery<Categorie> q = em.createQuery("select c from Categorie c ",Categorie.class).setMaxResults(3);
        return q.getResultList();
    }

    public Categorie getGategorieById(int id)
    {

        TypedQuery<Categorie> q = em.createQuery("select c from Categorie c where c.idCat = ?1",Categorie.class).setMaxResults(3);
        q.setParameter(1,id);
        return q.getSingleResult();

    }



}
