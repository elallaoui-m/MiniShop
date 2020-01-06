package models;

import javax.persistence.*;

@Entity
public class Lignecommandes {
    private Integer qte;
    private int idLigne;
    private Commande commandeByIdCommande;
    private Article articleByCodeArticle;

    @Basic
    @Column(name = "Qte", nullable = true)
    public Integer getQte() {
        return qte;
    }

    public void setQte(Integer qte) {
        this.qte = qte;
    }

    @Id
    @Column(name = "id_ligne", nullable = false)
    public int getIdLigne() {
        return idLigne;
    }

    public void setIdLigne(int idLigne) {
        this.idLigne = idLigne;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lignecommandes that = (Lignecommandes) o;

        if (idLigne != that.idLigne) return false;
        if (qte != null ? !qte.equals(that.qte) : that.qte != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = qte != null ? qte.hashCode() : 0;
        result = 31 * result + idLigne;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_commande", referencedColumnName = "id_commande", nullable = false)
    public Commande getCommandeByIdCommande() {
        return commandeByIdCommande;
    }

    public void setCommandeByIdCommande(Commande commandeByIdCommande) {
        this.commandeByIdCommande = commandeByIdCommande;
    }

    @ManyToOne
    @JoinColumn(name = "code_article", referencedColumnName = "code_Article", nullable = false)
    public Article getArticleByCodeArticle() {
        return articleByCodeArticle;
    }

    public void setArticleByCodeArticle(Article articleByCodeArticle) {
        this.articleByCodeArticle = articleByCodeArticle;
    }
}
