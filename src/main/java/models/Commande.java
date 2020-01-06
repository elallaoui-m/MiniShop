package models;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
public class Commande {
    private int idCommande;
    private Date dateCommande;
    private Client clientByIdClient;
    private Collection<Lignecommandes> lignecommandesByIdCommande;

    @Id
    @Column(name = "id_commande", nullable = false)
    public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    @Basic
    @Column(name = "date_commande", nullable = true)
    public Date getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Commande commande = (Commande) o;

        if (idCommande != commande.idCommande) return false;
        if (dateCommande != null ? !dateCommande.equals(commande.dateCommande) : commande.dateCommande != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCommande;
        result = 31 * result + (dateCommande != null ? dateCommande.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_client", referencedColumnName = "id_client")
    public Client getClientByIdClient() {
        return clientByIdClient;
    }

    public void setClientByIdClient(Client clientByIdClient) {
        this.clientByIdClient = clientByIdClient;
    }

    @OneToMany(mappedBy = "commandeByIdCommande")
    public Collection<Lignecommandes> getLignecommandesByIdCommande() {
        return lignecommandesByIdCommande;
    }

    public void setLignecommandesByIdCommande(Collection<Lignecommandes> lignecommandesByIdCommande) {
        this.lignecommandesByIdCommande = lignecommandesByIdCommande;
    }
}
