package com.projet_spring.ensa.model;

import javax.persistence.*;

@Entity
public class ProduitPartenaire {
    @EmbeddedId
    ProduitPartenaireKey id;

    @ManyToOne
    @MapsId("partenaire_id")
    @JoinColumn(name = "partenaire_id")
    Partenaire partenaire;

    @ManyToOne
    @MapsId("produit_id")
    @JoinColumn(name = "produit_id")
    Produit produit;

    double prix;

    public ProduitPartenaireKey getId() {
        return id;
    }

    public void setId(ProduitPartenaireKey id) {
        this.id = id;
    }

    public Partenaire getPartenaire() {
        return partenaire;
    }

    public void setPartenaire(Partenaire partenaire) {
        this.partenaire = partenaire;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
}
