package models;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Client {
    private int idClient;
    private String email;
    private String motPass;
    private String nom;
    private String prenom;
    private String adresse;
    private String ville;
    private String tel;
    private String codePostal;
    private Collection<Commande> commandesByIdClient;

    @Id
    @Column(name = "id_client", nullable = false)
    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    @Basic
    @Column(name = "email", nullable = false, length = 50)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "mot_pass", nullable = false, length = 50)
    public String getMotPass() {
        return motPass;
    }

    public void setMotPass(String motPass) {
        this.motPass = motPass;
    }

    @Basic
    @Column(name = "nom", nullable = true, length = 25)
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Basic
    @Column(name = "prenom", nullable = true, length = 25)
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Basic
    @Column(name = "adresse", nullable = true, length = 50)
    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Basic
    @Column(name = "ville", nullable = true, length = 25)
    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    @Basic
    @Column(name = "tel", nullable = true, length = 15)
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Basic
    @Column(name = "code_postal", nullable = true, length = 10)
    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (idClient != client.idClient) return false;
        if (email != null ? !email.equals(client.email) : client.email != null) return false;
        if (motPass != null ? !motPass.equals(client.motPass) : client.motPass != null) return false;
        if (nom != null ? !nom.equals(client.nom) : client.nom != null) return false;
        if (prenom != null ? !prenom.equals(client.prenom) : client.prenom != null) return false;
        if (adresse != null ? !adresse.equals(client.adresse) : client.adresse != null) return false;
        if (ville != null ? !ville.equals(client.ville) : client.ville != null) return false;
        if (tel != null ? !tel.equals(client.tel) : client.tel != null) return false;
        if (codePostal != null ? !codePostal.equals(client.codePostal) : client.codePostal != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idClient;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (motPass != null ? motPass.hashCode() : 0);
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (prenom != null ? prenom.hashCode() : 0);
        result = 31 * result + (adresse != null ? adresse.hashCode() : 0);
        result = 31 * result + (ville != null ? ville.hashCode() : 0);
        result = 31 * result + (tel != null ? tel.hashCode() : 0);
        result = 31 * result + (codePostal != null ? codePostal.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "clientByIdClient")
    public Collection<Commande> getCommandesByIdClient() {
        return commandesByIdClient;
    }

    public void setCommandesByIdClient(Collection<Commande> commandesByIdClient) {
        this.commandesByIdClient = commandesByIdClient;
    }
}
