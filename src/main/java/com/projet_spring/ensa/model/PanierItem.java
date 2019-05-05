package com.projet_spring.ensa.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class PanierItem implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "panier_id")
    private Panier panier;

    @Id
    @ManyToOne
    @MapsId("produit_id")
    @JoinColumn(name = "produit_id")
    private Produit produit;

    private long qte;

    public PanierItem() {
    }

    public Panier getPanier() {
        return panier;
    }

    public void setPanier(Panier panier) {
        this.panier = panier;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public long getQte() {
        return qte;
    }

    public void setQte(long qte) {
        this.qte = qte;
    }
}
