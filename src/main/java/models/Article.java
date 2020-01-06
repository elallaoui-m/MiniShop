package models;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;

@Entity
public class Article {
    private int codeArticle;
    private String designation;
    private Integer prix;
    private Integer stock;
    private byte[] photo;
    private Categorie categorieByIdCat;
    private Collection<Lignecommandes> lignecommandesByCodeArticle;

    @Id
    @Column(name = "code_Article", nullable = false)
    public int getCodeArticle() {
        return codeArticle;
    }

    public void setCodeArticle(int codeArticle) {
        this.codeArticle = codeArticle;
    }

    @Basic
    @Column(name = "designation", nullable = true, length = 50)
    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Basic
    @Column(name = "prix", nullable = true, precision = 0)
    public Integer getPrix() {
        return prix;
    }

    public void setPrix(Integer prix) {
        this.prix = prix;
    }

    @Basic
    @Column(name = "stock", nullable = true)
    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Basic
    @Column(name = "photo", nullable = true)
    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Article article = (Article) o;

        if (codeArticle != article.codeArticle) return false;
        if (designation != null ? !designation.equals(article.designation) : article.designation != null) return false;
        if (prix != null ? !prix.equals(article.prix) : article.prix != null) return false;
        if (stock != null ? !stock.equals(article.stock) : article.stock != null) return false;
        if (!Arrays.equals(photo, article.photo)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = codeArticle;
        result = 31 * result + (designation != null ? designation.hashCode() : 0);
        result = 31 * result + (prix != null ? prix.hashCode() : 0);
        result = 31 * result + (stock != null ? stock.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(photo);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_cat", referencedColumnName = "id_cat")
    public Categorie getCategorieByIdCat() {
        return categorieByIdCat;
    }

    public void setCategorieByIdCat(Categorie categorieByIdCat) {
        this.categorieByIdCat = categorieByIdCat;
    }

    @OneToMany(mappedBy = "articleByCodeArticle")
    public Collection<Lignecommandes> getLignecommandesByCodeArticle() {
        return lignecommandesByCodeArticle;
    }

    public void setLignecommandesByCodeArticle(Collection<Lignecommandes> lignecommandesByCodeArticle) {
        this.lignecommandesByCodeArticle = lignecommandesByCodeArticle;
    }
}
