package services;

import models.Client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class ClientService {


    EntityManagerFactory emf = Persistence.createEntityManagerFactory("NewPersistenceUnit");

    EntityManager em = emf.createEntityManager();

    public Client Authentifier(Client c) {

        Query query = em.createNativeQuery("select * from client where email = ? and mot_pass = ?",Client.class);
        query.setParameter(1,c.getEmail());
        query.setParameter(2,c.getMotPass());
        List<Client> tab = query.getResultList();
        if(!tab.isEmpty()) {
            //System.out.println(tab.get(0).getNom());
            return tab.get(0);
        }
        else
            return null;
    }
}
